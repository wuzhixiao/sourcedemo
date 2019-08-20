package com.tuanshang.sourcedemo.handler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import com.tuanshang.sourcedemo.MainActivity;
import com.tuanshang.sourcedemo.R;

/*handler原理*/

public class HandlerActivity extends AppCompatActivity {

    private static Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int what = msg.what;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        //读源码入口，咔咔咔
        Looper.prepare();
        Looper.prepareMainLooper();
        Looper.loop();
        startThread();

        Intent intent = new Intent(HandlerActivity.this, MainActivity.class);
        startActivity(intent);


    }


    private void startThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //FIXME 这里直接更新ui是不行的
                //还有其他更新ui方式,runOnUiThread()等
                //方式一
                Message message = Message.obtain();
                message.what = 0x11;
                mHandler.sendMessage(message);

                //方式二
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //更新ui
                    }
                });
            }
        }).start();
    }

//    private void createHandler() {
//        HandlerThread handlerThread = new HandlerThread("myHandlerThread", Process.THREAD_PRIORITY_BACKGROUND);
//        handlerThread.start();//必须开启
//        mHandler = new Handler(handlerThread.getLooper());
//    }
}
