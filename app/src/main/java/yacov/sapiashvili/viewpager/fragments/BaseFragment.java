package yacov.sapiashvili.viewpager.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import yacov.sapiashvili.viewpager.R;

/**
 * Created by yaacovs on 28/12/2017.
 */

public class BaseFragment extends Fragment {



    public static BaseFragment newInstance(int tabID) {
        BaseFragment baseFragment = new BaseFragment();

        Bundle args = new Bundle();
        args.putInt("id", tabID);
        baseFragment.setArguments(args);
        return baseFragment ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.basefragmant,container,false);
        if(getArguments() != null){
            int id = getArguments().getInt("id");
            //only programmers start the count in 0 :)
            id++;
            TextView text = rootView.findViewById(R.id.mCatID);
            text.setText("Tab number : "+String.valueOf(id));
        }
        return rootView;
    }
}
