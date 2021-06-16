package org.techtown.exam210616;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        editText = (EditText) findViewById(R.id.editTextTextPersonName);
//        editText2 = (EditText) findViewById(R.id.editTextTextPersonName2);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = editText.getText().toString();
                String PW = editText2.getText().toString();
//                if(ID.length() < 1 || PW.length() < 1)
                if(editText.equals("") || editText2.equals("") ) {
                    Toast.makeText(getApplicationContext(),"아이디 패스워드를 입력하세요.", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivityForResult(intent, 101);
                Toast.makeText(getApplicationContext(), "관리메뉴화면", Toast.LENGTH_LONG).show();
//                intent.putExtra("ID",ID);
//                intent.putExtra("PW",PW);
            }
        });
    }
}