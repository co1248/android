package org.techtownw.samplescrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    ScrollView scrollView;
    ImageView imageView;
    BitmapDrawable bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = findViewById(R.id.scrollView);
        imageView = findViewById(R.id.imageView);
        scrollView.setHorizontalScrollBarEnabled(true);
        //좌우로 스크롤 하는 기능을 황성화하겠다.
        Resources res = getResources();
        //getResources를 쓰면 자원을 호출해서 리소스들을 사용할 수 있다.
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image01);
        //코드상에서 이미지 불러오기
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();
        //원본 이미지의 크기를 불러온다.

        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmapWidth;
        imageView.getLayoutParams().height = bitmapHeight;
        //원본 이미지의 가로세로 크기를 넣어줘야 한다.(아니면 화면에 맞춰서 이미지가 들어간다)
    }
    public void onButton1Clicked(View v) {
        changeImage();
    }

    int imageIndex = 0;

    public void changeImage() {
        Resources res = getResources();

        if(imageIndex == 0) {
            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image01);

            imageIndex = 1;
        } else if(imageIndex == 1) {
            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image02);

            imageIndex = 0;
        }
//        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image02);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmapWidth;
        imageView.getLayoutParams().height = bitmapHeight;
    }
}