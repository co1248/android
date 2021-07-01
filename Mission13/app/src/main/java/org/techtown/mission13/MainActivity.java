package org.techtown.mission13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    EditText editText3;
    TextView textView;
    RecyclerView recyclerView;
    CustomerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        textView = findViewById(R.id.textView);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CustomerAdapter();

        adapter.addItem(new Customer("김준수", "1995-10-20", "010-1000-1000", R.drawable.customer));
        adapter.addItem(new Customer("홍길동", "1996-10-20", "010-2000-2000", R.drawable.customer));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnCustomerItemClickListener() {
            @Override
            public void onItemClick(CustomerAdapter.ViewHorder holder, View view, int position) {
                Customer item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "아이템 선택됨 : " + item.getName(), Toast.LENGTH_LONG).show();
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                String birth = editText2.getText().toString();
                String mobile = editText3.getText().toString();

                adapter.addItem(new Customer(name, birth, mobile, R.drawable.customer));
                adapter.notifyDataSetChanged(); //알려줘야 정상적으로 작동

                textView.setText(adapter.getItemCount() + "명"); //변경된 값을 표시하도록 세팅

                recyclerView.smoothScrollToPosition(adapter.getItemCount()-1);
            }
        });
    }
}