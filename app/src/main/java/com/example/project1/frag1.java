package com.example.project1;
import android.annotation.SuppressLint;
import android.content.Intent;
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
    ArrayList<String> tampungList = new ArrayList<>();
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
        switch (v.getId()){
            case R.id.proses:
                resultView.setText("");
                String text = inputText.getText().toString();
                DataSingleton.data.add(text);
                DataSingleton.adapter.notifyDataSetChanged();

                ArrayList<String> tp = new ArrayList();
                UbahArray UbahPragrafKeArray = new UbahArray();
                UbahPragrafKeArray.setKata(text);
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
                    resultView.setText(resultView.getText().toString()+" "+filterKata.exe2().get(i));
                }
                break;
        }



    }

}







