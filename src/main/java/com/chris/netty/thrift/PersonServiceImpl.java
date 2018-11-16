package com.chris.netty.thrift;

import org.apache.thrift.TException;
import thrift.generated.DataException;
import thrift.generated.Person;
import thrift.generated.PersonService;

public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByName(String name) throws DataException, TException {
        System.out.println("Got Client Param : " + name);
        Person person = new Person();
        person.setName(name);
        person.setAge(20);
        person.setMarried(false);

        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("Got Server Param : ");
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
