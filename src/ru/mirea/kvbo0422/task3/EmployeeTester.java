package ru.mirea.kvbo0422.task3;


import java.util.Scanner;

public class EmployeeTester {
    public static void main(String[] args) {
        int emp_num;
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количесвто работников: ");
        emp_num = sc.nextInt();
        Employee[] employee_ar = new Employee[emp_num];
        Report[] report_ar = new Report[emp_num];
        String emp_name;
        Double emp_sal;
        for (int i = 0; i<emp_num; i++) {
            System.out.print("Введите имя работника #"+(i+1)+": ");
            sc.nextLine();
            emp_name = sc.nextLine();
            System.out.print("Введите зарплату работника #"+(i+1)+": ");
            emp_sal = sc.nextDouble();
            //employee_ar[i] = new Employee(emp_name,emp_sal);
            report_ar[i] = new Report(emp_name,emp_sal);
            System.out.print(employee_ar[i]);
        }
        System.out.print("Зарплата всех работников: \n");
        for (int i = 0; i<emp_num; i++) {
            System.out.print("Зарплату работника #"+(i+1)+": ");
            report_ar[i].generateReport();
        }
        System.out.print("Суммарная зарплата работников: "+report_ar[1].generateTotalReport());
    }
}
