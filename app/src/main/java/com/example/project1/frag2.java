package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class frag2 extends Fragment {
    private RecyclerView recyclerView;
    private DataAdapter adapter;
    private ArrayList<DataParagrafInput> DataArrayList;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag2_layout,container,false );


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyler_view);

        adapter = new DataAdapter(DataArrayList);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
    void addData(){
        DataArrayList = new ArrayList<>();
        DataArrayList .add(new DataParagrafInput("FIRMAN"));
        DataArrayList .add(new DataParagrafInput("syah"));
        DataArrayList.add(new DataParagrafInput("ilham"));
        DataArrayList .add(new DataParagrafInput("dwi"));

    }
}
