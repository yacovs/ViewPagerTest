package yacov.sapiashvili.viewpager.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by yaacovs on 28/12/2017.
 */

public class DLObject  implements Serializable {
    private int mCatId;
    private String mTt;
    private String STt;
    private String Im;
    private int Id;
    ArrayList<DLAddr> mDLAddList =null;

    public DLObject() {
        mDLAddList = new ArrayList<>();
    }

    public DLObject(int mCatId, String mTt, String STt, String im, int id, ArrayList<DLAddr> mDLAddList) {
        this.mCatId = mCatId;
        this.mTt = mTt;
        this.STt = STt;
        Im = im;
        Id = id;
        this.mDLAddList = mDLAddList;
    }

    public int getmCatId() {
        return mCatId;
    }

    public void setmCatId(int mCatId) {
        this.mCatId = mCatId;
    }

    public String getmTt() {
        return mTt;
    }

    public void setmTt(String mTt) {
        this.mTt = mTt;
    }

    public String getSTt() {
        return STt;
    }

    public void setSTt(String STt) {
        this.STt = STt;
    }

    public String getIm() {
        return Im;
    }

    public void setIm(String im) {
        Im = im;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public ArrayList<DLAddr> getmDLAddList() {
        return mDLAddList;
    }

    public void setmDLAddList(ArrayList<DLAddr> mDLAddList) {
        this.mDLAddList = mDLAddList;
    }
}
