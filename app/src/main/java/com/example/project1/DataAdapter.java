package com.example.project1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    private ArrayList<DataParagrafInput> dataList;

    public DataAdapter(ArrayList<DataParagrafInput> dataArrayList) {
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_data, parent, false);
        return new DataViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder dataViewHolder, int position) {
        dataViewHolder.txtData.setText(dataList.get(position).getData());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class DataViewHolder extends RecyclerView.ViewHolder{
        TextView txtData;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            txtData= itemView.findViewById(R.id.textData);
        }
    }
}
