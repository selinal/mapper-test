package com.test.mapstruct;

import com.test.dto.PersonType;
import com.test.mapper.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * Created by sbt-selin-an on 24.06.2016.
 */
@Mapper
public interface MSMapper {

    MSMapper INSTANCE = Mappers.getMapper(MSMapper.class);

    @Mappings({
            @Mapping(source = "firstName", target = "FirstName")
    })
    Person jaxbPersion2OPersonDAO(PersonType in);
}
