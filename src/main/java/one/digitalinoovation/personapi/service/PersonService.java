package one.digitalinoovation.personapi.service;

import lombok.AllArgsConstructor;
import one.digitalinoovation.personapi.dto.MessageResponseDTO;
import one.digitalinoovation.personapi.dto.request.PersonDTO;
import one.digitalinoovation.personapi.entity.Person;
import one.digitalinoovation.personapi.exception.PersonNotFoundException;
import one.digitalinoovation.personapi.mapper.PersonMapper;
import one.digitalinoovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

  private PersonRepository personRepository;

  private final PersonMapper personMapper = PersonMapper.INSTANCE;

  public List<PersonDTO> listAll() {
    List<Person> personList = personRepository.findAll();
    return personList.stream().map(personMapper::toDTO).collect(Collectors.toList());
  }

  public PersonDTO findById(Long id) throws PersonNotFoundException {
    Person person = verifyIfExists(id);
    return personMapper.toDTO(person);
  }

  public MessageResponseDTO save(PersonDTO personDTO) {
    Person personToSave = personMapper.toModel(personDTO);

    Person savedPerson = personRepository.save(personToSave);
    return MessageResponseDTO.builder()
        .message("Created person with ID " + savedPerson.getId())
        .build();
  }

  public void deleteById(Long id) throws PersonNotFoundException {
    verifyIfExists(id);
    personRepository.deleteById(id);
  }

  private Person verifyIfExists(Long id) throws PersonNotFoundException {
    return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
  }
}
