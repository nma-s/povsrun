package com.cbfacademy.povsrun_group.events;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface RunEventRepository extends ListCrudRepository<RunEvent, Long> {

    @Query("select e from RunEvent e where MONTH(e.date) = :month")
    List<RunEvent> findByMonth(@Param("month") int month);

}
