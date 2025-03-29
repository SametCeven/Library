package com.library.models.people;
import java.util.Objects;


public abstract class Person implements Comparable<Person> {
    private Long id;
    private String name;


    public Person(Long id,String name){
        this.setId(id);
        this.setName(name);
    }

    public Long getId() {
        return id;
    }
    public String getName(){
        return this.name;
    }
    public void setId(Long id) {
        this.id = id;
    }
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
        return this.id.equals(person.getId());
    }
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
    @Override
    public int compareTo(Person o) {
        return this.id.compareTo(o.getId());
    }


    public abstract String whoYouAre();


}
