package com.example.hackathonapplication.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.hackathonapplication.Home.HomeActivity;
import com.example.hackathonapplication.R;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username;
    private EditText password;
    private String url="http://101.132.105.56:8080/register";
    private OkHttpClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register);
        client=new OkHttpClient();

        username=findViewById(R.id.et_register_username);


        password=findViewById(R.id.et_register_pwd_input);

        findViewById(R.id.bt_register_submit).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    String usn=username.getText().toString();
                    String psd=password.getText().toString();
                    RequestBody requestBody = new FormBody.Builder().add("username", usn).add("password", psd).build();
                    Request request = new Request.Builder().url(url).post(requestBody).build();
                    Response response = client.newCall(request).execute();
                    String respponseData = response.body().string();
                    startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }).start();
    }

}