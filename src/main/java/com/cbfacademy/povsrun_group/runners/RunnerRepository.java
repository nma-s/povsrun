package com.cbfacademy.povsrun_group.runners;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

public interface RunnerRepository extends ListCrudRepository<Runner, UUID> {

}
