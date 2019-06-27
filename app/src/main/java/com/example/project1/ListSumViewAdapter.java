package com.example.project1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListSumViewAdapter extends RecyclerView.Adapter<ListSumViewAdapter.ListSumViewHolder> {
    private List<String> rvSum;

    public ListSumViewAdapter(ArrayList<String> DataArrayList1){
        rvSum=DataArrayList1;
    }

    @NonNull
    @Override
    public ListSumViewAdapter.ListSumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_sum, parent, false);
        return new ListSumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListSumViewAdapter.ListSumViewHolder listSumViewHolder, int position) {
        listSumViewHolder.tv_sum.setText(rvSum.get(position));

    }

    @Override
    public int getItemCount() {
        return rvSum.size();
    }

    public class ListSumViewHolder extends RecyclerView.ViewHolder {
        TextView tv_sum;
        public ListSumViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_sum=itemView.findViewById(R.id.tv_sum);
        }
    }
}
