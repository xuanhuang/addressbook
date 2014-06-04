package com.gumtree.test;

import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class AddressBookTest {
    public AddressBook testObj = new AddressBook();

    @Test
    public void testGetOldestPerson(){
        //act
        Person oldestPerson = testObj.getOldestPerson();
        //assert
        assertNotNull(oldestPerson);
        assertEquals("Wes Jackson", oldestPerson.getName());
    }

    @Test
    public void testGetMaleCount(){
        //act
        int maleCount = testObj.getMaleCount();
        //assert
        assertEquals(3, maleCount);
    }

    @Test
    public void testGetDaysOlder() throws Exception{
        //setup
        int expectedResult = 2861;
        Person bill = new Person("Bill McKnight", "Male", new DateTime(77, 3, 17, 0, 0));
        Person paul = new Person("Paul Robinson", "Male", new DateTime(85, 1, 15, 0, 0));

        //act
        int daysOlder = testObj.getDaysOlder(bill, paul);

        //assert
        assertEquals(expectedResult, daysOlder);
    }
}
