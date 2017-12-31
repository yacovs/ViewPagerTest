package yacov.sapiashvili.viewpager.model;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by yaacovs on 28/12/2017.
 */

public class DLCat  implements Serializable {
    private static final long serialVersionUID = 7964723302423222327L;
    private int mCatId;
    private String mCTitle;
    ArrayList<DLObject>mDLObject;

    public DLCat(int mCatId, String mCTitle,ArrayList<DLObject> mDLObject) {
        this.mCatId = mCatId;
        this.mCTitle = mCTitle;
        this.mDLObject = mDLObject;
    }
    public DLCat(int mCatId, String mCTitle) {
        this.mCatId = mCatId;
        this.mCTitle = mCTitle;
        this.mDLObject = new ArrayList<>();
    }

    public ArrayList<DLObject> getmDLObject() {
        return mDLObject;
    }

    public void setmDLObject(ArrayList<DLObject> mDLObject) {
        this.mDLObject = mDLObject;
    }

    public int getmCatId() {
        return mCatId;
    }

    public void setmCatId(int mCatId) {
        this.mCatId = mCatId;
    }

    public String getCTitle() {
        return mCTitle;
    }

    public void setCTitle(String CTitle) {
        this.mCTitle = CTitle;
    }
}
