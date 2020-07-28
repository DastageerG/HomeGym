package com.example.jimmmer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.jimmmer.dialogueFragment.TimerDialogueFragment;

public class WorkoutActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        TimerDialogueFragment timerDialogueFragment = new TimerDialogueFragment();
        timerDialogueFragment.show(getSupportFragmentManager(),"dialogue");
    }
}