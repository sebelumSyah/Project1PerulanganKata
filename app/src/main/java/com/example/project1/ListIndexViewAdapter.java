package com.example.project1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListIndexViewAdapter extends RecyclerView.Adapter<ListIndexViewAdapter.ListIndexViewHolder> {
private List<String> rvIndex;
    public ListIndexViewAdapter(ArrayList<String> inputIndex){
        rvIndex=inputIndex;
    }
    @NonNull
    @Override
    public ListIndexViewAdapter.ListIndexViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_index, parent, false);
        return new ListIndexViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListIndexViewAdapter.ListIndexViewHolder listIndexViewHolder, int i) {
        listIndexViewHolder.tv_index.setText(rvIndex.get(i));
    }

    @Override
    public int getItemCount() {
        return rvIndex.size();
    }

    public class ListIndexViewHolder extends RecyclerView.ViewHolder {
        TextView tv_index;
        public ListIndexViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_index=itemView.findViewById(R.id.tv_index);
        }
    }
}
