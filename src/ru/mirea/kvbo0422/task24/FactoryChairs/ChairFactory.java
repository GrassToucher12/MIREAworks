package ru.mirea.kvbo0422.task24.FactoryChairs;

public class ChairFactory implements AbstractChairFactory{
    public static VictorianChair createVictorianChair() {
        return new VictorianChair(200);
    }

    public static MagicChair createMagicianChair() {
        return new MagicChair();
    }

    public static FunctionalChair createFunctionalChair() {
        return new FunctionalChair();
    }
}
