package one.digitalinoovation.personapi.mapper;

import one.digitalinoovation.personapi.dto.request.PersonDTO;
import one.digitalinoovation.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

  PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

  @Mapping(target = "birthDate", source = "birthDate")
  Person toModel(PersonDTO personDTO);

  PersonDTO toDTO(Person person);
}
