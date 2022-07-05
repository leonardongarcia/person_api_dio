package one.digitalinoovation.personapi.service;

import one.digitalinoovation.personapi.dto.MessageResponseDTO;
import one.digitalinoovation.personapi.dto.request.PersonDTO;
import one.digitalinoovation.personapi.entity.Person;
import one.digitalinoovation.personapi.mapper.PersonMapper;
import one.digitalinoovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

  @Autowired private PersonRepository personRepository;

  private final PersonMapper personMapper = PersonMapper.INSTANCE;

  public List<PersonDTO> listAll(){
    List<Person> personList = personRepository.findAll();
    return personList.stream()
            .map(personMapper::toDTO)
            .collect(Collectors.toList());
  }

  public MessageResponseDTO save(PersonDTO personDTO) {
    Person personToSave = personMapper.toModel(personDTO);

    Person savedPerson = personRepository.save(personToSave);
    return MessageResponseDTO.builder()
        .message("Created person with ID " + savedPerson.getId())
        .build();
  }
}
