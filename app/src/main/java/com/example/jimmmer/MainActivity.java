package com.example.jimmmer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jimmmer.model.WorkOutBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private ListView listView;
    private List<WorkOutBean>exercisesChosenList;
    private int random_exercise;
    private List<Integer> listOfNumbersGenerated = new ArrayList();
    private WorkOutBean[] totalExercisesArray =
            {
                    new WorkOutBean("Bench Press",R.drawable.bench_press) ,
                    new WorkOutBean("Bicep Curl",R.drawable.bicep_curl) ,
                    new WorkOutBean("Chest Press",R.drawable.chest_press) ,
                    new WorkOutBean("Crunches",R.drawable.crunches) ,
                    new WorkOutBean("Forward Bend",R.drawable.forward_bend) ,
                    new WorkOutBean("Incline Chest Press",R.drawable.incline_chest_press) ,
                    new WorkOutBean("Push Ups",R.drawable.push_up) ,
                    new WorkOutBean("Renegade Row",R.drawable.renegade_row) ,
                    new WorkOutBean("Seated Cable Row",R.drawable.seated_cable_row) ,
                    new WorkOutBean("Side Stretch",R.drawable.side_strech) ,
                    new WorkOutBean("Sit Ups",R.drawable.situps) ,
                    new WorkOutBean("Swiss Ball Push Ups",R.drawable.swiss_ball_push_up) ,
                    new WorkOutBean("Tree Pose",R.drawable.tree_pose) ,
                    new WorkOutBean("Vertical Leg Crunch",R.drawable.vertical_leg_crunch)
            };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //
        exercisesChosenList = new ArrayList<>();
        listView = findViewById(R.id.listView);
        Random random = new Random();

        for(int i = 0;i<5;i++)
        {
            random_exercise = random.nextInt(13); // is of Int type
            listOfNumbersGenerated.add(random_exercise);
            exercisesChosenList.add(totalExercisesArray[random_exercise]);
        } //

        ArrayAdapter<WorkOutBean>adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,exercisesChosenList);
        listView.setAdapter(adapter);
    }
}