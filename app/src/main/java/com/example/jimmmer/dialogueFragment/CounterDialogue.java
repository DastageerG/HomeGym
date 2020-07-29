package com.example.jimmmer.dialogueFragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.jimmmer.R;

public class CounterDialogue extends DialogFragment
{
    private TextView textViewCounter,textViewWorkOutName;
    private ImageView imageViewWorkOut; // image for workout
    int countDownTime  = 10; // count down is 10 initially
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.timer_dialogue_frag,container,false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        textViewCounter = view.findViewById(R.id.textViewTimerDialogCounter);
        textViewWorkOutName = view.findViewById(R.id.textViewTimerDialogWorkoutName);
        imageViewWorkOut = view.findViewById(R.id.imageViewTimerDialogue);

        Bundle bundle = getArguments();
        textViewWorkOutName.setText(bundle.getString("workOutName"));
        imageViewWorkOut.setImageResource(bundle.getInt("workOutImgResId"));

    //
     CountDownTimer countDownTimer = new CountDownTimer(countDownTime*1000,1000)
     {
         @Override
         public void onTick(long millisUntilFinished)
         {
             textViewCounter.setText(""+millisUntilFinished/1000);
         }

         @Override
         public void onFinish()
         {
            dismiss();
         } //
     };
     countDownTimer.start();

        return view;
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null)
        {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }
}
