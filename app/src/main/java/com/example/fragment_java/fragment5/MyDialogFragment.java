package com.example.fragment_java.fragment5;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.fragment.R;

public class MyDialogFragment extends DialogFragment {

    private static final String ARG_TITLE = "title";
    private static final String ARG_SMS = "sms";
    private static final String ARG_ICON = "icon";

    OnPositiveClicked positiveClicked;
    OnNegativeClicked negativeClicked;
    OnNeutralClicked neutralClicked;

    private String mTitle;
    private String mSms;
    private int mIcon;

    public MyDialogFragment() {
    }
    public static MyDialogFragment newInstance(String title, String sms, int icon) {
        MyDialogFragment fragment = new MyDialogFragment();
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

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        builder.setTitle(mTitle);
        builder.setMessage(mSms);
        builder.setIcon(mIcon);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Call from Fragment: Clicked on positive button", Toast.LENGTH_SHORT).show();
                positiveClicked.onPositiveBtnClicked();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                negativeClicked.onNegativeBtnClicked();
            }
        });
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });
        return builder.create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.my_fragment_dialog, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof OnPositiveClicked){
            positiveClicked = (OnPositiveClicked) context;
        }else {
            throw new RuntimeException("Please implement listener: Positive");
        }

        if(context instanceof OnNegativeClicked){
            negativeClicked = (OnNegativeClicked) context;
        }else {
            throw new RuntimeException("Please implement listener: Negative");
        }

        if(context instanceof OnNeutralClicked){
            neutralClicked = (OnNeutralClicked) context;
        }else {
            throw new RuntimeException("Please implement listener: Neutral");
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        positiveClicked = null;
        negativeClicked = null;
        neutralClicked = null;
    }

    public interface OnPositiveClicked{void onPositiveBtnClicked();}
    public interface OnNegativeClicked{void onNegativeBtnClicked();}
    public interface OnNeutralClicked{void onNeutralBtnClicked();}
}