package ru.mirea.kvbo0422.task24.FactoryChairs;

public class VictorianChair implements Chair {
    private int age;

    public int getAge() {
        return age;
    }
    VictorianChair(int age){
        this.age = age;
    }
}
