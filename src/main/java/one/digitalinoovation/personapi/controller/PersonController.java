package one.digitalinoovation.personapi.controller;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

  private PersonService personService;

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

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
    personService.deleteById(id);
  }
}
