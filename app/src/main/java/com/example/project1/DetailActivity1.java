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
import static com.example.project1.DataSingleton.adapter;

public class DetailActivity1 extends AppCompatActivity {
    private TextView textData, textOutput, textWaktu;
    public static final String EXRA_DATA = "extra data";
    public static final String EXTRA_WAKTU = "extra_waktu";
    private RecyclerView View,View1,View2;
    private RecyclerView.LayoutManager layoutManager;
    private ListViewAdapter adapter2;
    private ListSumViewAdapter adapter3;
    private ListIndexViewAdapter adapter4;
    private ArrayList<String> DataArrayList;
    private ArrayList<String> DataArrayList1;
    private ArrayList<String> DataArrayList2;
    private String KalimatUtama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail");
        }
        String kalimat = getIntent().getStringExtra(EXRA_DATA);
        KalimatUtama=kalimat;
        textData = findViewById(R.id.textData);
        textData.setText(kalimat);
        textOutput = findViewById(R.id.textOutput);
        ArrayList<String> tp = new ArrayList();
        UbahArray UbahPragrafKeArray = new UbahArray();
        UbahPragrafKeArray.setKata(kalimat);
        filterKata filterKata = new filterKata();
        String[] tampung = UbahPragrafKeArray.arrayWithStrip();
        if (tampung[tampung.length - 1].contains(".") == false) {
            tampung[tampung.length - 1] = tampung[tampung.length - 1] + ".";
        } else {
            tampung[tampung.length - 1] = tampung[tampung.length - 1];
        }
        for (int i = 0; i < tampung.length - 1; i++) {
            filterKata.setKata1(tampung[i]);
            filterKata.setKata2(tampung[i + 1]);
            if (filterKata.exe() == true) {
                if (tampung[i].length() < tampung[i + 1].length()) {
                    tampung[i] = "";
                } else if (tampung[i].length() > tampung[i + 1].length()) {
                    tampung[i + 1] = "";
                } else {
                    tampung[i] = "";
                }
            }
        }
        for (int i = 0; i < tampung.length; i++) {
            if (!"".equals(tampung[i])) {
                tp.add(tampung[i]);
            }
        }
        filterKata.setArray1(tp);
        for (int i = 0; i < filterKata.exe2().size(); i++) {
            textOutput.setText(textOutput.getText().toString() + " " + filterKata.exe2().get(i));
        }
        textWaktu = findViewById(R.id.textWaktu);
        String waktu = getIntent().getStringExtra(EXTRA_WAKTU);
        textWaktu.setText(waktu);

        addData();
        View = (RecyclerView) findViewById(R.id.rv_kata);
        adapter2 = new ListViewAdapter(DataArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DetailActivity1.this);
        View.setLayoutManager(layoutManager);
        View.setAdapter(adapter2);

        addData1();
        View1=findViewById(R.id.rv_jumlah);
        adapter3 = new ListSumViewAdapter(DataArrayList1);
        RecyclerView.LayoutManager layoutManager1 =new LinearLayoutManager(DetailActivity1.this);
        View1.setLayoutManager(layoutManager1);
        View1.setAdapter(adapter3);

        addData2();
        View2=findViewById(R.id.rv_index);
        adapter4 = new ListIndexViewAdapter(DataArrayList2);
        RecyclerView.LayoutManager layoutManager2 =new LinearLayoutManager(DetailActivity1.this);
        View2.setLayoutManager(layoutManager2);
        View2.setAdapter(adapter4);
    }
    void addData(){
        DataArrayList=new ArrayList<String>();
        ArrayList<String> A=new ArrayList<String>();
        UbahArray ubahArray = new UbahArray();
        ubahArray.setKata(KalimatUtama);
        A=ubahArray.cariElemenSamaBerurutan(ubahArray.arrayFix(ubahArray.arrayWithouthAll()));
        for(int i=0; i<ubahArray.elemenSama(A).size();i++){
            DataArrayList.add(ubahArray.elemenSama(A).get(i));
        }
    }
    void addData1(){
        DataArrayList1=new ArrayList<String>();
        ArrayList<String> A=new ArrayList<String>();
        UbahArray ubahArray = new UbahArray();
        ubahArray.setKata(KalimatUtama);
        A=ubahArray.cariElemenSamaBerurutan(ubahArray.arrayFix(ubahArray.arrayWithouthAll()));
        for(int i=0; i<ubahArray.elemenSama(A).size();i++) {
            DataArrayList1.add(ubahArray.Jumlah(A).get(i));
        }
    }
    void addData2(){
        DataArrayList2=new ArrayList<String>();
        ArrayList<String> A=new ArrayList<String>();
        UbahArray ubahArray = new UbahArray();
        ubahArray.setKata(KalimatUtama);
        A=ubahArray.cariElemenSamaBerurutan(ubahArray.arrayFix(ubahArray.arrayWithouthAll()));
        ArrayList<String> B=ubahArray.elemenSama(A);
        ArrayList<String> C=ubahArray.arrayFix(ubahArray.arrayWithStrip());
        ArrayList<String> D= new ArrayList();
        filterKata amin= new filterKata();
        for(int i=0; i<B.size();i++){
            for(int j=0; j<C.size();j++){
                amin.setKata1(B.get(i));
                amin.setKata2(C.get(j));
                if(amin.exe()==true){
                    D.add(Integer.toString(j));
                    break;
                }
            }
        }
        for(int i=0; i<D.size();i++){
            DataArrayList2.add(D.get(i));
        }
    }
}







