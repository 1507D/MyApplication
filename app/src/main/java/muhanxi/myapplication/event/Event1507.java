package muhanxi.myapplication.event;

/**
 * Created by muhanxi on 17/10/10.
 */

public class Event1507 {

    public String type ;
    public String age;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public Event1507(String type,String age){
        this.type = type;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Event1507{" +
                "type='" + type + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
