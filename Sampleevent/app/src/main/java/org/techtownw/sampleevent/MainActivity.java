package org.techtownw.sampleevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        View view = findViewById(R.id.view);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                float curX = motionEvent.getX();
                float curY = motionEvent.getY();

                if(action == MotionEvent.ACTION_DOWN) {
                    printIn("손가락 눌림 : " + curX + " , " + curY);
                } else if(action == MotionEvent.ACTION_MOVE) {
                    printIn("손가락 움직임 : " + curX + " , " + curY);
                } else if(action == MotionEvent.ACTION_UP) {
                    printIn("손가락 뗌 : " + curX + " , " + curY);
                }
                return true;
            }
        });
    }
    public  void  printIn(String data) {
        textView.append(data + "\n");
    }
}