package com.example.retrofit;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.RowHolder> {
   private ArrayList <TimeAze > arrayList;
   private TextView text1,text2;
   private String []colors={"#33FF38","#FF33E6","#1959DC","#17A371","#EF1056","#05441E","#28D06B","#A328D0"};

    public Adapter(ArrayList<TimeAze> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.row_layout,parent,false);
        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
          holder.bind(arrayList.get(position),colors,position);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {
        public RowHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void bind(TimeAze timeAze,String [] colors,int position){
            itemView.setBackgroundColor(Color.parseColor(colors[position % 8] ));
            text1=itemView.findViewById(R.id.text1);
            text2=itemView.findViewById(R.id.text222);
            text1.setText(timeAze.getCurrency());
            text2.setText(timeAze.getPrice());
        }
    }

}
