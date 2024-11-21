package oo.step7;

import oo.Klass;
import oo.School;
import oo.Student;
import oo.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import java.util.List;
//import oo.Klass;
//import oo.School;
//import oo.Student;
//import oo.Teacher;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
public class SchoolTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void should_print_message_when_startSchool_given_some_students_and_some_teachers(){
        //Given
        School school = new School();
        Klass klass = new Klass(1);
        Student tom = new Student(1, "Tom", 18);
        tom.joinSchool(school);
        tom.join(klass);
        Teacher jerry = new Teacher(1, "Jerry", 21);
        jerry.joinSchool(school);
        Teacher robert = new Teacher(1, "Robert", 20);
        robert.joinSchool(school);
        robert.assignTo(klass);

        //When
        school.startSchool();
        //Then
        assertThat(systemOut()).contains("My name is Jerry. I am 21 years old. I am a teacher.");
        assertThat(systemOut()).contains("My name is Tom. I am 18 years old. I am a student. I am in class 1.");
        assertThat(systemOut()).contains("My name is Robert. I am 20 years old. I am a teacher. I teach Class 1.");
    }

    private String systemOut() {
        return outContent.toString();
    }
}
