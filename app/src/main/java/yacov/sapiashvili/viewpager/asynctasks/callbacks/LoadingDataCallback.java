package yacov.sapiashvili.viewpager.asynctasks.callbacks;

import java.util.ArrayList;
import yacov.sapiashvili.viewpager.model.DLCat;
import yacov.sapiashvili.viewpager.model.DLObject;

/**
 * Created by yaacovs on 28/12/2017.
 *
 */

public interface LoadingDataCallback {
    void loadFinish(ArrayList<DLCat> mDLCat);
    void loadFailed(String msg);
}
