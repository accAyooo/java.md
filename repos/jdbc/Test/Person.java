/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午1:13 2018/3/31
 */
public class Person {
    private int id;
    public String name;
    private String sex;

    public Person() {
        System.out.println("no param constructor");
    }

    public Person(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void eat() {
        System.out.println("eat");
    }

}
