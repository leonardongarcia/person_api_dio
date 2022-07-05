package one.digitalinoovation.personapi.service;

import one.digitalinoovation.personapi.dto.MessageResponseDTO;
import one.digitalinoovation.personapi.entity.Person;
import one.digitalinoovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public MessageResponseDTO save(Person person){
        Person savedPerson = personRepository.save(person);
    return MessageResponseDTO
            .builder()
            .message("Created person with ID " + savedPerson.getId())
            .build();
    }
}
