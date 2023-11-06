package ru.mirea.kvbo0422.task20;

public class GenericBox<T extends String, V extends Animal, K > {
    private  T contentT;
    private  V contentV;
    private K contentK;
    public GenericBox (T contentT, V contentV, K contentK){
        this.contentT = contentT;
        this.contentV = contentV;
        this.contentK = contentK;
    }
    public T getContentT() {
        return contentT;
    }

    public V getContentV() {
        return contentV;
    }

    public K getContentK() {
        return contentK;
    }

    public void showTypes() {
        System.out.println(contentT.getClass().getName());
        System.out.println(contentV.getClass().getName());
        System.out.println(contentK.getClass().getName());
    }

    public String toString(){
        return (contentT + " (" + contentT.getClass() + ")\n"
        +contentV + " (" + contentV.getClass() + ")\n"
        +contentK + " (" + contentK.getClass() + ") ");
    }

}
