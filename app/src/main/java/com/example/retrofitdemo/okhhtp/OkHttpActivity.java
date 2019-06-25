package com.example.retrofitdemo.okhhtp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.retrofitdemo.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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
        loadApi = (Button) findViewById(R.id.loadApi);

        loadApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                   getHttpResponse();

                   txtMessage.setText(mMessage);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    public void getHttpResponse() throws IOException {

        String url = "https://simplifiedcoding.net/demos/marvel/";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .build();

//        Response response = client.newCall(request).execute();
//        Log.e(TAG, response.body().string());

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String mMessage = e.getMessage().toString();
                Log.w("failure Response", mMessage);
                //call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                mMessage = response.body().string();
                Log.e(TAG, mMessage);
            }
        });
    }
}