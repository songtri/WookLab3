package wook.song.s301047817.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* Wook Song, 301047817, Section 2 */
public class WookViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public WookViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}