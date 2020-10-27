package wook.song.s301047817.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import wook.song.s301047817.R;

/* Wook Song, 301047817, Section 2 */
public class WookFragment extends Fragment {

    private WookViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(WookViewModel.class);
        View root = inflater.inflate(R.layout.fragment_wook, container, false);
        final TextView textView = root.findViewById(R.id.wookTextHome);
        /*
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        */
        textView.setText(String.format("%s\n%s", getString(R.string.myname), getString(R.string.studentid)));
        Button button = (Button)root.findViewById(R.id.wookButtonClearDrawing);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });

        return root;
    }

    public void OnClickClearDrawing(View view) {

    }
}