package com.example.handler29032022;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class MyThread extends Thread{
    private Handler handler;

    MyThread(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        int total = 0;
        for (int i = 0 ; i < 50 ; i++) {
            total += i;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Message message = new Message();
        message.what = 1;
        Bundle bundle = new Bundle();
        bundle.putInt("total", total);
        message.setData(bundle);
        handler.sendMessage(message);
        super.run();
    }

}
