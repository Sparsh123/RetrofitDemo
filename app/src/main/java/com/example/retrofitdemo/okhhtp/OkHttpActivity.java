package com.example.retrofitdemo.okhhtp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.retrofitdemo.R;
import com.example.retrofitdemo.retrofit.Api;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class OkHttpActivity extends AppCompatActivity {

    private static final String TAG = "Response";
    Button loadApi;
    String mMessage;
    TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_activity);
        txtMessage = findViewById(R.id.txtMessage);
        loadApi = findViewById(R.id.loadApi);

        Api.getOkHTTPClient(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String mMessage = e.getMessage();
                Log.w("failure Response", mMessage);
                //call.cancel();

                txtMessage.setText(mMessage);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                mMessage = response.body().string();
                Log.e(TAG, mMessage);
            }
        });
    }
}