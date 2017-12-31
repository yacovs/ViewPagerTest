package yacov.sapiashvili.viewpager.asynctasks;

import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import  yacov.sapiashvili.viewpager.asynctasks.callbacks.LoadingDataCallback;
import  yacov.sapiashvili.viewpager.model.DLAddr;
import  yacov.sapiashvili.viewpager.model.DLCat;
import  yacov.sapiashvili.viewpager.model.DLObject;
import  yacov.sapiashvili.viewpager.utilities.Utils;

/**
 * Created by yaacovs on 28/12/2017.
 */

public class GetDataAsyncTask extends AsyncTask<String,Void,String> {

    LoadingDataCallback callback;
    Context mContext;
    public GetDataAsyncTask(LoadingDataCallback callback) {
        this.callback = callback;
    }
    //constractor use for loading muckup data from assates folder
    public GetDataAsyncTask(LoadingDataCallback callback, Context mContext) {
        this.callback = callback;
        this.mContext = mContext;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            Thread.sleep(1000);
            return Utils.loadMockupData(mContext);
        } catch (InterruptedException e) {
            e.printStackTrace();
            callback.loadFailed(e.getMessage());
            return null;
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(s==null){
            callback.loadFailed("Some error");
        }else{
            try {
                JSONObject jsonData = new JSONObject(s);
                JSONObject dataBody = jsonData.getJSONObject("DO");
                JSONArray mDLObjectJSONList = dataBody.getJSONArray("DLObject");
                JSONArray mDLCatJSONList = dataBody.getJSONArray("DLCat");
                ArrayList<DLCat> mDLCatList = new ArrayList<>();
                ArrayList<DLObject> mDLObjectList = new ArrayList<>();
                mDLObjectList = getDLObjectListFromJSON(mDLObjectJSONList);
                mDLCatList = getDLCatListFromJSON(mDLCatJSONList);
                for(int i=0 ; i<mDLCatList.size();i++){
//                    for(int j=0;j<mDLObjectList.size();j++){
//                        if(mDLCatList.get(i).getmCatId()==mDLObjectList.get(j).getmCatId()){
//                            mDLCatList.get(i).getmDLObject().add(mDLObjectList.get(j));
//                        }
//                    }
                    mDLCatList.get(i).setmDLObject(mDLObjectList);
                }
                callback.loadFinish(mDLCatList);
            } catch (JSONException e) {
                e.printStackTrace();
                callback.loadFailed(e.getMessage());
            }
        }
    }

    private ArrayList<DLAddr> getDLAddrListFromJSON(JSONArray mDLAddrJSONList) throws JSONException {
        ArrayList<DLAddr> mDLAddrList = new ArrayList<>();
        for(int i=0;i<mDLAddrJSONList.length();i++){
            JSONObject AddrJSON = mDLAddrJSONList.getJSONObject(i);
            String addr ="";
            String dad = "";
            if(!AddrJSON.isNull("Addr")){
                addr = AddrJSON.getString("Addr");
            }
            if(!AddrJSON.isNull("DAd")) {
                dad = AddrJSON.getString("DAd");
            }
             mDLAddrList.add(new DLAddr(addr,dad));
        }
        return mDLAddrList;
    }
    private ArrayList<DLCat> getDLCatListFromJSON(JSONArray mDLCatJSONList) throws JSONException {
        ArrayList<DLCat> mDLCatList = new ArrayList<>();
        for(int i=0;i<mDLCatJSONList.length();i++){
            JSONObject mDLCatJSONObject = mDLCatJSONList.getJSONObject(i);
            mDLCatList.add(new DLCat(mDLCatJSONObject.getInt("CatId"),
                    mDLCatJSONObject.getString("CTitle") ));
        }
        return mDLCatList;
    }
    private ArrayList<DLObject> getDLObjectListFromJSON(JSONArray mDLObjectJSONList) throws JSONException {
        ArrayList<DLObject> mDLObjectList = new ArrayList<>();
        for(int i=0;i<mDLObjectJSONList.length();i++){
            JSONObject mDLJSONObject = mDLObjectJSONList.getJSONObject(i);
            JSONArray mDLAddrJSONList = mDLJSONObject.getJSONArray("DLAddr");
            mDLObjectList.add(new DLObject(
                    mDLJSONObject.getInt("CatId"),
                    mDLJSONObject.getString("Tt"),
                    mDLJSONObject.getString("STt"),
                    mDLJSONObject.getString("Im"),
                    mDLJSONObject.getInt("Id"),
                    getDLAddrListFromJSON(mDLAddrJSONList)));
        }
        return mDLObjectList;
    }

}
