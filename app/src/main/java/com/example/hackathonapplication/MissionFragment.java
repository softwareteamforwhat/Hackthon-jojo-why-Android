package com.example.hackathonapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MissionFragment extends Fragment {

    public static MissionFragment Instance(String name) {
        Bundle args = new Bundle();
        args.putString("name", name);
        MissionFragment fragment = new MissionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.mission_fragment, container,false);
        return view;
    }
}
