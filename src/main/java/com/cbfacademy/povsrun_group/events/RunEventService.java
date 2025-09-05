package com.cbfacademy.povsrun_group.events;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.cbfacademy.povsrun_group.routes.Route;
import com.cbfacademy.povsrun_group.routes.RouteRepository;
import com.cbfacademy.povsrun_group.runners.Runner;
import com.cbfacademy.povsrun_group.runners.RunnerRepository;

@Service
public class RunEventService {
    RunEventRepository eventRepo;
    RouteRepository routeRepo;
    RunnerRepository runnerRepo;

    public RunEventService(RunEventRepository eventRepo, RouteRepository routeRepo, RunnerRepository runnerRepo){
        this.eventRepo = eventRepo;
        this.routeRepo = routeRepo;
        this.runnerRepo = runnerRepo;
    }

    public RunEvent getRunEvent(Long eventId) throws NoSuchElementException{
        return eventRepo.findById(eventId).orElseThrow();
    }

    public List<RunEvent> getRunEventsByMonth(int month) throws NoSuchElementException {
        return eventRepo.findByMonth(month);
    }

    public List<RunEvent> getAllRunEvents(){
        return eventRepo.findAll();
    }

    public RunEvent createRunEvent(RunEvent event) throws IllegalArgumentException, OptimisticLockingFailureException{
        return eventRepo.save(event);
    }

    public RunEvent updateRunEvent(Long eventId, RunEvent newEvent) throws NoSuchElementException{
        RunEvent event = getRunEvent(eventId);
        event.setDate(newEvent.getDate());
        return eventRepo.save(event);
    }

     public void deleteRunEvent(Long id) throws NoSuchElementException{
        eventRepo.deleteById(id);
    }

    public RunEvent assignRouteToRunEvent(Long eventId, Long routeId){
        Set<Route> routeSet;
        RunEvent event = getRunEvent(eventId);
        Route route = routeRepo.findById(routeId).get();
        routeSet = event.getAssignedRoutes();
        routeSet.add(route);
        event.setAssignedRoutes(routeSet);
       return eventRepo.save(event);
    }

    public RunEvent assignParticipantsToRunEvent(Long eventId, Long runnerId) {
        Set<Runner> participantSet ;
        RunEvent event = getRunEvent(eventId);
        Runner runner = runnerRepo.findById(runnerId).get();
        participantSet = event.getParticipants();
        participantSet.add(runner);
        event.setParticipants(participantSet);
        return eventRepo.save(event);
    }

}
