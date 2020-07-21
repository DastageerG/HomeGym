package com.example.jimmmer.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jimmmer.R;
import com.example.jimmmer.model.WorkOutBean;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.Duration;

public class AdapterForWorkoutList extends RecyclerView.Adapter<AdapterForWorkoutList.ViewHolder>
{
    private Context context;
    private List<WorkOutBean>list;

    public AdapterForWorkoutList(Context context, List<WorkOutBean> list)
    {
        this.context = context;
        this.list = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageViewWorkOut;
        TextView textViewWorkoutName , textViewWorkOutTime;
        public ViewHolder(@NonNull View itemView,Context context)
        {
            super(itemView);
            imageViewWorkOut = itemView.findViewById(R.id.imageViewRecyclerForWorkoutListWorkOut);
            textViewWorkoutName = itemView.findViewById(R.id.textViewRecyclerForWorkoutListWorkoutName);
            textViewWorkOutTime = itemView.findViewById(R.id.textViewRecyclerForWorkoutListTime);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_for_workout_list,parent,false);
        return new ViewHolder(view,parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        WorkOutBean bean = list.get(position);



        holder.imageViewWorkOut.setImageResource(bean.getWorkOutPicResID());
        holder.textViewWorkOutTime.setText("Min : "+bean.getTime());
        holder.textViewWorkoutName.setText(bean.getWorkOutName());
    }

    @Override
    public int getItemCount()
    {
        return list.size(); // returns list
    }
}
