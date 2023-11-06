package ru.mirea.kvbo0422.task24.FactoryChairs;

public class TestFactory {
    public static void main(String[] args) {
        VictorianChair chair1 = ChairFactory.createVictorianChair();
        System.out.println("age = "+ chair1.getAge());
        FunctionalChair chair2 = ChairFactory.createFunctionalChair();
        System.out.println("sum = " + chair2.sum(2, 20));
        MagicChair chair3 = ChairFactory.createMagicianChair();
        chair3.doMagic();
    }
}
