package com.example.fragment_java.fragment2;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragment.R;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
LinearLayout ll2;
RecyclerView rv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ll2 = findViewById(R.id.ll2);
        rv2 = findViewById(R.id.rv2);

        ArrayList<Name2> names = new ArrayList<>();
        names.add(new Name2("Jack"));
        names.add(new Name2("Margie"));
        names.add(new Name2("George"));
        names.add(new Name2("Marieta"));

        NameAdapter2 adapter = new NameAdapter2(names, new ListenerInterface2() {
            @Override
            public void customClick(Name2 name) {
                Toast.makeText(MainActivity2.this, ""+name.getName(), Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.ll2, NameFragment2.newInstance(name.getName())).commit();

            }
        });
        rv2.setAdapter(adapter);
        rv2.setLayoutManager(new LinearLayoutManager(this));
        rv2.setHasFixedSize(true);

    }
}