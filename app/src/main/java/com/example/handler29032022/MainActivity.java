package com.example.handler29032022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyThread myThread = new MyThread(new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                if (msg.what == 1) {
                    Bundle bundle = msg.getData();
                    int total = bundle.getInt("total");
                    Toast.makeText(MainActivity.this, total + "", Toast.LENGTH_SHORT).show();
                }
                super.handleMessage(msg);
            }
        });
        myThread.start();
    }
}
