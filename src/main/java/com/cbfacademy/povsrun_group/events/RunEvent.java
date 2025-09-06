package com.cbfacademy.povsrun_group.events;

import java.time.LocalDate;

import java.time.format.TextStyle;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import com.cbfacademy.povsrun_group.routes.Route;
import com.cbfacademy.povsrun_group.runners.Runner;

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

    public String name;
    public LocalDate date;
    public String month;
    public String day;
    @ManyToMany()
    @JoinTable(name = "event_participants", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "runner_id"))
    public Set<Runner> participants = new HashSet<>();
    
    @ManyToMany()
    @JoinTable(name = "event_routes", joinColumns = @JoinColumn(name="event_id"), inverseJoinColumns = @JoinColumn(name = "route_id"))
    public Set<Route> assignedRoutes = new HashSet<>();

    public RunEvent(String name, LocalDate date){
        this.name = name;
        this.date = date;
    }

    public RunEvent(){
        this.name = "";
        this.date = LocalDate.parse("2025-01-01");
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public LocalDate getDate(){
        return date;
    }

    public void setDate(LocalDate date){
        this.date = date;
        this.month = date.getMonth().getDisplayName(TextStyle.FULL, Locale.UK);
        this.day = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.UK);
    }

    public String getMonth() {
        return month;
    }
    
    public String getDay() {
        return day;
    }

    public Set<Route> getAssignedRoutes(){
    return assignedRoutes;
    }

    public void setAssignedRoutes(Set<Route> routes){
        this.assignedRoutes = routes;
    }

    public Set<Runner> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Runner> participants) {
        this.participants = participants;
    }
}

