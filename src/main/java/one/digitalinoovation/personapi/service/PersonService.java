package one.digitalinoovation.personapi.service;

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
public class PersonService {

  @Autowired private PersonRepository personRepository;

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
    return createMessageResponse(personToSave.getId(), "Create person with ID ");
  }

  public void deleteById(Long id) throws PersonNotFoundException {
    verifyIfExists(id);
    personRepository.deleteById(id);
  }

  public MessageResponseDTO updateById(Long id, PersonDTO personDTO)
      throws PersonNotFoundException {
    verifyIfExists(id);
    Person personToUpdate = personMapper.toModel(personDTO);

    Person updatePerson = personRepository.save(personToUpdate);
    return createMessageResponse(updatePerson.getId(), "Update person with ID ");
  }

  private Person verifyIfExists(Long id) throws PersonNotFoundException {
    return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
  }

  private MessageResponseDTO createMessageResponse(Long id, String message) {
    return MessageResponseDTO.builder().message(message + id).build();
  }
}
