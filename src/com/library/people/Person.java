package com.library.people;

import java.util.Objects;

public abstract class Person {
    private String name;

    public String getName(){
        return name;
    }
    public void setName(String name){
        if(name == null) throw new IllegalArgumentException("Name cannot be null");
        this.name = name;
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

    public abstract String whoYouAre();
    
}
