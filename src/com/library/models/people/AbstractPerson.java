package com.library.models.people;
import java.util.Objects;


public abstract class AbstractPerson implements Comparable<AbstractPerson> {
    private String name;

    public AbstractPerson(String name){
        this.setName(name);
    }

    public String getName(){
        return this.name;
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
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        AbstractPerson abstractPerson = (AbstractPerson) o;
        return this.name.equals(abstractPerson.getName());
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.name);
    }

    @Override
    public int compareTo(AbstractPerson o) {
        return this.name.compareTo(o.getName());
    }

}
