package com.example.fragment_java.fragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.fragment.R;

public class NameFragment2 extends Fragment {
    private static final String ARG_NAME = "name";
    private String mName;

    public NameFragment2() {
        // Required empty public constructor
    }

    public static NameFragment2 newInstance(String name) {
        NameFragment2 fragment = new NameFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mName = getArguments().getString(ARG_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment2_name, container, false);
        TextView name = v.findViewById(R.id.fragment2_tv_name);
        name.setText(mName);
        return v;
    }
}