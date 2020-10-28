package wook.song.s301047817.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import wook.song.s301047817.R;

/* Wook Song, 301047817, Section 2 */
public class S301047817Fragment extends Fragment {

    private S301047817ViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(S301047817ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_s301047817, container, false);
        final TextView textView = root.findViewById(R.id.wookTweenText);
//        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.rotation);
        textView.startAnimation(anim);

        return root;
    }
}