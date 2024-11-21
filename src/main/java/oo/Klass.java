package oo;

import java.util.Objects;

public class Klass {
    private int id;

    private Student leader;

    public Klass(int id) {
        this.id = id;
    }

    public void assignLeader(Student student){
        if(student.getOwnKlass() == null || student.getOwnKlass().getId() != id){
            System.out.println("It is not one of us.");
        }
        leader = student;
    }

    public boolean isLeader(Student student){
        if(leader == null)
            return false;
        return leader.equals(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass klass = (Klass) o;
        return id == klass.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }
}
