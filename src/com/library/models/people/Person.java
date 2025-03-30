package com.library.models.people;
import java.util.Objects;


public abstract class Person implements Comparable<Person> {
    private String name;


    public Person(String name){
        this.setName(name);
    }


    public String getName(){return this.name;}
    public void setName(String name){
        this.name = name;
    }


    @Override
    public String toString(){
        return "Name: " + this.getName();
    }
    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != this.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(person.name,name);
    }
    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.getName());
    }


    public abstract String whoYouAre();


}
