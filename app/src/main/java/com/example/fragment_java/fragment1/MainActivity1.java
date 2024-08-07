package com.example.fragment_java.fragment1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fragment.R;

public class MainActivity1 extends AppCompatActivity {
Button btn1, btn2;
LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        ll = findViewById(R.id.ll);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.ll, new FragmentX()).addToBackStack(null).commit();
                Toast.makeText(MainActivity1.this,  "Hi", Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.ll, new FragmentY()).addToBackStack(null).commit();
            }
        });
    }
}