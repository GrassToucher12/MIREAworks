package ru.mirea.kvbo0422.task20;

public class MinMaxTest {
    public static void main(String[] args) {
        Integer[] numbers = {5, 2, 9, 1, 7};
        System.out.println("Integers :");
        for(Integer number : numbers){
            System.out.println(number);
        }
        MinMax<Integer> array = new MinMax<>(numbers);
        System.out.println("Max Integer " + array.maxElem());
        System.out.println("Min Integer " + array.minElem());


        String[] words = {"F", "H","S", "K", "Z", "A"};
        System.out.println("Words :");
        for(String word : words){
            System.out.println(word);
        }
        MinMax<String> arraystr = new MinMax<>(words);
        System.out.println("Max Integer " + arraystr.maxElem());
        System.out.println("Min Integer " + arraystr.minElem());
    }
}
