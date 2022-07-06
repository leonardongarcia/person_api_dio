package one.digitalinoovation.personapi.controller;

import lombok.AllArgsConstructor;
import one.digitalinoovation.personapi.dto.MessageResponseDTO;
import one.digitalinoovation.personapi.dto.request.PersonDTO;
import one.digitalinoovation.personapi.exception.PersonNotFoundException;
import one.digitalinoovation.personapi.service.PersonService;
import one.digitalinoovation.personapi.swagger.PersonDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/peoples")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController implements PersonDocument {

  private PersonService personService;

  @Override
  @GetMapping
  public List<PersonDTO> listAll() {
    return personService.listAll();
  }

  @Override
  @GetMapping("{id}")
  public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
    return personService.findById(id);
  }

  @Override
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MessageResponseDTO post(@RequestBody @Valid PersonDTO personDTO) {
    return personService.save(personDTO);
  }

  @Override
  @PutMapping("{id}")
  public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO)
      throws PersonNotFoundException {
    return personService.updateById(id, personDTO);
  }

  @Override
  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
    personService.deleteById(id);
  }
}
