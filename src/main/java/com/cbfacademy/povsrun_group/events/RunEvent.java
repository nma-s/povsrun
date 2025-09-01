package com.cbfacademy.povsrun_group.events;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

import com.cbfacademy.povsrun_group.routes.Route;
import com.cbfacademy.povsrun_group.runners.Runner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "runEvent")
public class RunEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long id;
    public LocalDate date;
    public Month month;
    // public List<Runner> particpants;
    // public String image;
    // public Route route;

    public RunEvent(String date){
        this.date = LocalDate.parse(date);
        this.month = LocalDate.parse(date).getMonth();
    }

    public RunEvent(){
        this.date = LocalDate.parse("2025-01-01");
    }

    public LocalDate getDate(){
        return date;
    }

    public void getDate(String date){
        this.date = LocalDate.parse(date);
    }

    public Month getMonth() {
        return month;
    }




}
