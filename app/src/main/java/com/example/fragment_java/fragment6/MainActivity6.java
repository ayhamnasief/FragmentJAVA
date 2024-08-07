package com.example.fragment_java.fragment6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fragment.R;

public class MainActivity6 extends AppCompatActivity implements CustomDialogFragment.OnPositiveClicked {
Button btn7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        btn7 = findViewById(R.id.btn7);

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialogFragment customDialogFragment = CustomDialogFragment.newInstance("My Title", "My SMS", R.drawable.ic_launcher_foreground);
                customDialogFragment.show(getSupportFragmentManager(), "");
            }
        });
    }

    @Override
    public void onPositiveBtnClicked(String txt) {
        Toast.makeText(this, ""+ txt, Toast.LENGTH_SHORT).show();
    }
}