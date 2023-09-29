package ru.mirea.kvbo0422.task3;
import java.lang.*;

public class Employee {
    public String fullname;
    public Double salary;
    public static Double total_salary = 0.0;

    public Employee(String fullname, Double salary) {
        this.fullname = fullname;
        this.salary =  salary;
        this.total_salary = this.total_salary + salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", fullname = " + fullname  +
                ", salary = "+ '\''+
                '}';
    }
}


