package com.andres00099216.tarea_labo4;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class FragmentViewer extends Fragment {
    TextView textViewName;
    ImageView imageView;
    TextView textViewContent;
    Serializable planet;
    Info infoP;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.viewer_fragment, container, false);
        imageView=view.findViewById(R.id.foto);
        textViewName=view.findViewById(R.id.nombre_planeta);
        textViewContent=view.findViewById(R.id.relleno_xd);
        Bundle bundle=this.getArguments();
        if(bundle!=null){
            planet=bundle.getSerializable("Info");
            infoP =(Info)planet;
            System.out.println(infoP.toString());
            textViewName.setText(infoP.getName());
            textViewContent.setText(infoP.getContent());
            imageView.setImageResource(infoP.getImageView());
        }
        return view;
    }
}
