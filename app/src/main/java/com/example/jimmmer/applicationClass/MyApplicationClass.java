package com.example.jimmmer.applicationClass;

import android.app.Application;
import android.util.Log;

import com.example.jimmmer.R;
import com.example.jimmmer.model.WorkOutBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public  class MyApplicationClass extends Application
{
    public  static  int minutes =  0; // variable for no of minutes
    public static List<WorkOutBean> exercisesChosenList;  // list for any five exercises
    int random_exercise; // variable for generating a random number for an exercise to be chosen from array below
    public static WorkOutBean[] totalExercisesArray =
            {
                    new WorkOutBean("Bench Press", R.drawable.bench_press,3) ,
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
    public  void onCreate()
    {
        super.onCreate();
        exercisesChosenList = new ArrayList<>();
        Random random = new Random();

        for(int i = 0;i<5;i++)
        {
            random_exercise = random.nextInt(13); // generating a random number

            exercisesChosenList.add(totalExercisesArray[random_exercise]); // adding a the WorkoutBean object in List

            // here i don't want the same random generated number to be added in exercise but i don't know how to do it
        } //

        for(WorkOutBean bean:exercisesChosenList)
        {
            minutes = minutes+bean.getTime(); // getting total number of minutes from chosen exercises
            // total minutes for oneSet

        }
       // Log.d("minutesLog", "onCreate: "+minutes);

    }
}
