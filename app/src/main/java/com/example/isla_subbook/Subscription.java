package com.example.isla_subbook;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by isla on 1/31/18.
 */

public class Subscription {

    private String name;
    private String date;
    private String monthlycharge;
    private String comment;

    Subscription(){

    }

    public Subscription(String name, String date, String monthlycharge){
        this.name = name;
        this.date = date;
        this.monthlycharge = monthlycharge;
    }

    public Subscription(String name, String date, String monthlycharge, String comment){
        this.name = name;
        this.date = date;
        this.monthlycharge = monthlycharge;
        this.comment = comment;
    }

    public String getDate(){
        return date;
    }

    public String getName(){
        return name;
    }

    public String getMonthlycharge(){
        return monthlycharge;
    }

    public String getComment(){
        return comment;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setMonthlycharge(String monthlycharge){
        this.monthlycharge = monthlycharge;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

}
