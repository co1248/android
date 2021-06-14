package org.techtownw.sampleevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    GestureDetector detector;

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

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener) {
            @Override
            public boolean onDown(MosionEvent mosionEvent) {
                printIn("onDown() 호출됨.");

                return true;
            }


            @Override
            public void onShowPress(MosionEvent mosionEvent) {
                printIn("onShowPress() 호출됨.");
            }

            @Override
            public boolean onSingleTapUp(MosionEvent mosionEvent) {
                printIn("onSingleTapUp() 호출됨.");

                return true;
            }

            @Override
            public boolean onScroll(MosionEvent mosionEvent, MosionEvent mosionEvent1, float v, float v1) {
                printIn("onScroll() 호출됨." + v + " , " + v1);

                return true;
            }

            @Override
            public void onLongPress(MosionEvent mosionEvent) {
                printIn("onLongPress() 호출됨.");
            }

            @Override
            public boolean onFling(MosionEvent mosionEvent, MosionEvent mosionEvent1, float v, float v1) {
                printIn("onFling() 호출됨." + v + " , " + v1);

                return true;
            }
        });

        View view2 = findViewByid(R.id.view2);
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MosionEvent mosionEvent) {
                detector.onTouchEvent(mosionEvent);
                return true;
            }
        });

    }
    public  void  printIn(String data) {
        textView.append(data + "\n");
    }
}