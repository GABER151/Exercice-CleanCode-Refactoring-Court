package com.github.glo2003;

import com.github.glo2003.payroll.CompanyPayroll;
import com.github.glo2003.payroll.Employee;
import com.github.glo2003.payroll.HourlyEmployee;
import com.github.glo2003.payroll.SalariedEmployee;

public class Main {

    public static void main(String[] args) {
        CompanyPayroll companyPayroll = new CompanyPayroll();

        Employee employee1 = new HourlyEmployee("Alice", "vp", 25, 100, 35.5f * 4);
        Employee employee2 = new SalariedEmployee("Bob", "engineer", 4, 1500);
        Employee employee3 = new SalariedEmployee("Charlie", "manager", 4, 2000);
        Employee employee4 = new HourlyEmployee("Ernest", "intern", 1, 5, 50 * 4);
        Employee employee5 = new HourlyEmployee("Fred", "intern", 1, 5, 50 * 4);

        companyPayroll.addEmployee(employee1);
        companyPayroll.addEmployee(employee2);
        companyPayroll.addEmployee(employee3);
        companyPayroll.addEmployee(employee4);
        companyPayroll.addEmployee(employee5);

        System.out.println("----- Listing employees -----");
        companyPayroll.findVicePresidents().forEach(System.out::println);
        companyPayroll.findManagers().forEach(System.out::println);
        companyPayroll.findSoftwareEngineer().forEach(System.out::println);
        companyPayroll.findInterns().forEach(System.out::println);

        System.out.println("----- Giving raises -----");
        companyPayroll.giveSalaryRaise(employee1, 10);
        companyPayroll.giveSalaryRaise(employee2, 100);

        System.out.println("\n----- Create paychecks -----");
        companyPayroll.createPending();

        System.out.println("\n----- Pay statistics -----");
        float totalMoney = companyPayroll.getTotalmoney();
        System.out.println("Total money spent: ");
        float avgPayCheck = companyPayroll.getAvgPayCheckPending();
        System.out.println("Average paycheck: " + avgPayCheck);

        System.out.println("\n----- Pay -----");
        companyPayroll.processPending();
    }
}
