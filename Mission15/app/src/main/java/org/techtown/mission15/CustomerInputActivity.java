package org.techtown.mission15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomerInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_input);

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainInputActivity();
            }
        });


    }
    public void goToMainInputActivity() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent); //엑티비티간 화면전환
        overridePendingTransition(R.anim.entry2, R.anim.exit2); //첫번째자리:현화면 두번째자리:전환될화면
    }
}