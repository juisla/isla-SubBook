package com.example.isla_subbook;

import java.io.Serializable;

/**
 * Created by isla on 1/31/18.
 */

public class Subscription implements Serializable{

    private String name;
    private String date;
    private Double monthlycharge;
    private String comment;

    public Subscription(String name, String date, Double monthlycharge, String comment){
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

    public Double getMonthlycharge(){
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

    public void setMonthlycharge(Double monthlycharge){
        this.monthlycharge = monthlycharge;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

}
