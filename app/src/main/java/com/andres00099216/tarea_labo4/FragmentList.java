package com.andres00099216.tarea_labo4;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class FragmentList extends ListFragment implements AdapterView.OnItemClickListener {

    Info info;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment, container, false);
    }




    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter arrayAdapter=ArrayAdapter.createFromResource(getActivity(), R.array.sistema, android.R.layout.simple_list_item_1);
        setListAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        info =new Info();
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
            Intent newIntent = new Intent(getActivity().getApplicationContext(), Main2Activity.class);
            setPlanetContent(position, parent);
            newIntent.putExtra("Info", info);
            startActivity(newIntent);

        }else if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            Bundle bundle = new Bundle();
            setPlanetContent(position, parent);
            bundle.putSerializable("Info", info);
            FragmentViewer frag = new FragmentViewer();
            frag.setArguments(bundle);
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.view, frag);
            fragmentTransaction.commit();
        }
    }







    private void setPlanetContent(int i,AdapterView parent){
        info.setIndice(i);
        info.setName(parent.getItemAtPosition(i).toString());
        System.out.println(info.getName());
    }

}
