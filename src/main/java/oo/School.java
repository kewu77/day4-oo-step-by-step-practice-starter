package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class School {
    public static final String SPACE = "\n";
    private List<Student> students;

    private List<Teacher> teachers;

    public School() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
    }

    public void join(Person person){
        if(person.getClass().equals(Student.class)){
            students.add((Student) person);
        }else if(person.getClass().equals(Teacher.class)){
            teachers.add((Teacher) person);
        }
    }

    public void startSchool(){
        System.out.println(students.stream().map(Student::introduce).collect(Collectors.joining(SPACE))
         + teachers.stream().map(Teacher::introduce).collect(Collectors.joining(SPACE)));
    }
}
