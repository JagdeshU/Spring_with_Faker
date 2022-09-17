package io.jagdesh.javafaker.repository;

import io.jagdesh.javafaker.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
