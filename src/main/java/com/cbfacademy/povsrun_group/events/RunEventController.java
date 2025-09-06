package com.cbfacademy.povsrun_group.events;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.mapping.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/runevents")
public class RunEventController {

    protected RunEventService eventService;

    public RunEventController(RunEventService eventService){
        this.eventService = eventService;
    }

    @GetMapping()
    public List<RunEvent> getAllRunEvents() {
        return eventService.getAllRunEvents();
    }

    @GetMapping("/by-month")
    public List<RunEvent> getRunEventsByMonth(@RequestParam (required = true) int month) {
        return eventService.getRunEventsByMonth(month);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<?> getRunEvent(@PathVariable("eventId") Long eventId) {
        try {
            RunEvent event = eventService.getRunEvent(eventId);
            return ResponseEntity.ok(event);
        } catch (NoSuchElementException e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Route Not Found", e);
        }
    }

    @GetMapping("/{eventId}/runners")
    public ResponseEntity<?> getRunEventRunners(@PathVariable("eventId") Long eventId) {
        try {
            RunEvent event = eventService.getRunEvent(eventId);
            
            return ResponseEntity.ok(event.getParticipants());
        } catch (NoSuchElementException e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Route Not Found", e);
        }
    }

    @PostMapping()
    public ResponseEntity<RunEvent> postRoute(@RequestBody RunEvent newRunEvent) {
        RunEvent runEvent= eventService.createRunEvent(newRunEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(runEvent);
    }

    @PutMapping("/{eventId}/routes/{routeId}")
    public ResponseEntity<RunEvent> assignRouteToRunEvent(@PathVariable("eventId") Long eventId, @PathVariable("routeId") Long routeId) {
        try {
            
            RunEvent runEvent = eventService.assignRouteToRunEvent(eventId, routeId);
            return ResponseEntity.ok(runEvent);

        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run Event not found", e);
        }
    }

    @PutMapping("/{eventId}/runners/{runnerId}")
    public ResponseEntity<RunEvent> assignParticipantsToRunEvent(@PathVariable("eventId") Long eventId,
            @PathVariable("runnerId") Long runnerId) {
        try {
            RunEvent runEvent = eventService.assignParticipantsToRunEvent(eventId, runnerId);
            return ResponseEntity.ok(runEvent);

        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run Event not found", e);
        }
    }
    

    @PutMapping("/{eventId}")
    public ResponseEntity<?> updateRunEvent(@PathVariable("eventId") Long eventId, @RequestBody RunEvent updatedRunEvent) {
       try {
        RunEvent runEvent = eventService.updateRunEvent(eventId, updatedRunEvent);
        return ResponseEntity.ok(runEvent);

       } catch (NoSuchElementException e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run Event not found", e);
       }
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<?> deleteRunEvent(@PathVariable("eventId") Long eventId){
        try {
            eventService.deleteRunEvent(eventId);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run event Not Found", e);
        }
    }
    
}
