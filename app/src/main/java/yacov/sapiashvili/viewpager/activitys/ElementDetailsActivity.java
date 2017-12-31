package yacov.sapiashvili.viewpager.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import yacov.sapiashvili.viewpager.R;
import yacov.sapiashvili.viewpager.model.DLCat;

/**
 * Created by yaacovs on 30/12/2017.
 */

public class ElementDetailsActivity extends AppCompatActivity {
    TextView mCatTitle;
    TextView mDLObjectID;
    ImageView mDLObjectPic;
    int catid;
    int objectid;
    String objectImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clickdetails);
        Bundle bundle = getIntent().getExtras();
        catid = bundle.getInt("DLCatID",-1);
        objectid = bundle.getInt("DLObjectID",-1);
        objectImage = bundle.getString("DLObjectImage",null);
        mCatTitle = (TextView) findViewById(R.id.DLCatID);
        mCatTitle.setText(String.valueOf(catid));
        mDLObjectID = (TextView) findViewById(R.id.DLObjectID);
        mDLObjectID.setText(String.valueOf(objectid));
        mDLObjectPic = (ImageView) findViewById(R.id.DLObjectPic);

        Glide.with(this).load(objectImage).into(mDLObjectPic);
    }
}
