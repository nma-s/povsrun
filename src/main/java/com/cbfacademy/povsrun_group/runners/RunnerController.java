package com.cbfacademy.povsrun_group.runners;

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
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/runners")
public class RunnerController {

    protected RunnerService runnerService;

    public RunnerController(RunnerService runnerService) {
        this.runnerService = runnerService;
    }

    @GetMapping()
    public List<Runner> getAllRunners(){
        return runnerService.getAllRunners();
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRunner(@PathVariable() Long id) {
        try {
            Runner runner = runnerService.getRunner(id);
            return ResponseEntity.ok(runner);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "runner not found", e);
        }

    }

    @PostMapping
    public ResponseEntity<Runner> createRunner(@RequestBody Runner runner) {
        Runner newRunner = runnerService.createRunner(runner);
        ResponseEntity<Runner> createdRunner = ResponseEntity.status(HttpStatus.CREATED).body(newRunner);
        return createdRunner;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Runner> updateRunner(@PathVariable Long id, Runner updatedRunner) {
        try{
        Runner runner = runnerService.updateRunner(id, updatedRunner);
        ResponseEntity<Runner> runnerEntity = ResponseEntity.ok(runner);
        return runnerEntity;
        } catch(NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Runner with " + id + " does not exist", e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRunner(@PathVariable Long id){
        try {
            runnerService.deleteRunner(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Runner with " + id + " does not exist", e);
        }
    }
    

}
