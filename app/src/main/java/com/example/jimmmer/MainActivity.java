package com.example.jimmmer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jimmmer.adapter.AdapterForWorkoutList;
import com.example.jimmmer.applicationClass.MyApplicationClass;
import com.example.jimmmer.model.WorkOutBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //
        recyclerView = findViewById(R.id.recycleViewMainActivity);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        adapter = new AdapterForWorkoutList(this, MyApplicationClass.exercisesChosenList);
        recyclerView.setAdapter(adapter);
    }
}