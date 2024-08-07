package com.example.fragment_java.fragment2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragment.R;

import java.util.ArrayList;

public class NameAdapter2 extends RecyclerView.Adapter<NameAdapter2.NameHolder> {
    ArrayList<Name2> names = new ArrayList<>();
    ListenerInterface2 listenerInterface2;

    public NameAdapter2(ArrayList<Name2> names, ListenerInterface2 listenerInterface2) {
        this.names = names;
        this.listenerInterface2 = listenerInterface2;
    }

    @NonNull
    @Override
    public NameHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_name_layout, parent, false);

        return new NameHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NameHolder holder, int position) {
        Name2 name = names.get(position);
        holder.bind(name);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    class NameHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        Name2 name;

        public NameHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.custom_tv_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listenerInterface2.customClick(name);
                }
            });
        }

        void bind(Name2 name) {
            this.name = name;
            tv_name.setText(name.getName());
        }
    }
}
