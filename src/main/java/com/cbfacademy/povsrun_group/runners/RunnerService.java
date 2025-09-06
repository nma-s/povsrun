package com.cbfacademy.povsrun_group.runners;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class RunnerService {

    protected RunnerRepository runnerRepo;

    public RunnerService(RunnerRepository runnerRepo){
        this.runnerRepo = runnerRepo;
    }

    public Runner getRunner(Long id) throws NoSuchElementException{
        return runnerRepo.findById(id).orElseThrow();
    }

    public List<Runner> getAllRunners() throws IllegalArgumentException{
        return runnerRepo.findAll();
    }

    public Runner createRunner(Runner runner) throws IllegalArgumentException, OptimisticLockingFailureException{
        return runnerRepo.save(runner);
    }

    public Runner updateRunner(Long id, Runner updatedRunner) throws NoSuchElementException{
        Runner runner = getRunner(id);
        runner.setFirstName(updatedRunner.getFirstName());
        runner.setLastName(updatedRunner.getLastName());
        runner.setGender(updatedRunner.getGender());
        return runnerRepo.save(runner);
    }

    public void deleteRunner(Long id) throws NoSuchElementException{
        Runner runner = getRunner(id);
        runnerRepo.delete(runner);
    }

}
