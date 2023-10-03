package ru.mirea.kvbo0422.task13;

public class Shirt {
    private String serialNumber;
    private String clothingType;
    private String color;
    private String size;
    public Shirt(String[] shirt){
        this.serialNumber = shirt[0];
        this.clothingType = shirt[1];
        this.color = shirt[2];
        this.size = shirt[3];
    }
    @Override
    public String toString(){
        return("серийный номер = " + this.serialNumber + ",\n" +
                "тип одежды = " + this.clothingType + ",\n"+
                "цвет = " + this.color + ",\n"+
                "размер = " + this.size + ",\n");
    }

}
