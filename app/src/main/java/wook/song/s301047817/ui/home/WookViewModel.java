package wook.song.s301047817.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import wook.song.s301047817.R;

/* Wook Song, 301047817, Section 2 */
public class WookViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public WookViewModel() {
//        mText = new MutableLiveData<>();
//        mText.setValue(textToShow);
    }

    public LiveData<String> getText() {
        return mText;
    }
}