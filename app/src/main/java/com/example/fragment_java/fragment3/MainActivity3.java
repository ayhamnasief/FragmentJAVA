package com.example.fragment_java.fragment3;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fragment.R;

public class MainActivity3 extends AppCompatActivity implements NameFragment3.OnFragmentClickListener {
LinearLayout ll3;
TextView tv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ll3 = findViewById(R.id.ll3);
        tv_name = findViewById(R.id.tv_text_name);

        getSupportFragmentManager().beginTransaction().replace(R.id.ll3, new NameFragment3()).commit();
    }

    @Override
    public void onFragmentInteraction(Name3 name) {
        tv_name.setText(name.getName());
    }
}