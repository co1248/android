package org.techtown.mission15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCustomerInputActivity();
            }
        });
    }
    public void goToCustomerInputActivity() {
        Intent intent = new Intent(getApplicationContext(), CustomerInputActivity.class);
        startActivity(intent); //엑티비티간 화면전환
        overridePendingTransition(R.anim.entry, R.anim.exit); //첫번째자리:현화면 두번째자리:전환될화면
    }
}