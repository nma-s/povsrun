package com.cbfacademy.povsrun_group.routes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/route")
public class RouteController {

    public RouteService routeService;

    public RouteController(RouteService routeService){
        this.routeService = routeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoute(@PathVariable Long routeId) {
        try {
            Route route = routeService.getRoute(routeId);
           return  ResponseEntity.ok(route);
        } catch (NoSuchElementException e) {
            
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Route Not Found", e);
        }
    }

    @GetMapping()
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    @PostMapping()
    public ResponseEntity<Route> postRoute(@RequestBody Route newRoute) {
        Route route = routeService.createRoute(newRoute);
        return ResponseEntity.status(HttpStatus.CREATED).body(route);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRoute(@PathVariable("id") Long routeId, @RequestBody Route updatedRoute) {
       try {
        Route route = routeService.updateRoute(routeId, updatedRoute);
        return ResponseEntity.ok(route);

       } catch (NoSuchElementException e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Route not found", e);
       }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoute(Long routeId){
        try {
            routeService.deleteRoute(routeId);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Route Not Found", e);
        }
    }
    
    
    

}
