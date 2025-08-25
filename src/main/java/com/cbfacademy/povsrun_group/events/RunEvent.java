package com.cbfacademy.povsrun_group.events;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.cbfacademy.povsrun_group.runners.Runner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "runEvent")
public class RunEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    public UUID id;
    public LocalDate date;
    public String month;
    public List<Runner> particpants;
    public String image;
    public String route
}
