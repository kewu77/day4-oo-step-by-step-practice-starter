package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass {
    private int id;

    private Student leader;

    private List<Person> people;


    public Klass(int id) {
        this.id = id;
        people = new ArrayList<>();
    }

    public void attach(Person person){
        people.add(person);
    }

    public void assignLeader(Student student){
        if(student.getOwnKlass() == null || student.getOwnKlass().getId() != id){
            System.out.println("It is not one of us.");
        }
        leader = student;
        people.forEach(this::printLeaderReport);
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

    public void printLeaderReport(Person person){
        if(person.getClass().equals(Student.class)){
            Student student = (Student) person;
            System.out.printf("I am %s, student of Class %d. I know %s become Leader.", student.getName(), id, leader.getName());
        }else if(person.getClass().equals(Teacher.class)){
            Teacher teacher = (Teacher) person;
            System.out.printf("I am %s, teacher of Class %d. I know %s become Leader.", teacher.getName(), id, leader.getName());

        }
    }
}
