package org.techtown.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        PersonAdapter adapter = new PersonAdapter();

        adapter.addItem(new Person("김민수" , "010-1000-1000"));
        adapter.addItem(new Person("김하늘" , "010-2000-2000"));
        adapter.addItem(new Person("홍길동" , "010-3000-3000"));
        adapter.addItem(new Person("이순신" , "010-4000-4000"));
        adapter.addItem(new Person("김유신" , "010-5000-5000"));
        adapter.addItem(new Person("박순신" , "010-6000-6000"));
        adapter.addItem(new Person("홍길이" , "010-7000-7000"));
        adapter.addItem(new Person("홍순이" , "010-8000-8000"));
        adapter.addItem(new Person("마지막" , "010-9000-9000"));
        adapter.addItem(new Person("하나더" , "010-0000-0000"));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnPersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHorder horder, View view, int position) {
                Person item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택된 정보는 : " + item.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }
}