package org.techtown.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = (Fragment1)getSupportFragmentManager().findFragmentById(R.id.fragment1);
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onButton1();
//            }
//        });
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onButton2();
//            }
//        });
    }

    public void onButton1() {
        button1.setTypeface(Typeface.create("",Typeface.BOLD));
        button1.setTextColor(Color.RED);
        button2.setTypeface(Typeface.create("",Typeface.NORMAL));
        button2.setTextColor(Color.BLACK);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
    }

    public void onButton2() {
        button1.setTypeface(Typeface.create("",Typeface.NORMAL));
        button1.setTextColor(Color.BLACK);
        button2.setTypeface(Typeface.create("",Typeface.BOLD));
        button2.setTextColor(Color.RED);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment3).commit();
    }

    public void onGotoMainFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
    }
}