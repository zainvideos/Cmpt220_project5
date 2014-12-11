package com.zain.project5_new;

/**
 * Created by Zain on 11/17/2014.
 */
public class Olympian {
    // Used to Construct each Olympian
    public String Name;
    public Sex sex;
    public int age;
    public Olympian(String Name, Sex sex, int age){
        this.Name= Name;
        this.sex= sex;
        this.age= age;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public Sex getSex() {
        return sex;
    }
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}