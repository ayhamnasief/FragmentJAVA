package com.example.fragment_java.fragment5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fragment.R;

public class MainActivity5 extends AppCompatActivity implements MyDialogFragment.OnPositiveClicked, MyDialogFragment.OnNegativeClicked, MyDialogFragment.OnNeutralClicked {
Button btn5, btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(MainActivity5.this)
                        .setTitle("Confirmation")
                        .setMessage("Message to confirm")
                        .setIcon(R.drawable.ic_launcher_foreground)
                        .create();
                dialog.show();
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialogFragment myDialogFragment = MyDialogFragment.newInstance("My title", "My sms", R.drawable.ic_launcher_foreground);
                myDialogFragment.show(getSupportFragmentManager(), "");
            }
        });
    }

    @Override
    public void onPositiveBtnClicked() {
    }

    @Override
    public void onNegativeBtnClicked() {
        Toast.makeText(this, "Call from ACTIVITY: Clicked on negative button", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNeutralBtnClicked() {

    }
}