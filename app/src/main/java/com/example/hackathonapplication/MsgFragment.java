package com.example.hackathonapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MsgFragment extends Fragment {

    public static MsgFragment Instance(String name) {
        Bundle args = new Bundle();
        args.putString("name", name);
        MsgFragment fragment = new MsgFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.msg_fragment, container,false);
        return view;
    }
}
