package ru.mirea.kvbo0422.task24.FactoryChairs;

public class ClientChair {
    Chair chair;
    public void sit(){
        System.out.println("!!!I'm sitting on a chair!!!");
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }
}
