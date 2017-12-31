package yacov.sapiashvili.viewpager.views;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import javax.xml.transform.Templates;

import yacov.sapiashvili.viewpager.R;
import yacov.sapiashvili.viewpager.activitys.ElementDetailsActivity;
import yacov.sapiashvili.viewpager.adapters.DLObjectsAdapter;
import yacov.sapiashvili.viewpager.model.DLObject;

/**
 * Created by yaacovs on 30/12/2017.
 */

public class DLObjectViewHolder extends RecyclerView.ViewHolder{
    TextView mTitle;
    TextView mSubTitle;
    ImageView mImage;
    public void setTitle(String mTitle) {
        this.mTitle.setText(mTitle);
    }

    public void setSubTitle(String mSubTitle) {
        this.mSubTitle.setText(mSubTitle);
    }

    public void setImage(String imgUrl) {
        Glide.with(mImage.getContext()).load(imgUrl).into(mImage);
    }

    public DLObjectViewHolder(View itemView) {
        super(itemView);
        mTitle = (TextView) itemView.findViewById(R.id.title);
        mSubTitle = (TextView) itemView.findViewById(R.id.subtitle);
        mImage = (ImageView)itemView.findViewById(R.id.image);
    }

}
