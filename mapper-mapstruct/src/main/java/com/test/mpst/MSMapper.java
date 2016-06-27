package com.test.mpst;

import com.test.dto.AddressType;
import com.test.dto.PersonType;
import com.test.mapper.Address;
import com.test.mapper.Person;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


/**
 * Created by sbt-selin-an on 24.06.2016.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = SnilsTypeMapper.class)
public interface MSMapper {

    MSMapper INSTANCE = Mappers.getMapper(MSMapper.class);

    @Mappings({
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "address", target = "addressList")/*,
            @Mapping(source = "snils", target = "snils.code")*/
    })
    Person jaxbPersion2PersonDAO(PersonType in);

    Address jaxbAdress2AdressDto(AddressType in);

    @InheritInverseConfiguration
    PersonType PersonDAO2jaxbPersion(Person in);

    @InheritInverseConfiguration
    AddressType AdressDto2jaxbAdress(Address in);
}
