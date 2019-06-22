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
        String pgBaru= getKata().replaceAll("[^a-zA-Z0-9 -.:,;]", " ");
        String [] arrayAwal=pgBaru.split(" ");
        return arrayAwal;
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
}
