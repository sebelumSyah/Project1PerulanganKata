package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.project1.R.layout.frag2_layout;

public class frag2 extends Fragment   {

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(frag2_layout,container,false );

    }

    private RecyclerView rvView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvView = (RecyclerView) view.findViewById(R.id.rv_main);
        rvView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this.getContext());
        rvView.setLayoutManager(layoutManager);

        DataSingleton.adapter = new RecyclerViewAdapter(DataSingleton.data,DataSingleton.date,this.getContext());
        rvView.setAdapter(DataSingleton.adapter);




    }



}



