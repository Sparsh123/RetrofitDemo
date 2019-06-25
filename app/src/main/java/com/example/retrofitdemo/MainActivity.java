package com.example.retrofitdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.retrofitdemo.okhhtp.OkHttpActivity;
import com.example.retrofitdemo.retrofit.RetrofitActivity;

public class MainActivity extends AppCompatActivity {

     Button btnOkHttp;
    Button btnRetroFit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOkHttp = findViewById(R.id.btnOkHttp);
        btnRetroFit=findViewById(R.id.btnRetroFit);

        btnOkHttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OkHttpActivity.class);
                startActivity(intent);
            }
        });

        btnRetroFit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RetrofitActivity.class);
                startActivity(intent);
            }
        });
    }
}
