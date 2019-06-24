package com.example.project1;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import org.w3c.dom.Text;
import java.util.ArrayList;

public class frag1 extends Fragment implements View.OnClickListener {
    Button proses;
    EditText inputText;
    TextView resultView;

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag1_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inputText = (EditText) view.findViewById(R.id.inputText);
        resultView = (TextView) view.findViewById(R.id.resultView);
        proses = (Button) view.findViewById(R.id.proses);

        proses.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        resultView.setText("");
        String text = inputText.getText().toString();
        ArrayList<String> tp = new ArrayList();
        UbahArray jodoh = new UbahArray();
        jodoh.setKata(text);
        filterKata dia = new filterKata();
        String [] tampung =jodoh.arrayWithStrip();
        if(tampung[tampung.length-1].contains(".")==false){
            tampung[tampung.length-1]=tampung[tampung.length-1]+".";
        }else{ tampung[tampung.length-1]=tampung[tampung.length-1];}
        for(int i=0; i<tampung.length-1;i++){
            dia.setKata1(tampung[i]);
            dia.setKata2(tampung[i+1]);
            if(dia.exe()==true){
                if(tampung[i].length()<tampung[i+1].length()){
                    tampung[i]=""; }
                else if(tampung[i].length()>tampung[i+1].length()){
                    tampung[i+1]="";}
                else{ tampung[i]=""; } } }
        for (int i=0; i<tampung.length;i++) {
            if(!"".equals(tampung[i])){
                tp.add(tampung[i]); } }
        dia.setArray1(tp);
        for(int i=0; i<dia.exe2().size();i++){
            resultView.setText(resultView.getText().toString()+" "+dia.exe2().get(i));
        }
    }
}







