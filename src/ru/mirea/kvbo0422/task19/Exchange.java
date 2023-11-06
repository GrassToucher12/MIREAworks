package ru.mirea.kvbo0422.task19;

import java.util.Objects;
import java.util.Scanner;

public class Exchange {
    Citizen customer;
    static String [] dataBaseName;
    Exchange(){
        ExchangeDemo();
    }

    public void ExchangeDemo(){
        boolean state1 = true;
        boolean state2 = true;
        while ((state1)||(state2)){
        Scanner sc  = new Scanner(System.in);
        System.out.print("Введите ФИО покупателя через пробелы: ");
        String userName = sc.nextLine();
        Integer count = 0;
        for (int i = 0; i < userName.length(); i++){
            if (userName.charAt(i) == ' '){
                count++;
            }
        }
        if (count != 2){
            System.out.println("Имя введено неправильно!");
            continue;
        }
        else {
            String[] fullName = userName.split(" ");
            state1 = false;
            System.out.print("Введите ИНН покупателя: ");
            String INN = sc.nextLine();
            try {
                int intINN = Integer.parseInt(INN);
                customer = new Citizen(fullName[0], fullName[1], fullName[2], INN);
                state2 = false;
            } catch (NumberFormatException e) {
                System.out.println("ИНН введено неправильно! ");
                continue;
            }
        }
            System.out.println(customer);
        dataBaseName = new String[]{"f", "f", "f", "001"};
        try {
            validateCitizen(customer);
        } catch (INNException e){
            System.out.println("Ошибка: " + e.getMessage());
        }

        }
    }
    public void  validateCitizen(Citizen customer) throws INNException{
        if (!( (Objects.equals(dataBaseName[0], customer.getFirstName()))
                &&(Objects.equals(dataBaseName[1], customer.getLastName()))
                &&(Objects.equals(dataBaseName[2], customer.getFatherName()))
                &&(Objects.equals(dataBaseName[3], customer.getINN())) )){
            throw new INNException("Неверное имя или ИНН покупателя");
        }
    }
    public static class INNException extends RuntimeException {
        public INNException(String errorMessage) {
            super(errorMessage);
        }
    }
    public static void main(String[] args) {
        new Exchange();
    }
}
