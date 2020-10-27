package wook.song.s301047817.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* Wook Song, 301047817, Section 2 */
public class S301047817ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public S301047817ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}