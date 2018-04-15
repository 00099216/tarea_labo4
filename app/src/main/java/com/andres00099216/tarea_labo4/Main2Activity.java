package com.andres00099216.tarea_labo4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class Main2Activity extends AppCompatActivity {

    TextView textViewContent;
    TextView textViewName;
    ImageView imageView;
    Serializable info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textViewName = findViewById(R.id.nombre_planeta);
        imageView=findViewById(R.id.foto);
        textViewContent=findViewById(R.id.relleno_xd);
        Intent callingIntent = getIntent();
        if (callingIntent.getSerializableExtra("Info") instanceof Serializable){
            handleRecivedObject(callingIntent);
        }
    }

    private void handleRecivedObject(Intent intent){
        info=intent.getSerializableExtra("Info");
        Info info1 =(Info)info;
        String textName = info1.getName();
        textViewName.setText(textName);
        textViewContent.setText(info1.getContent());
        imageView.setImageResource(info1.getImageView());


    }

}