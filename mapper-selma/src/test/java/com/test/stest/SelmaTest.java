package com.test.stest;

import com.test.dto.PersonType;
import com.test.mapper.Person;
import fr.xebia.extras.selma.Selma;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.testng.Assert.assertEquals;

/**
 * Created by SBT-Selin-AN on 27.06.2016.
 */
public class SelmaTest {

    PersonType personType = null;
    static String name = "Иванов Иван Иванович";

    @BeforeTest
    public PersonType createPerson() throws DatatypeConfigurationException {
        personType = new PersonType();
        personType.setFirstName(name);
        personType.setBirthDate(getXMLDate(new Date()));
//        personType.setSnils("1231423");
//        personType.getAddress();
        return personType;
    }

    public static XMLGregorianCalendar getXMLDate(Date date) throws DatatypeConfigurationException {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setGregorianChange(date);
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
    }

    @Test
    public void mappingTest() {
        SelmaMapper mapper = new SelmaMapperSelmaGeneratedClass();//Selma.builder(SelmaMapper.class).build();
        Person person = mapper.jaxb2PersonDto(personType);
        System.out.println(person.getFirstName());
        System.out.println(person.getBirthDate());
        assertEquals(person.getFirstName(), name);
    }
}
