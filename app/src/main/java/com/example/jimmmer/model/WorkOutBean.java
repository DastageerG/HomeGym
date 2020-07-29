package com.example.jimmmer.model;

import java.sql.Time;

public class WorkOutBean
{
    private String workOutName;
    private int workOutPicResID;
    private int time; // i know  integer for time is not Good but its okay for me on the first try

    public WorkOutBean(String workOutName, int workOutPicResID, int time)
    {
        this.workOutName = workOutName;
        this.workOutPicResID = workOutPicResID;
        this.time = time;
    }//

    public String getWorkOutName()
    {
        return workOutName;
    }

    public void setWorkOutName(String workOutName)
    {
        this.workOutName = workOutName;
    }

    public int getWorkOutPicResID()
    {
        return workOutPicResID;
    }

    public void setWorkOutPicResID(int workOutPicResID)
    {
        this.workOutPicResID = workOutPicResID;
    }

    public int getTime()
    {
        return time;
    }

    public void setTime(int time)
    {
        this.time = time;
    }//

    @Override
    public String toString()
    {
        return "WorkOutBean{" +
                "workOutName='" + workOutName + '\'' +
                ", workOutPicResID=" + workOutPicResID +
                ", time=" + time +
                '}';
    }
}
