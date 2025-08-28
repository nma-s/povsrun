package com.cbfacademy.povsrun_group.routes;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

public interface RouteRepository extends ListCrudRepository<Route, Long> {

    public List<Route> findByDistanceInKm(int distance);

    public List<Route> findByViaRoutesContaining(String viaString);
    
} 