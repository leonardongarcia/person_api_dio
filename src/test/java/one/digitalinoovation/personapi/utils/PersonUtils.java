package one.digitalinoovation.personapi.utils;

import one.digitalinoovation.personapi.dto.request.PersonDTO;
import one.digitalinoovation.personapi.entity.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

  private static final String FIRST_NAME = "Leonardo";
  private static final String LAST_NAME = "Garcia";
  private static final String CPF_NUMBER = "369.333.878-79";
  private static final long PERSON_ID = 1L;
  private static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

  public static PersonDTO createFakeDTO() {
    return PersonDTO.builder()
        .firstName(FIRST_NAME)
        .lastName(LAST_NAME)
        .cpf(CPF_NUMBER)
        .birthDate(BIRTH_DATE)
        .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
        .build();
  }

  public static Person createFakeEntity() {
    return Person.builder()
        .id(PERSON_ID)
        .firstName(FIRST_NAME)
        .lastName(LAST_NAME)
        .cpf(CPF_NUMBER)
        .birthDate(BIRTH_DATE)
        .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
        .build();
  }
}
