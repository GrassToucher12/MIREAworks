package ru.mirea.kvbo0422.task4;
import java.util.Scanner;

public class Seasons {
    public enum Season {
        WINTER(-18, "Холодное время года"),
        SPRING(15,"Комфортное время года"),
        SUMMER(27,"Теплое время года"),
        AUTUMN(9,"Прохладное время года ");
        private final int temperature;
        private final String inform;
        private Season(int temperature, String inform){
            this.temperature = temperature;
            this.inform = inform;
        }
        public int getTemp(){
            return this.temperature;
        }

        public int getFavSeason(){
            return this.temperature;
        }
        public void getDescription(){
            Scanner sc  = new Scanner(System.in);
            System.out.println("Введите сезон: ");
            Season season_choose = Season.valueOf(sc.next());
            if (season_choose == SUMMER) {
                System.out.println(SUMMER.inform);
            }else{
                System.out.println(WINTER.inform);
            }
        }
        public void allInformation(){
            for(Season s: Season.values()){
                System.out.println(s);
                System.out.println(s.temperature);
                System.out.println(s.inform);
            }

        }
        public void getInfSeason(){
            Scanner sc  = new Scanner(System.in);
            System.out.println("Введите ваш любимый сезон: ");
            Season season_choose = Season.valueOf(sc.next());
            switch(season_choose) {
                case WINTER:
                    System.out.println("Я люблю зиму!");
                    break;
                case SUMMER:
                    System.out.println("Я люблю лето!");
                    break;
                case SPRING:
                    System.out.println("Я люблю весну!");
                    break;
                case AUTUMN:
                    System.out.println("Я люблю осень!");
                    break;
        }
    }
    public static void main(String[] args) {
        Season fav = Season.SUMMER;
        System.out.println("Температура: "+fav.getTemp());
        fav.getInfSeason();
        }
    }

}
