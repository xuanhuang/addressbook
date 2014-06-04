package com.gumtree.test;


import org.joda.time.DateTime;

public class Person implements Comparable<Person>{
    private String name;
    private String gender;
    private DateTime birthday;

    public Person(String name, String gender, DateTime birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public DateTime getBirthday() {
        return birthday;
    }

    public int compareTo(Person otherPerson) {
        DateTime compareDate = otherPerson.getBirthday();

        return this.getBirthday().compareTo(compareDate);
    }
}
