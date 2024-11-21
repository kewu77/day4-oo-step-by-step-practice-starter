package oo;

public class Student extends Person{
    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    public void join(Klass klass){
        this.klass = klass;
    }

    public boolean isIn(Klass klass){
        if(this.klass == null || klass == null){
            return false;
        }
        return this.klass.equals(klass);
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a student." + String.format(" I am in class %d.",this.klass.getId());
    }

}
