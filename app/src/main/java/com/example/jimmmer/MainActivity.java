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
    private Button buttonCountMinus, buttonCountPlus, buttonShowNoOFCount; // button showing Number of count of sets
    private ImageButton buttonStart;
    // buttonShowNoOFCount could have been taken as textView but button look better in terms of design
    private int setsCount = 1; // minimum 1 set is must , not less than that

    private int totalWorkoutMinutes = 0; // count  for total number of minutes in each set

    private TextView textViewMinutes; // textView showing Minutes

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleViewMainActivity);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        textViewMinutes = findViewById(R.id.textViewMainActivityNoOfMinutes);
        buttonCountMinus = findViewById(R.id.buttonMainActivityCountMinus);
        buttonCountPlus = findViewById(R.id.buttonMainActivityCountPlus);
        buttonShowNoOFCount = findViewById(R.id.buttonMainActivityShowCount);
        buttonStart = findViewById(R.id.buttonMainActivityStartWorkout);

                                                                    // getting the List from MyApplication class
        adapter = new AdapterForWorkoutList(this, MyApplicationClass.exercisesChosenList);
        recyclerView.setAdapter(adapter);

        totalWorkoutMinutes=MyApplicationClass.minutes;
        /*
        initially totalWorkoutMinutes will be equal to minutes from MyApplication class
        */

        textViewMinutes.setText("total Minutes "+totalWorkoutMinutes+":00");


        buttonCountMinus.setOnClickListener(new View.OnClickListener() // subtract no of sets when  clicked
        {
            @Override
            public void onClick(View v)
            {
                if (setsCount > 1) // no of sets can not be less than 1
                {
                    setsCount--;
                    totalWorkoutMinutes-=MyApplicationClass.minutes; // decreasing minutes as set decreased
                    textViewMinutes.setText("total Minutes "+totalWorkoutMinutes+":00");
                    buttonShowNoOFCount.setText(""+setsCount);
                } // if closed
            } // onclick closed
        }); // buttonCount minus closed

        buttonCountPlus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                    setsCount++;
                    totalWorkoutMinutes+=MyApplicationClass.minutes; // increasing minutes as set increased
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
                intent.putExtra("noOfSets",setsCount); // sending no of Sets to the WorkoutOutActivity
                startActivity(intent);
                overridePendingTransition(R.anim.enter_from_right,R.anim.exit_out_left);
            } // onclick closed
        }); // button start closed

    } // onCreate closed
} // Main closed