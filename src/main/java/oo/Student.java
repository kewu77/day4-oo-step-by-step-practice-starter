package oo;

public class Student extends Person{
    private Klass ownKlass;

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    public void join(Klass klass){
        ownKlass = klass;
    }

    public boolean isIn(Klass klass){
        if(ownKlass == null || klass == null){
            return false;
        }
        return ownKlass.equals(klass);
    }

    @Override
    public String introduce() {
        if(ownKlass != null){
            return ownKlass.isLeader(this) ?
                    super.introduce() + " I am a student." + String.format(" I am the leader of class %d.", ownKlass.getId()) :
                    super.introduce() + " I am a student." + String.format(" I am in class %d.", ownKlass.getId());
        }else{
            return super.introduce() + " I am a student.";
        }

    }

    public Klass getOwnKlass() {
        return ownKlass;
    }
}
