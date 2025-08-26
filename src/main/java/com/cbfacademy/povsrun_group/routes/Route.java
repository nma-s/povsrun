package com.cbfacademy.povsrun_group.routes;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long routeId;
    public Integer distance;
    public String startingPoint;
    @ElementCollection
    @CollectionTable(name="Via Route", joinColumns = @JoinColumn(name = "route_id"))
    public List<String> viaRoute;

    public Route(Integer distance, String startingPoint, List<String> via){
        this.distance = distance;
        this.startingPoint = startingPoint;
        this.viaRoute = new ArrayList<>(via);
    }
    
    public Route(){
        this.distance = 5;
        this.startingPoint = "Elephant and Castle Square";
        this.viaRoute = new ArrayList<>(List.of("London Brigde", "Waterloo Bridge"));
    }

    public Long getRouteId(){
        return routeId;
    }

    public Integer getDistance(){
        return distance; 
    }

    public void setDistance(Integer distance){
        this.distance = distance;
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
