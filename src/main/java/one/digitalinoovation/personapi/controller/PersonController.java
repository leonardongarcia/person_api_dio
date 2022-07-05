package one.digitalinoovation.personapi.controller;

import one.digitalinoovation.personapi.dto.MessageResponseDTO;
import one.digitalinoovation.personapi.dto.request.PersonDTO;
import one.digitalinoovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/peoples")
public class PersonController {

  @Autowired private PersonService personService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MessageResponseDTO post(@RequestBody @Valid PersonDTO personDTO) {
    return personService.save(personDTO);
  }
}
