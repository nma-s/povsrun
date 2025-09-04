package com.cbfacademy.povsrun_group.routes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cbfacademy.povsrun_group.events.RunEvent;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @SequenceGenerator(name = "route-sequence", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "route-sequence")

    public Long routeId;
    public String name;
    public Float distanceInKm;
    public String startingPoint;

    @ElementCollection
    @CollectionTable(name="route_via", joinColumns = @JoinColumn(name = "route_id"))
    
    @Column(name="via_route")
    public List<String> viaRoute;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "assignedRoutes" )
    protected Set<RunEvent> runEventSet = new HashSet<>();

    public Route(String name,Float distance,String startingPoint, List<String> via){
        this.name = name;
        this.distanceInKm = distance;
        this.startingPoint = startingPoint;
        this.viaRoute = new ArrayList<>(via);
    }
    
    public Route(){
        this.distanceInKm = 5f;
        this.startingPoint = "Elephant and Castle Square";
        this.viaRoute = new ArrayList<>(List.of("London Brigde", "Waterloo Bridge"));
    }

    public Long getRouteId(){
        return routeId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Float getDistanceInKm(){
        return distanceInKm; 
    }

    public void setDistanceInKm(Float distanceInKm){
        this.distanceInKm = distanceInKm;
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
