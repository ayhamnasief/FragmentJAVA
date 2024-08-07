package com.example.fragment_java.fragment4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragment.R;

import java.util.ArrayList;

public class NameAdapter4 extends RecyclerView.Adapter<NameAdapter4.NameHolder> {
    ArrayList<Name4> names = new ArrayList<>();
    ListenerInterface4 listenerInterface4;

    public NameAdapter4(ArrayList<Name4> names, ListenerInterface4 listenerInterface4) {
        this.names = names;
        this.listenerInterface4 = listenerInterface4;
    }

    @NonNull
    @Override
    public NameHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_name_layout, parent, false);
        return new NameHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NameHolder holder, int position) {
        Name4 name = names.get(position);
        holder.bind(name);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }


    class NameHolder extends RecyclerView.ViewHolder{
        TextView tv_name;
        Name4 name;
        public NameHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.custom_tv_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listenerInterface4.cutomOnClick(name);
                }
            });
        }
        void bind(Name4 name){
            this.name = name;
            tv_name.setText(name.getName());
        }
    }
}
