package one.digitalinoovation.personapi.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import one.digitalinoovation.personapi.dto.MessageResponseDTO;
import one.digitalinoovation.personapi.dto.request.PersonDTO;
import one.digitalinoovation.personapi.exception.PersonNotFoundException;

import java.util.List;

@Tag(name = "Person")
public interface PersonDocument {

  @Operation(description = "List all registered people")
  List<PersonDTO> listAll();

  @Operation(description = "Search for a person by ID")
  PersonDTO findById(Long id) throws PersonNotFoundException;

  @Operation(description = "Register a new person")
  MessageResponseDTO post(PersonDTO personDTO);

  @Operation(description = "Update a person")
  MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException;

  @Operation(description = "Delete a person by ID")
  void deleteById(Long id) throws PersonNotFoundException;
}
