package org.techtownw.mission03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView01;
    ImageView imageView02;
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView01 = findViewById(R.id.imageView01);
        imageView02 = findViewById(R.id.imageView02);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveImageUp();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveImageDown();
            }
        });
    }

    private void moveImageDown() {
        imageView01.setImageResource(0);
        imageView02.setImageResource(R.drawable.image01);

        imageView01.invalidate();
        imageView02.invalidate();
    }

    private void moveImageUp() {
        imageView01.setImageResource(R.drawable.image01);
        imageView02.setImageResource(0);

        imageView01.invalidate();
        imageView02.invalidate();
    }
}