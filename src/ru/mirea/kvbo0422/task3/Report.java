package ru.mirea.kvbo0422.task3;

public class Report extends Employee {

    public Report(String fullname, Double salary) {
        super(fullname, salary);
    }
    public void  generateReport() {
        System.out.printf("%25.2f\n",salary);
    }
    public static Double generateTotalReport() {
        return total_salary;
    }

}

