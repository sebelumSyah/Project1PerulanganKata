package com.example.project1;

import java.util.ArrayList;

public class UbahArray {
    String kata;

    public String getKata() {
        return kata;
    }

    public void setKata(String kata) {
        this.kata = kata;
    }

    public String[] arrayWithouthAll(){
        String pgBaru= getKata().replaceAll("[^a-zA-Z0-9]", " ");
        String[] arrayAwal=pgBaru.split(" ");

        return arrayAwal;
    }

    public String [] arrayWithoutStrip(){
        String pgBaru= getKata().replaceAll("[^a-zA-Z0-9 ]", "");
        String [] arrayAwal=pgBaru.split(" ");
        return arrayAwal;
    }
    public String [] arrayWithStrip(){
        String pgBaru= getKata().replaceAll("[^a-zA-Z0-9 -.:,;?!]", " ");
        String [] arrayAwal=pgBaru.split(" ");
        return arrayAwal;
    }
    public ArrayList<String> arrayFix(String[] temp){
        ArrayList<String> hasil = new ArrayList();
        for(int i=0 ;i<temp.length;i++){
            if(!"".equals(temp[i])){
                hasil.add(temp[i]);
            }
        }
        return hasil;
    }
    public ArrayList<String> cariElemenSamaBerurutan(){
        ArrayList<String> arraySama = new ArrayList<String>();
        for(int i=0; i<arrayWithouthAll().length-1;i++){
            if(arrayWithouthAll()[i].equalsIgnoreCase(arrayWithouthAll()[i+1])
                    ||arrayWithouthAll()[i+1].equalsIgnoreCase(arrayWithouthAll()[i])){
                arraySama.add(arrayWithouthAll()[i]);
                arraySama.add(arrayWithouthAll()[i+1]);
            }

        }
        return arraySama;
    }
    public ArrayList<String> cariElemenSamaBerurutan(ArrayList<String> temp){
        UbahArray jodoh = new UbahArray();
        ArrayList<String> arraySama = new ArrayList<String>();
        if(temp.get(0).equalsIgnoreCase(temp.get(1))){
            arraySama.add(temp.get(0));
        }
        for(int i=1; i<temp.size()-1;i++){
            if(temp.get(i).equalsIgnoreCase(temp.get(i+1))
                    ||temp.get(i).equalsIgnoreCase(temp.get(i-1))){
                arraySama.add(temp.get(i));
            }
        }
        if(temp.get(temp.size()-1).equalsIgnoreCase(temp.get(temp.size()-2))){
            arraySama.add(temp.get(temp.size()-1));
        }
        return arraySama;
    }
    public ArrayList<String> Jumlah(ArrayList<String> temp){
        ArrayList<String> Hasil= new ArrayList();
        int k=1;
        for(int i=0; i<temp.size()-1;i++){
            if(temp.get(i).equals(temp.get(i+1))){
                k=k+1;
                if(i==temp.size()-2){
                    Hasil.add(Integer.toString(k));}}
            else{
                Hasil.add(Integer.toString(k));
                k=1;}}
        return Hasil;
    }
    public ArrayList<String> elemenSama(ArrayList<String> temp){
        ArrayList<String> Hasil1= new ArrayList();
        for(int i=0; i<temp.size()-1;i++){
            if(temp.get(i).equalsIgnoreCase(temp.get(i+1))==false){
                Hasil1.add(temp.get(i));
            }
            else{

            }
        }
        Hasil1.add(temp.get(temp.size()-1));
        return Hasil1;
    }
}
