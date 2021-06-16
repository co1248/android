package org.techtown.exam210616;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent receiveIntent = getIntent();
        String ID = receiveIntent.getStringExtra("ID");
        String PW = receiveIntent.getStringExtra("PW");

        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "고객관리화면", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), CustomerActivity.class);
                startActivityForResult(intent, 102);
                finish();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "매출관리화면", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), CustomerActivity.class);
                startActivityForResult(intent, 103);
                finish();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "상품관리화면", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), CustomerActivity.class);
                startActivityForResult(intent, 104);
                finish();
            }
        });
    }
}