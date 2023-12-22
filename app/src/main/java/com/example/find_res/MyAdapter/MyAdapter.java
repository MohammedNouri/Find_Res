package com.example.find_res.MyAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.find_res.R;
import com.example.find_res.model.Magasin;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomView>{
    List<Magasin> magasinList;

    public MyAdapter(List<Magasin> magasinList) {
        this.magasinList = magasinList;
    }

    public static class CustomView extends RecyclerView.ViewHolder{
        TextView textView1,textView2,textView3;
        public CustomView(View v){
            super(v);
            textView1 = v.findViewById(R.id.nomTextView);
            textView2 = v.findViewById(R.id.adresseTextView);
            textView3 = v.findViewById(R.id.telephoneTextView);
        }
    }
    @Override
    public CustomView onCreateViewHolder(ViewGroup parent, int position){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_magasin_item,parent,false);
        return  new CustomView(view);
    }
    @Override
    public void onBindViewHolder(CustomView holder, int position){
        holder.textView1.setText(magasinList.get(position).getName());
        holder.textView2.setText(magasinList.get(position).getAdresse());
        holder.textView3.setText(String.valueOf(magasinList.get(position).getTel()));
    }
    @Override
    public int getItemCount(){
        return magasinList.size();
    }
}



