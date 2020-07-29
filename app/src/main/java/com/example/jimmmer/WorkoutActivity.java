package com.example.jimmmer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jimmmer.applicationClass.MyApplicationClass;
import com.example.jimmmer.dialogueFragment.CounterDialogue;
import com.example.jimmmer.model.WorkOutBean;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WorkoutActivity extends AppCompatActivity
{
    int worKOutPosition = 0;
    int workoutSetIndex = 1;
    int totalNoOFSets = 0;
    private List<WorkOutBean>exerciseList = MyApplicationClass.exercisesChosenList;
    private  CountDownTimer countDownTimer;
    private ImageView imageViewWorkout;
    private Button buttonSetNo , buttonWorkoutNo;
    private TextView textViewWorkoutName , textViewCountDownTime;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        imageViewWorkout = findViewById(R.id.imageViewWorkoutActivity);
        buttonSetNo = findViewById(R.id.buttonWorkoutActivitySetsNo);
        buttonWorkoutNo = findViewById(R.id.buttonWprkoutActivityWorkoutNo);

        textViewCountDownTime = findViewById(R.id.textViewWorkoutNCountDownTime);
        textViewWorkoutName = findViewById(R.id.textViewWorkoutName);

        Bundle bundle = getIntent().getExtras();
        totalNoOFSets = bundle.getInt("noOfSets");

        updateValues(); // setting values for the View

        showDialog();
        // here i want this countdown timer to startAfter the the dialogue dismissed
        countDownTimer = new CountDownTimer(exerciseList.get(worKOutPosition).getTime()*60000,1000)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                textViewCountDownTime.setText(String.format("%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)%60,
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60));
            }
            @Override
            public void onFinish()
            {

            }
        };
        countDownTimer.start();

    } // on create closed

//    private void startWorkOutSet()
//    {
//
//        showTimerDialog(worKOutPosition);
//        updateValues();
//        countDownTimer = new CountDownTimer(exerciseList.get(worKOutPosition).getTime(),1000)
//            {
//                @Override
//                public void onTick(long millisUntilFinished)
//                {
//                    textViewCountDownTime.setText(String.format("%02d:%02d",
//                            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)%60,
//                            TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60));
//                }
//                @Override
//                public void onFinish()
//                {
//                    if(worKOutPosition<exerciseList.size()-1)
//                    {
//                        worKOutPosition++;
//                        startWorkOutSet();
//                    }
//                }
//            };
//        countDownTimer.start();
//
//       // } // for closed
//
//    } // Start Workout Set

    private void updateValues()
    {
        imageViewWorkout.setImageResource(exerciseList.get(worKOutPosition).getWorkOutPicResID());
        buttonWorkoutNo.setText(worKOutPosition+1+"/"+exerciseList.size());
        buttonSetNo.setText(workoutSetIndex+"/"+totalNoOFSets);
        textViewWorkoutName.setText(exerciseList.get(worKOutPosition).getWorkOutName());
        textViewCountDownTime.setText(timeFormat(exerciseList.get(worKOutPosition).getTime()));
                        // formatting because i used Integer type for time
    } // updateValues closed

    private void showDialog()
    {
     CounterDialogue counterDialogue = new CounterDialogue();
        Bundle bundle = new Bundle();
        bundle.putString("workOutName",exerciseList.get(worKOutPosition).getWorkOutName());
        bundle.putInt("workOutImgResId",exerciseList.get(worKOutPosition).getWorkOutPicResID());
        //bundle.putInt("workoutNo",worKOutPosition);
        counterDialogue.setArguments(bundle);
        counterDialogue.show(getSupportFragmentManager(),"dialogue");
    } // showTimerDialogue closed

    private String timeFormat(int num)
    {
        long min = TimeUnit.MINUTES.toMinutes(num)%60; // forMating the integer into Minutes
        long sec = TimeUnit.MINUTES.toSeconds(min)%60; // and seconds
        return String.format("%02d:%02d",min,sec); // returning String

    } // timeFormat closed

}