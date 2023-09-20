package ru.mirea.kvbo0422.task2;
import java.lang.*;
import java.util.ArrayList;

public class Shop {
    private ArrayList<String> list;

    public Shop(ArrayList<String> list) {
        this.list =  list;
    }
    public ArrayList<String> getList() { return list; }
    public void pushList(String new_elem) {
        this.list.add(new_elem);
    }
    public void deletList(String new_elem) {
        this.list.remove(new_elem);
    }
    public boolean searchList( String new_elem ) {
        return (this.list.contains(new_elem));
    }

    @Override
    public String toString() {
        return "Shop{" +
                " list" + list + '\'' +
                '}';
    }
}
