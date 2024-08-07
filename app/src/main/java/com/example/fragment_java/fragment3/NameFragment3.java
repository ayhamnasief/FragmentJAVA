package com.example.fragment_java.fragment3;

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

public class NameFragment3 extends Fragment {
    private static final String ARG_NAME = "name";
    OnFragmentClickListener onFragmentClickListener;
    private String mName;

    public NameFragment3() {
    }
    public static NameFragment3 newInstance(String name) {
        NameFragment3 fragment = new NameFragment3();
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
        View v = inflater.inflate(R.layout.fragment3_name, container, false);

        RecyclerView rv3 = v.findViewById(R.id.rv3);

        ArrayList<Name3> names = new ArrayList<>();
        names.add(new Name3("Jack"));
        names.add(new Name3("Margie"));
        names.add(new Name3("George"));
        names.add(new Name3("Marieta"));

        NameAdapter3 adapter3 = new NameAdapter3(names, new ListenerInterface3() {
            @Override
            public void cutomOnClick(Name3 name) {
                Toast.makeText(getActivity(), ""+name.getName(), Toast.LENGTH_SHORT).show();
                onFragmentClickListener.onFragmentInteraction(name);
                }
        });

        rv3.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv3.setHasFixedSize(true);
        rv3.setAdapter(adapter3);
        return v;
    }

    public interface OnFragmentClickListener{
        void onFragmentInteraction(Name3 name);
    }
}