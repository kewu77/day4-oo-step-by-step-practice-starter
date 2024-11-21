package oo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person{
    private List<Klass> ownKlass;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        ownKlass = new ArrayList<>();
    }

    public void assignTo(Klass klass){
        ownKlass.add(klass);
    }

    public boolean belongsTo(Klass klass){
        if(ownKlass == null || klass == null){
            return false;
        }
        return ownKlass.contains(klass);
    }

    public boolean isTeaching(Student student){
        return belongsTo(student.getOwnKlass());
    }

    private String getKlass(){
        return Arrays.stream(ownKlass.stream().
                mapToInt(Klass::getId).toArray())
                .boxed().map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    @Override
    public String introduce() {
        return ownKlass.size() != 0 ?
                super.introduce() + " I am a teacher." + String.format(" I teach Class %s.",getKlass()) :
                super.introduce() + " I am a teacher.";
    }
}
