package com.cbfacademy.povsrun_group.routes;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface RouteRepository extends ListCrudRepository<Route, Long> {

    public List<Route> findByDistanceInKm(int distance);

    // public List<Route> findByViaRouteContaining(String viaRoute);

    @Query("SELECT r FROM Route r JOIN r.viaRoute v WHERE lower(v) LIKE CONCAT('%',lower(:viaRoute),'%')")
    public List<Route> findRoutesByViaRoute(@Param("viaRoute") String viaRoute);
    
} 