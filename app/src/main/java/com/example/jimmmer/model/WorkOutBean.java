package com.example.jimmmer.model;

public class WorkOutBean
{
    private String workOutName;
    private int workOutPicResID;

    public WorkOutBean(String workOutName, int workOutPicResID)
    {
        this.workOutName = workOutName;
        this.workOutPicResID = workOutPicResID;
    } //

    public WorkOutBean()
    {
        //
    } //

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
    } //

    @Override
    public String toString()
    {
        return "WorkOutBean{" +
                "workOutName='" + workOutName + '\'' +
                ", workOutPicResID=" + workOutPicResID +
                '}';
    }
}
