package com.example.fragment_java.fragment4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.fragment.R;

public class TextFragment4 extends Fragment {
    private static final String ARG_TEXT_NAME = "name";
    private String mName;

    public TextFragment4() {
    }
    public static TextFragment4 newInstance(String name) {
        TextFragment4 fragment = new TextFragment4();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mName = getArguments().getString(ARG_TEXT_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_text4, container, false);
        TextView tv_text_name = v.findViewById(R.id.tv_text_name);
        tv_text_name.setText(mName);
        return v;
    }
}