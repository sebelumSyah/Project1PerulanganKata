package com.example.project1;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity1 extends AppCompatActivity {
    private TextView textData,textOutput,textWaktu;
    public static final String EXRA_DATA = "extra data";
    public static final String EXTRA_WAKTU= "extra_waktu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail");
        }

        textData=findViewById(R.id.textData);
        String kalimat =getIntent().getStringExtra(EXRA_DATA);
        textData.setText(kalimat);

        textOutput=findViewById(R.id.textOutput);


        ArrayList<String> tp = new ArrayList();
        UbahArray UbahPragrafKeArray = new UbahArray();
        UbahPragrafKeArray.setKata(kalimat);
        filterKata filterKata = new filterKata();
        String [] tampung =UbahPragrafKeArray .arrayWithStrip();
        if(tampung[tampung.length-1].contains(".")==false){
            tampung[tampung.length-1]=tampung[tampung.length-1]+".";
        }else{ tampung[tampung.length-1]=tampung[tampung.length-1];}
        for(int i=0; i<tampung.length-1;i++){
            filterKata.setKata1(tampung[i]);
            filterKata.setKata2(tampung[i+1]);
            if(filterKata.exe()==true){
                if(tampung[i].length()<tampung[i+1].length()){
                    tampung[i]=""; }
                else if(tampung[i].length()>tampung[i+1].length()){
                    tampung[i+1]="";}
                else{ tampung[i]=""; }
            }
        }
        for (int i=0; i<tampung.length;i++) {
            if(!"".equals(tampung[i])){
                tp.add(tampung[i]); }
        }
        filterKata.setArray1(tp);
        for(int i=0; i<filterKata.exe2().size();i++){
            textOutput.setText(textOutput.getText().toString()+" "+filterKata.exe2().get(i));
        }
        textWaktu=findViewById(R.id.textWaktu);
        String waktu=getIntent().getStringExtra(EXTRA_WAKTU);
        textWaktu.setText(waktu);

    }





    }

