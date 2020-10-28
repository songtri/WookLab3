package wook.song.s301047817.ui.dashboard;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(SongViewModel.class);
        View root = inflater.inflate(R.layout.fragment_song, container, false);

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
                        TakeCamera();
                }
            }
        });
        return root;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQUEST_CODE:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    TakeCamera();
                }
                break;
            default:
                break;
        }
    }

    private void TakeCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, TAKE_PICTURE);
    }
}