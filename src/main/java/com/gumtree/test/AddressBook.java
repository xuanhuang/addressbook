package com.gumtree.test;

import org.joda.time.DateTime;
import org.joda.time.Days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class AddressBook {

    private List<Person> addresses;

    public AddressBook() {
        addresses  = new ArrayList<Person>();
        readAddressFromFile();
    }

    private void readAddressFromFile() {
        try {
            String currentLine;
            BufferedReader br = new BufferedReader(new FileReader("/Users/xuan.huang/tests/addressbook/src/main/resources/address.txt"));
            while((currentLine = br.readLine())!=null){
                Person person = parseAddressLine(currentLine);
                this.addresses.add(person);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private Person parseAddressLine(String line){
        StringTokenizer tokenizer = new StringTokenizer(line, ",");
        String name = null;
        String gender = null;
        DateTime birthday = null;
        int i=0;
        while(tokenizer.hasMoreElements()){
            String o = (String) tokenizer.nextElement();
            if(i==0) {
                name = o;
            }else if(i==1){
                gender = o;
            }else if(i==2){
                birthday = parseBirthday(o);
            }
            i++;
        }
        return new Person(name, gender, birthday);
    }

    private DateTime parseBirthday(String birthday){
        int day = 0;
        int month = 0;
        int year = 0;
        StringTokenizer tokenizer = new StringTokenizer(birthday, "/");
        int i=0;
        while(tokenizer.hasMoreElements()){
            String o = (String)tokenizer.nextElement();
            if(o.startsWith(" ")){
                o = o.substring(1, o.length());
            }
            int t = Integer.parseInt(o);
            if(i==0){
               day = t;
            }else if(i==1){
               month = t;
            }else if(i==2){
               year = t;
            }
            i++;
        }
        return new DateTime(year, month, day, 0, 0);
    }

    public Person getOldestPerson(){
        Collections.sort(addresses);
        return addresses.get(0);
    }

    public int getMaleCount(){

        int count = 0;
        for (int i = 0; i < addresses.size(); i++) {
            String gender = addresses.get(i).getGender().trim();
            if(gender.equals("Male")){
                count++;
            }
        }
        return count;
    }

    public int getDaysOlder(Person person1, Person person2){
        return Days.daysBetween(person1.getBirthday(), person2.getBirthday()).getDays();

    }
}
