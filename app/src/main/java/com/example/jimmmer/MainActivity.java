package com.example.jimmmer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jimmmer.adapter.AdapterForWorkoutList;
import com.example.jimmmer.model.WorkOutBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<WorkOutBean>exercisesChosenList;
    private int random_exercise;
    private List<Integer> listOfNumbersGenerated = new ArrayList();
    private WorkOutBean[] totalExercisesArray =
            {
                    new WorkOutBean("Bench Press",R.drawable.bench_press,3) ,
                    new WorkOutBean("Bicep Curl",R.drawable.bicep_curl,3) ,
                    new WorkOutBean("Chest Press",R.drawable.chest_press,2) ,
                    new WorkOutBean("Crunches",R.drawable.crunches,3) ,
                    new WorkOutBean("Forward Bend",R.drawable.forward_bend,1) ,
                    new WorkOutBean("Incline Chest Press",R.drawable.incline_chest_press,2) ,
                    new WorkOutBean("Push Ups",R.drawable.push_up,1) ,
                    new WorkOutBean("Renegade Row",R.drawable.renegade_row,4) ,
                    new WorkOutBean("Seated Cable Row",R.drawable.seated_cable_row,3) ,
                    new WorkOutBean("Side Stretch",R.drawable.side_strech,2) ,
                    new WorkOutBean("Sit Ups",R.drawable.situps,3) ,
                    new WorkOutBean("Swiss Ball Push Ups",R.drawable.swiss_ball_push_up,2) ,
                    new WorkOutBean("Tree Pose",R.drawable.tree_pose,1) ,
                    new WorkOutBean("Vertical Leg Crunch",R.drawable.vertical_leg_crunch,2)
            };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //
        exercisesChosenList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycleViewMainActivity);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        Random random = new Random();

        for(int i = 0;i<5;i++)
        {
            random_exercise = random.nextInt(13); // is of Int type
            listOfNumbersGenerated.add(random_exercise);
            exercisesChosenList.add(totalExercisesArray[random_exercise]);
        } //

        adapter = new AdapterForWorkoutList(this,exercisesChosenList);
        recyclerView.setAdapter(adapter);
    }
}