package com.test.mpst;

import com.test.dto.AddressType;
import com.test.dto.PersonType;
import com.test.mapper.Person;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.testng.Assert.assertEquals;

/**
 * Created by sbt-selin-an on 24.06.2016.
 */

public class MSTest {

    PersonType personType = null;
    static String name = "Иванов Иван Иванович";

    public static XMLGregorianCalendar getXMLDate(Date date) throws DatatypeConfigurationException {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setGregorianChange(date);
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
    }

    @BeforeTest
    public PersonType createPerson() throws DatatypeConfigurationException {
        personType = new PersonType();
        personType.setFirstName(name);
        personType.setBirthDate(getXMLDate(new Date()));
        personType.setSnils("1231423");

        AddressType addressType = new AddressType();
        addressType.setHouse("111");
        addressType.setPostCode(443000);
        addressType.setStreet("STREET");
        addressType.setTown("Samara");

        personType.getAddress().add(addressType);
//        personType.getAddress();
        return personType;
    }

    @Test
    public void mappingTest() {
//        Person person = MSMapper.INSTANCE.jaxbPersion2PersonDAO(personType);
        MSMapper mapper = new MSMapperImpl();

        Person person = mapper.jaxbPersion2PersonDAO(personType);
        System.out.println("Map struct: " + person.getFirstName());
        System.out.println("Map struct: " + person.getBirthDate());
        assertEquals(person.getFirstName(), name);

        System.out.println("Map struct address list: " +person.getAddressList());
        System.out.println("Map struct snils as code: " +person.getSnils().getCode());
        person.getSnils().setCode("55555555555");
//        assertEquals(person.getAddressList().size(), 1);

        PersonType newPersonType = mapper.PersonDAO2jaxbPersion(person);

        System.out.println(">>>>>SNILS: "+newPersonType.getSnils());
    }
}
