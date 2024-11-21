package oo;

public class Student extends Person{
    private Klass ownKlass;

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    public void join(Klass klass){
        this.ownKlass = klass;
    }

    public boolean isIn(Klass klass){
        if(this.ownKlass == null || klass == null){
            return false;
        }
        return this.ownKlass.equals(klass);
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a student." + String.format(" I am in class %d.",this.ownKlass.getId());
    }

    public Klass getOwnKlass() {
        return ownKlass;
    }
}
