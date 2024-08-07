package com.example.fragment_java.fragment6;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.fragment.R;

public class CustomDialogFragment extends DialogFragment {

    private static final String ARG_TITLE = "title";
    private static final String ARG_SMS = "sms";
    private static final String ARG_ICON = "icon";

    OnPositiveClicked positiveClicked;

    private String mTitle;
    private String mSms;
    private int mIcon;

    public CustomDialogFragment() {
    }
    public static CustomDialogFragment newInstance(String title, String sms, int icon) {
        CustomDialogFragment fragment = new CustomDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_SMS, sms);
        args.putInt(ARG_ICON, icon);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(ARG_TITLE);
            mSms = getArguments().getString(ARG_SMS);
            mIcon = getArguments().getInt(ARG_ICON);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.custom_dialog_layout, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tv_title = view.findViewById(R.id.dialog_tv_title);
        TextView tv_sms = view.findViewById(R.id.dialog_tv_sms);
        EditText et_content = view.findViewById(R.id.dialog_et_content);
        Button btn_ok = view.findViewById(R.id.dialog_btn_ok);

        tv_title.setText(mTitle);
        tv_sms.setText(mSms);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positiveClicked.onPositiveBtnClicked(et_content.getText().toString());
                dismiss();
            }
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof OnPositiveClicked){
            positiveClicked = (OnPositiveClicked) context;
        }else {
            throw new RuntimeException("Please implement listener: Positive");
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        positiveClicked = null;
    }

    public interface OnPositiveClicked{void onPositiveBtnClicked(String txt);}
}