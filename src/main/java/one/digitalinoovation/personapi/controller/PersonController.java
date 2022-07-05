package one.digitalinoovation.personapi.controller;

import one.digitalinoovation.personapi.dto.MessageResponseDTO;
import one.digitalinoovation.personapi.dto.request.PersonDTO;
import one.digitalinoovation.personapi.exception.PersonNotFoundException;
import one.digitalinoovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/peoples")
public class PersonController {

  @Autowired private PersonService personService;

  @GetMapping
  public List<PersonDTO> listAll() {
    return personService.listAll();
  }

  @GetMapping("{id}")
  public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
    return personService.findById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MessageResponseDTO post(@RequestBody @Valid PersonDTO personDTO) {
    return personService.save(personDTO);
  }

  @PutMapping("{id}")
  public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO)
      throws PersonNotFoundException {
    return personService.updateById(id, personDTO);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
    personService.deleteById(id);
  }
}
