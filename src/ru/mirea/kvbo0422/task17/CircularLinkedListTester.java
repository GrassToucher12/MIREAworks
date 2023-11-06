package ru.mirea.kvbo0422.task17;

import java.util.Scanner;

public class CircularLinkedListTester {
        public static void main(String[] args) {
            CircularLinkedList<String> list = new CircularLinkedList<>();
            Scanner sc = new Scanner(System.in);

            boolean state = true;
            while(state){
                System.out.println("Введит номер операци, который вы хотите произвести:");
                System.out.println("1.Добавить эелемент.");
                System.out.println("2.Удалить элемент.");
                System.out.println("3.Проверить список на пустоту.");
                System.out.println("4.Проверить размер списка.");
                System.out.println("5.Вывести список.");
                System.out.println("6.Выйти.");
                System.out.println("------------------------------");

                int number;
                try {
                    number = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.print("Введено неверное значение. Повторите ввод.\n");
                    System.out.println("------------------------------");
                    continue;
                }
                switch (number) {
                    case 1 -> {
                        System.out.println("Введите элемент, который надо добавить.");
                        int add;
                        try {
                            add= Integer.parseInt(sc.nextLine());
                            list.add(String.valueOf(add));
                            System.out.println("Элемент добавлен успешно.");
                            System.out.println("------------------------------");
                        } catch (NumberFormatException e) {
                            System.out.print("Введено неверное значение. Повторите ввод.\n");
                            System.out.println("------------------------------");
                        }
                    }
                    case 2 -> {
                        System.out.println("Введите элемент, который надо удалить.");
                        int remove;
                        try {
                             remove= Integer.parseInt(sc.nextLine());
                             list.remove(String.valueOf(remove));
                            System.out.println("------------------------------");
                        } catch (NumberFormatException e) {
                            System.out.print("Введено неверное значение. Повторите ввод.\n");
                            System.out.println("------------------------------");
                        }
                    }
                    case 3 -> {
                        if (list.isEmpty()){
                            System.out.println("Список пуст.");
                            System.out.println("------------------------------");
                        }
                        else {
                            System.out.println("Список не пуст.");
                        }
                        System.out.println("------------------------------");
                    }
                    case 4 -> {
                        System.out.println("Размер списка: "+list.size());
                        System.out.println("------------------------------");
                    }
                    case 5 -> {
                        list.printList();
                        System.out.println("------------------------------");
                    }
                    case 6 -> {
                        state = false;
                    }
                    default -> {
                        System.out.print("Введено неверное значение. Повторите ввод.\n");
                    }
                    }

            }

        }
    }
