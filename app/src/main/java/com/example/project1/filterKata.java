package com.example.project1;

import java.util.ArrayList;

public class filterKata {
    String kata1,kata2;
    ArrayList<String> array1;

    public ArrayList<String> getArray1() {
        return array1;
    }

    public void setArray1(ArrayList<String> array1) {
        this.array1 = array1;
    }

    public String getKata1() {
        return kata1;
    }

    public void setKata1(String kata1) {
        this.kata1 = kata1;
    }

    public String getKata2() {
        return kata2;
    }

    public void setKata2(String kata2) {
        this.kata2 = kata2;
    }

    public boolean exe(){
        if(getKata1().length()<getKata2().length()){
            int bil1=getKata2().length();
            int bil2=((bil1-1)/2);
            if(getKata2().contains("-") && getKata2().contains(".")==false){
                if(getKata1().equals(getKata2().substring(0,bil2))&& getKata1().equals(getKata2().substring(bil2+1,bil1))){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else if(getKata1().length()>getKata2().length()){
            int bil1=getKata1().length();
            int bil2=((bil1-1)/2);
            if(getKata1().contains("-")){
                if(getKata2().equals(getKata1().substring(0,bil2))&&getKata2().equals(getKata1().substring(bil2+1,bil1))){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else{
            if(getKata1().equals(getKata2())){
                return true;
            }
            else{
                return false;
            }
        }

    }
    public ArrayList<String> exe2(){
        ArrayList<String> tampung= new ArrayList();
        tampung.add(getArray1().get(0));
        for(int i=1; i<getArray1().size();i++){
            if(getArray1().get(i).contains(".")||getArray1().get(i).contains(",")){
                tampung.add(getArray1().get(i));

            }
            else{
                String kata1=getArray1().get(i);
                String kata2=getArray1().get(i+1).replaceAll("[.,]", "");
                filterKata dia = new filterKata();
                dia.setKata1(kata1);
                dia.setKata2(kata2);
                if(dia.exe()==false){
                    tampung.add(getArray1().get(i));
                }

            }

        }

        return tampung;
    }
}
