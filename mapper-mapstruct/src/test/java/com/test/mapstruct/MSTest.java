package com.test.mapstruct;

import com.test.dto.PersonType;
import com.test.mapper.Person;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by sbt-selin-an on 24.06.2016.
 */

public class MSTest {

    PersonType personType = null;
    static String name = "Иванов Иван Иванович";

    @BeforeTest
    public PersonType createPerson() {
        personType = new PersonType();
        personType.setFirstName(name);
        personType.setSnils("1231423");
//        personType.getAddress();
        return personType;
    }

    @Test
    public void mappingTest() {
        Person person = MSMapper.INSTANCE.jaxbPersion2OPersonDAO(personType);
        assertEquals(person.getFirstName(), name);
    }
}
