package com.cbfacademy.povsrun_group.routes;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

public RouteRepository routeRepository;

public RouteService(RouteRepository routeRepository){
    this.routeRepository = routeRepository;
}

public List<Route> getAllRoutes(){
    return routeRepository.findAll();
}

public Route getRoute(Long routeId) throws NoSuchElementException{
    return routeRepository.findById(routeId).orElseThrow();
}

public List<Route> getRoutesByDistanceInKm(Integer distance) {
    return routeRepository.findByDistanceInKm(distance);
}

public Route createRoute(Route route) throws IllegalArgumentException, OptimisticLockingFailureException {
    return routeRepository.save(route);
}

public Route updateRoute(Long routeId, Route newRoute) throws NoSuchElementException{
    Route route = getRoute(routeId);
    route.setDistanceInKm(newRoute.getDistanceInKm());
    route.setStartingPoint(newRoute.getStartingPoint());
    route.setViaRoute(newRoute.getViaRoute());
    return routeRepository.save(route);
}

public void deleteRoute(Long routeId) throws NoSuchElementException{
    routeRepository.deleteById(routeId);
}



}
