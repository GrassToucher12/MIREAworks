package ru.mirea.kvbo0422.task6;

public class MovablePoint implements Movable{
    public int x;
    public int y;
    public int xSpeed;
    public int ySpeed;

    public MovablePoint(Integer x, Integer y, Integer xSpeed, Integer ySpeed){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public int getxSpeed() {
        return xSpeed;
    }
    public int getySpeed() {
        return ySpeed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isMovable(MovablePoint k1, MovablePoint k2){
        if ((k1.getySpeed() == k2.getySpeed())&&(k1.getxSpeed()== k1.getxSpeed())){
            return true;
        }else return false;
    }
    @Override
    public void moveUp(int y_mov) {
        this.y+=y_mov;

    }
    @Override
    public void moveDown(int y_mov) {
        this.y-=y_mov;

    }
    @Override
    public void moveLeft(int x_mov) {
        this.x-=x_mov;

    }
    @Override
    public void moveRight(int x_mov) {
        this.x+=x_mov;
    }
    @Override
    public String toString() {
        return "MovablePoint{" +
                ", x=" + x +
                ", y=" + y +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed + '\'' +
                '}';
    }
}
