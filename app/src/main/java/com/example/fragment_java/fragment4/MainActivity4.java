package com.example.fragment_java.fragment4;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fragment.R;

public class MainActivity4 extends AppCompatActivity implements NameFragment4.OnFragmentClickListener {
    LinearLayout ll4_1;
    LinearLayout ll4_2;
    TextView tv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ll4_1 = findViewById(R.id.ll4_1);
        ll4_2 = findViewById(R.id.ll4_2);

        getSupportFragmentManager().beginTransaction().replace(R.id.ll4_1, new NameFragment4()).commit();
    }

    @Override
    public void onFragmentInteraction(Name4 name4) {
        getSupportFragmentManager().beginTransaction().replace(R.id.ll4_2, TextFragment4.newInstance(name4.getName())).commit();
    }
}