package com.andres00099216.tarea_labo4;

import java.io.Serializable;
import java.util.HashMap;

public class Info implements Serializable {

    private HashMap<Integer, Integer> imageHashMap;

    public Info(){
        init();
    }

    private void init(){
        imageHashMap=new HashMap<>();
        setID();
    }
    private void setID(){
        imageHashMap.put(0, R.drawable.sol);
        imageHashMap.put(1, R.drawable.mercurio);
        imageHashMap.put(2, R.drawable.venus);
        imageHashMap.put(3, R.drawable.tierra);
        imageHashMap.put(4, R.drawable.marte);
        imageHashMap.put(5, R.drawable.jupiter);
        imageHashMap.put(6, R.drawable.saturno);
        imageHashMap.put(7, R.drawable.urano);
        imageHashMap.put(8, R.drawable.neptuno);
    }

    private int i;
    public int getContent(){
        switch (i){
            case 0: return R.string.Sun;
            case 1: return R.string.Mercury;
            case 2: return R.string.Venus;
            case 3: return R.string.Earth;
            case 4: return R.string.Mars;
            case 5: return R.string.Jupiter;
            case 6: return R.string.Saturn;
            case 7: return R.string.Uranus;
            case 8: return R.string.Neptune;
        }
        return 9;
    }

    private String nombre;
    public void setName(String name){
        this.nombre=name;
    }

    public String getName(){
        return nombre;
    }
    public void setIndice(int indice){
        this.i=indice;
    }
    public int getImageView(){
        return imageHashMap.get(i);
    }


}
