package com.example.project1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends  RecyclerView.Adapter<ListViewAdapter.ListViewHolder>{
    private List<String> rvKata;

    public ListViewAdapter(ArrayList<String> dataArrayList) {
        rvKata=dataArrayList;
    }


    @NonNull
    @Override
    public ListViewAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_kata, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewAdapter.ListViewHolder listViewHolder, int position) {
        listViewHolder.tv_kata.setText(rvKata.get(position));
    }

    @Override
    public int getItemCount() {
        return  rvKata.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tv_kata;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_kata=itemView.findViewById(R.id.tv_kata);

        }
    }
}
