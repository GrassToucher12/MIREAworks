package ru.mirea.kvbo0422.task6;

public class Main {
    public static void main(String[] args) {

        MovablePoint k1 = new MovablePoint(1,1,2,2);
        MovablePoint k2 = new MovablePoint(3,4,2,2);
        if (k1.isMovable(k1,k2)){
            MovableRectangle A = new MovableRectangle(k1,k2);
            System.out.print("Прямойгольник создан.");
        }
        else{
            System.out.print("Прямойгольник создать невозможно.");
        }
    }
}
