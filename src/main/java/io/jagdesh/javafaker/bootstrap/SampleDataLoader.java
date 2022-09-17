package io.jagdesh.javafaker.bootstrap;

import com.github.javafaker.Faker;
import io.jagdesh.javafaker.entity.Address;
import io.jagdesh.javafaker.entity.Person;
import io.jagdesh.javafaker.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class SampleDataLoader implements CommandLineRunner {

    private final PersonRepository personRepo;
    private final Faker faker;

    @Override
    public void run(String... args) throws Exception {

        // create 100 rows of fake data
        List<Person> people = IntStream.rangeClosed(1,100)
                .mapToObj(i -> new Person(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.phoneNumber().cellPhone(),
                        faker.internet().emailAddress(),
                        new Address(
                                faker.address().streetAddress(),
                                faker.address().city(),
                                faker.address().state(),
                                faker.address().zipCode())
                )).collect(Collectors.toList());

        personRepo.saveAll(people);

    }

}
