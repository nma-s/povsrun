package com.cbfacademy.povsrun_group.routes;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

RouteRepository routeRepository;

public List<Route> getAllRoutes(){
    return routeRepository.findAll();
}

public Route getRoute(Long routeId) throws NoSuchElementException{
    return routeRepository.findById(routeId).orElseThrow();
}

public Route createRoute(Route route) throws IllegalArgumentException, OptimisticLockingFailureException {
    return routeRepository.save(route);
}

public Route updateRoute(Long routeId, Route newRoute) throws NoSuchElementException{
    Route route = getRoute(routeId);
    route.setDistance(newRoute.getDistance());
    route.setStartingPoint(newRoute.getStartingPoint());
    route.setViaRoute(newRoute.getViaRoute());
    return routeRepository.save(route);
}

public void deleteRoute(Long routeId) throws NoSuchElementException{
    routeRepository.deleteById(routeId);
}



}
