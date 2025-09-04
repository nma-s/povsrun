package com.cbfacademy.povsrun_group.events;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/runevent")
public class RunEventController {

    protected RunEventService eventService;

    public RunEventController(RunEventService eventService){
        this.eventService = eventService;
    }

    @GetMapping()
    public List<RunEvent> getAllRunEvents() {
        return eventService.getAllRunEvents();
    }

    @PostMapping()
    public ResponseEntity<RunEvent> postRoute(@RequestBody RunEvent newRunEvent) {
        RunEvent runEvent= eventService.createRunEvent(newRunEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(runEvent);
    }

    @PutMapping("/{eventId}/route/{routeId}")
    public ResponseEntity<?> assignRouteToRunEvent(@PathVariable("eventId") Long runEventId, @PathVariable("routeId") Long routeId,
            @RequestBody RunEvent updatedRunEvent) {
        try {
            
            RunEvent runEvent = eventService.assignRouteToRunEvent(runEventId, routeId);
            return ResponseEntity.ok(runEvent);

        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run Event not found", e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRunEvent(@PathVariable("id") Long runEventId, @RequestBody RunEvent updatedRunEvent) {
       try {
        RunEvent runEvent = eventService.updateRunEvent(runEventId, updatedRunEvent);
        return ResponseEntity.ok(runEvent);

       } catch (NoSuchElementException e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run Event not found", e);
       }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRunEvent(@PathVariable("id") Long runEventId){
        try {
            eventService.deleteRunEvent(runEventId);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run event Not Found", e);
        }
    }
    
}
