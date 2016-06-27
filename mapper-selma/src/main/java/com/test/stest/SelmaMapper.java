package com.test.stest;

import com.test.dto.PersonType;
import com.test.mapper.Person;
import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

/**
 * Created by SBT-Selin-AN on 27.06.2016.
 */
@Mapper(
        withCustomFields = {
                @Field({"firstName6", "FirstName"}),
                @Field({"birthDate", "birthDate"})
        }
//        ,withIgnoreFields = {"firstName","birthDate","address", "snils"}
        ,withIgnoreMissing = IgnoreMissing.ALL

)
public interface SelmaMapper {

    @Maps(withIgnoreFields = "Snils")
    public Person jaxb2PersonDto(PersonType personType);
}
