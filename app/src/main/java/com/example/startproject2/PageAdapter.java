package com.example.startproject2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class PageAdapter extends RecyclerView.Adapter<PageAdapter.CustomViewHolder>implements OnPersonItemClickListener {

    private ArrayList<Page> arrayListpage;
    OnPersonItemClickListener listener;

    public PageAdapter(ArrayList<Page> arrayListpage) {
        this.arrayListpage = arrayListpage;
    }

    @NonNull
    @Override
    public PageAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pageitem,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PageAdapter.CustomViewHolder holder, int position) {

        holder.txtpage.setText(Integer.toString(arrayListpage.get(position).getPagenum()));


    }

    @Override
    public int getItemCount() {
        return (arrayListpage != null ? arrayListpage.size() : 0);
    }

    public void setItemClickListener(OnPersonItemClickListener listener){
        this.listener = listener;
    }

    @Override
    public void OnItemClick(CustomViewHolder holder, View view, int position) {
        if(listener!=null){
            listener.OnItemClick(holder, view, position);
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView txtpage;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtpage=(TextView) itemView.findViewById(R.id.txtpage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAbsoluteAdapterPosition();
                    if (position!=RecyclerView.NO_POSITION){
                        if (listener!=null){
                            listener.OnItemClick (CustomViewHolder.this,view,position);
                        }
                    }
                }
            });
        }
    }
    public Page getItem(int position) {return arrayListpage.get(position);}
}
