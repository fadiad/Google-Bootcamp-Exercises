package springBoot.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class User {
    private int id;
    private int age;

    public User(){};



    public User(int id, int age) {
        this.id = id;
        this.age = age;
    }

    public static User generatRandonUser() {
        return new User(ThreadLocalRandom.current().nextInt(), ThreadLocalRandom.current().nextInt());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() && getAge() == user.getAge();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAge());
    }
}
