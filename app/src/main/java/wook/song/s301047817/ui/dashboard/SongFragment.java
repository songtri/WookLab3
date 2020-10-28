package wook.song.s301047817.ui.dashboard;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import wook.song.s301047817.R;

/* Wook Song, 301047817, Section 2 */
public class SongFragment extends Fragment {

    private SongViewModel dashboardViewModel;
    private final int REQUEST_CODE = 1234;
    private final int TAKE_PICTURE = 1;
    ArrayAdapter spinnerAnimPlayTimeAdapter;
    private float animPlayTime;
    AnimationDrawable mframeAnimation = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(SongViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_song, container, false);

        Button takePictureButton = root.findViewById(R.id.wookTakePicture);
        takePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hasPermission = 0;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    hasPermission = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA);

                    if (hasPermission != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_CODE);
                        return;
                    }
                    else
                        takeCamera();
                }
            }
        });

        Button animStartButton = root.findViewById(R.id.wookBtnAniStart);
        animStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();
            }
        });
        Button animStopButton = root.findViewById(R.id.wookBtnAniStop);
        animStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAnimation();
            }
        });

        Spinner penThickness = root.findViewById(R.id.wookSpinnerAnimPlayTime);
        spinnerAnimPlayTimeAdapter = ArrayAdapter.createFromResource(getContext(), R.array.wookAniPlayTime, android.R.layout.simple_spinner_dropdown_item);
        penThickness.setAdapter(spinnerAnimPlayTimeAdapter);
        penThickness.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value = (String)spinnerAnimPlayTimeAdapter.getItem(i);
                animPlayTime = Float.parseFloat(value);
                buildAnimation(root, animPlayTime);
                Log.i("WookLab3", value);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                animPlayTime = 1;
            }
        });

        buildAnimation(root, 1f);

        return root;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQUEST_CODE:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    takeCamera();
                }
                break;
            default:
                break;
        }
    }

    private void takeCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, TAKE_PICTURE);
    }

    private void buildAnimation(View view, float animPlayTime) {
        ImageView img = (ImageView)view.findViewById(R.id.wookAnimationImage);

        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim1);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim2);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim3);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim4);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim5);
        BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim6);
        BitmapDrawable frame7 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim7);
        BitmapDrawable frame8 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim8);
        BitmapDrawable frame9 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim9);

        // Get the background, which has been compiled to an AnimationDrawable object.
        int frameDuration = (int)(animPlayTime * 1000f / 9f);
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);	// loop continuously
        mframeAnimation.addFrame(frame1, frameDuration);
        mframeAnimation.addFrame(frame2, frameDuration);
        mframeAnimation.addFrame(frame3, frameDuration);
        mframeAnimation.addFrame(frame4, frameDuration);
        mframeAnimation.addFrame(frame5, frameDuration);
        mframeAnimation.addFrame(frame6, frameDuration);
        mframeAnimation.addFrame(frame6, frameDuration);
        mframeAnimation.addFrame(frame7, frameDuration);
        mframeAnimation.addFrame(frame8, frameDuration);
        mframeAnimation.addFrame(frame9, frameDuration);

        img.setBackground(mframeAnimation);
    }

    private void startAnimation() {
        if(!mframeAnimation.isRunning()) {
            Log.i("WookLab3", "animation start");
            mframeAnimation.setVisible(true, true);
            mframeAnimation.start();
        }
    }

    private void stopAnimation() {
        Log.i("WookLab3", "animation stop");
        mframeAnimation.stop();
    }
}