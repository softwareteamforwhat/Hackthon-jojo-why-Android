package com.example.hackathonapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.hackathonapplication.Home.HomeActivity;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MsgFragment extends Fragment {
    private ListView listview;
    private Context mContext;
    private SimpleAdapter simp_adapter;
    private OkHttpClient client;
    private String id;
    private String url="http://101.132.105.56/getReceivedMessage";
    private FloatingActionButton floatingActionButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        getMessage();
        View view=inflater.inflate(R.layout.msg_fragment, container,false);
        return view;

    }
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.id = ((HomeActivity) activity).getId();
        System.out.println(id);
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        floatingActionButton=getActivity().findViewById(R.id.m_main_fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("yes");
                Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_LONG).show();
            }
        });

    }
        private void getMessage() {
        new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("id", id)
                            .build();
                    Request request = new Request.Builder()
                            .url(url)
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    if(response.isSuccessful()){
                        String responseData=response.body().string();

                        System.out.println(responseData);
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
