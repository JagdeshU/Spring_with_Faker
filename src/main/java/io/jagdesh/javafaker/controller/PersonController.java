package io.jagdesh.javafaker.controller;

import io.jagdesh.javafaker.entity.Person;
import io.jagdesh.javafaker.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/people")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepo;

    @GetMapping(value = "/all")
    public List<Person> getAllPeople() {
        return personRepo.findAll();
    }

}
