package com.cec.doctor.Main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.cec.doctor.R;
import com.cec.doctor.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, AdapterView.OnItemClickListener {
    SearchView editSearch;
    ListViewAdapter adapter1;
    String[]  animalNameList;
    ArrayList<PatientNames> arraylist = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_mainhome);

//        Data sample.
        animalNameList = new String[]{"Madilu system","Tiger Wodds","Snopp Dogg",
                "Free Town","Mbilia Mbel","Kanda Bongoman","Alan Jackson","John Walker",
                "Jack Daniels","Rikochet Mark","Monry Hassan"};

        //        edit_text
        ListView list = findViewById(R.id.listview);
        editSearch = findViewById(R.id.search);

        list.setTextFilterEnabled(true);
        list.setOnItemClickListener(this);


        for (String s : animalNameList) {
            PatientNames patientNames = new PatientNames(s);
//            binds  strings
            arraylist.add(patientNames);
        }
//        pass results to listViewAdapter class
        adapter1 = new ListViewAdapter(this,arraylist);
        list.setAdapter(adapter1);
        editSearch.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter1.filter(newText);
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent,View view,int position,long id) {

        String TempListViewClickedValue = animalNameList [position];

        Intent intent = new Intent();
        intent.setClass(this, User.class);
        // Sending value to another activity using intent.
        intent.putExtra("ListViewClickedValue", TempListViewClickedValue);


        startActivity(intent);
    }
}
