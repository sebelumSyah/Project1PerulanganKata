package com.example.project1;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<String> rvData;
    private List<String> rvDate;
    private Context context;


    public RecyclerViewAdapter(List<String> inputData, List<String> inputDate) {

        rvData = inputData;
        rvDate = inputDate;
    }

    public RecyclerViewAdapter(List<String> inputData, List<String> inputDate, Context context) {

        rvData = inputData;
        rvDate = inputDate;
        this.context=context;
    }
    public  interface ItemClickListener{
        void onClick(View view, int position, boolean isLongClick);
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView tvTitle;
        TextView tvSubtitle;
        private ItemClickListener itemClickListener;

        public ViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tv_title);
            tvSubtitle = (TextView) v.findViewById(R.id.tv_subtitle);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }
        public void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener=itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),true);
            return true;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // membuat view baru
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        

        final String name = rvData.get(position);
        holder.tvTitle.setText(rvData.get(position));
        holder.tvSubtitle.setText(rvDate.get(position));
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(isLongClick){
                    Intent intent=new Intent(context, DetailActivity1.class);
                    intent.putExtra(DetailActivity1.EXRA_DATA,holder.tvTitle.getText());
                    intent.putExtra(DetailActivity1.EXTRA_WAKTU,holder.tvSubtitle.getText());
                    context.startActivity(intent);
                }
                else {
                    Intent intent=new Intent(context, DetailActivity1.class);
                    intent.putExtra(DetailActivity1.EXRA_DATA,holder.tvTitle.getText());
                    intent.putExtra(DetailActivity1.EXTRA_WAKTU,holder.tvSubtitle.getText());
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return rvData.size();
    }




}