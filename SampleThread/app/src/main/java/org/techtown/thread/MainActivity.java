package org.techtown.thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int value = 0;
    TextView textView;
//    MainHandler handler;


    Handler handler = new Handler(); //추가


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Button button;
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Backgroundthread thread = new Backgroundthread();
                thread.start();
            }
        });

//        handler = new MainHandler();

    }

    class  Backgroundthread extends  Thread {
        public void run() {
            for(int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
                value += 1;
                Log.d("Thread", "value" + value);

                handler.post( //추가
                        new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(String.valueOf(value));
                            }
                        }
                );

                //textView.setText(value); // gui한 뷰들에 대한 데이터 처리를 직접하려고 하면 문제가 발생한다. main에서 처리해야 한다.
//                Message message = handler.obtainMessage();
//                Bundle bundle = new Bundle();
//                bundle.putInt("value", value);
//                message.setData(bundle);
//
//                handler.sendMessage(message);
            }
        }
    }

//    class  MainHandler extends Handler {
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//
//            Bundle bundle = msg.getData(); //bundle은 안드로이드에서 쓰는 컬렉션. Bundle은 여러가지의 타입의 값을 저장하는 Map 클래스이다
//            int value = bundle.getInt("value");
//            textView.setText(String.valueOf(value));
//        }
//    }
}