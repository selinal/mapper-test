package com.test.mapstruct;

import com.test.mapper.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by sbt-selin-an on 24.06.2016.
 */
@Mapper
public interface MSMapper {

    MSMapper MAPPER = Mappers.getMapper(MSMapper.class);

//    Person jaxbPersion2OPersonDAO(PersonType in)
}
