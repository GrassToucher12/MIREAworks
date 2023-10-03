package ru.mirea.kvbo0422.task6;

public class MovableRectangle implements Movable {
    MovablePoint topLeft;
    MovablePoint bottomRight;
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public int xSpeed;
    public int ySpeed;
    public MovableRectangle( MovablePoint topLeft, MovablePoint bottomRight ){
        this.topLeft = new MovablePoint(x1,y1,xSpeed,ySpeed);
        this.bottomRight = new MovablePoint(x2,y2,xSpeed,ySpeed);
    }
    @Override
    public String toString() {
        return "MovableRectangle{" +
                ", topLeft=" + this.topLeft +
                ", bottomRight=" + this.bottomRight + '\'' +
                '}';
    }

    @Override
    public void moveUp(int y_mov) {

    }

    @Override
    public void moveDown(int y_mov) {

    }

    @Override
    public void moveLeft(int x_mov) {

    }

    @Override
    public void moveRight(int x_mov) {

    }
}
