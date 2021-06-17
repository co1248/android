package org.techtown.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MainFragment mainFragment;
    MenuFragment  menuFragment;
    CustomerFragment customerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = (MainFragment)getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        menuFragment = new MenuFragment();
        customerFragment = new CustomerFragment();
    }

    public void onFragmentChanged(int idx) {
        if(idx == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,menuFragment).commit();
        } else if(idx == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,mainFragment).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,customerFragment).commit();
        }
    }
}
