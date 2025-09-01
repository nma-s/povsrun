package com.cbfacademy.povsrun_group.routes;

import java.util.ArrayList;
import java.util.List;

import com.cbfacademy.povsrun_group.events.RunEvent;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long routeId;
    public Integer distanceInKm;
    public String startingPoint;

    @ElementCollection
    @CollectionTable(name="route_via", joinColumns = @JoinColumn(name = "route_id"))
    
    @Column(name="via_route")
    public List<String> viaRoute;

    @ManyToOne
    public RunEvent runEvent;

    public Route(Integer distance, String startingPoint, List<String> via){
        this.distanceInKm = distance;
        this.startingPoint = startingPoint;
        this.viaRoute = new ArrayList<>(via);
    }
    
    public Route(){
        this.distanceInKm = 5;
        this.startingPoint = "Elephant and Castle Square";
        this.viaRoute = new ArrayList<>(List.of("London Brigde", "Waterloo Bridge"));
    }

    public Long getRouteId(){
        return routeId;
    }

    public Integer getDistanceInKm(){
        return distanceInKm; 
    }

    public void setDistanceInKm(Integer distance){
        this.distanceInKm = distance;
    }

    public String getStartingPoint(){
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public List<String> getViaRoute() {
        return viaRoute;
    }

    public void setViaRoute(List<String> via) {
        this.viaRoute = via;
    }

}
