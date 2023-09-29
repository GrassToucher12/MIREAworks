package ru.mirea.kvbo0422.task4;

public class SeasonTester {
    public static void main(String[] args) {
        Seasons.Season fav = Seasons.Season.SUMMER;
        System.out.println("Температура: "+fav.getTemp());
        fav.getDescription();
        fav.getInfSeason();
        fav.allInformation();
    }
}
