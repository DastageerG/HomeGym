package com.example.jimmmer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

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

    private Button buttonCountMinus, buttonCountPlus, buttonShowNoOFCount;
    private ImageButton buttonStart;
    // buttonShowNoOFCount could have been taken as textView but button look better in terms of design
    private int setsCount = 1;
    private int totalWorkoutMinutes = 0;
    private TextView textViewMinutes;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //
        recyclerView = findViewById(R.id.recycleViewMainActivity);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        textViewMinutes = findViewById(R.id.textViewMainActivityNoOfMinutes);
        buttonCountMinus = findViewById(R.id.buttonMainActivityCountMinus);
        buttonCountPlus = findViewById(R.id.buttonMainActivityCountPlus);
        buttonShowNoOFCount = findViewById(R.id.buttonMainActivityShowCount);
        buttonStart = findViewById(R.id.buttonMainActivityStartWorkout);


        adapter = new AdapterForWorkoutList(this, MyApplicationClass.exercisesChosenList);
        recyclerView.setAdapter(adapter);

        totalWorkoutMinutes+=MyApplicationClass.minutes;

        textViewMinutes.setText("total Minutes "+totalWorkoutMinutes+":00");


        buttonCountMinus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (setsCount > 1)
                {
                    setsCount--;
                    totalWorkoutMinutes-=MyApplicationClass.minutes;
                    textViewMinutes.setText("total Minutes "+totalWorkoutMinutes+":00");
                    buttonShowNoOFCount.setText(""+setsCount);
                }
            }
        });

        buttonCountPlus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                    setsCount++;
                    totalWorkoutMinutes+=MyApplicationClass.minutes;
                    textViewMinutes.setText("total Minutes "+totalWorkoutMinutes+":00");
                    buttonShowNoOFCount.setText(""+setsCount);

            } // on click closed
        }); //  buttonCountPlus closed

        buttonStart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this,WorkoutActivity.class);
                overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
                startActivity(intent);
            }
        });
    } // onCreate closed
} // Main closed