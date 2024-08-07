package com.example.fragment_java.fragment4;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragment.R;

import java.util.ArrayList;


public class NameFragment4 extends Fragment {
    private static final String ARG_NAME = "name";
    OnFragmentClickListener onFragmentClickListener;
    private String mName;

    public NameFragment4() {
    }
    public static NameFragment4 newInstance(String name) {
        NameFragment4 fragment = new NameFragment4();
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
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentClickListener){
            onFragmentClickListener = (OnFragmentClickListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onFragmentClickListener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment4_name, container, false);

        RecyclerView rv4 = v.findViewById(R.id.rv4);

        ArrayList<Name4> names = new ArrayList<>();
        names.add(new Name4("Jack"));
        names.add(new Name4("Margie"));
        names.add(new Name4("George"));
        names.add(new Name4("Marieta"));

        NameAdapter4 adapter4 = new NameAdapter4(names, new ListenerInterface4() {
            @Override
            public void cutomOnClick(Name4 name) {
                Toast.makeText(getActivity(), "From Fragment to activity: "+name.getName(), Toast.LENGTH_SHORT).show();
                onFragmentClickListener.onFragmentInteraction(name);
            }
        });

        rv4.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv4.setHasFixedSize(true);
        rv4.setAdapter(adapter4);
        return v;
    }

    public interface OnFragmentClickListener{
        void onFragmentInteraction(Name4 name);
    }
}