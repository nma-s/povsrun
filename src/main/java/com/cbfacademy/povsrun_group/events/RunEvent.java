package com.cbfacademy.povsrun_group.events;

import java.time.LocalDate;

import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import com.cbfacademy.povsrun_group.routes.Route;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "runEvent")
public class RunEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long id;
    public LocalDate date;
    public String month;
    public String day;
    // public List<Runner> particpants;
    // public String image;
    @ManyToMany()
    @JoinTable(name = "event_route", joinColumns = @JoinColumn(name="event_id"), inverseJoinColumns = @JoinColumn(name = "route_id"))
    public Set<Route> assignedRoutes = new HashSet<>();

    public RunEvent(LocalDate date){
        this.date = date;
        // this.month = date.getMonth().getDisplayName(TextStyle.FULL, Locale.UK);
    }

    public RunEvent(){
        this.date = LocalDate.parse("2025-01-01");
    }

    public LocalDate getDate(){
        return date;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public String getMonth() {
        return date.getMonth().getDisplayName(TextStyle.FULL, Locale.UK);
    }
    
    public String getDay() {
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.UK);
    }

    public Set<Route> getAssignedRoutes(){
    return assignedRoutes;
}

public void setAssignedRoutes(Set<Route> route){
    this.assignedRoutes = route;
}
}

