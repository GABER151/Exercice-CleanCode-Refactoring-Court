package com.github.glo2003.payroll;

import java.util.ArrayList;
import java.util.List;

public class CompanyPayroll {
    private final List<Employee> employeeList;
    private final List<Paycheck> paycheckList;

    public CompanyPayroll() {
        this.employeeList = new ArrayList<>();
        this.paycheckList = new ArrayList<>();
    }

    public void processPending() {
        for(Paycheck paycheck:paycheckList) {
            System.out.println("Sending " + paycheck.getAmount() + "$ to " + paycheck.getTo());
        }
        this.paycheckList.clear();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public List<Employee> findSoftwareEngineer() {
        List<Employee> softwareEngineerList = new ArrayList<>();

        for (Employee employee : employeeList) {
            if (employee.getRole().equals("engineer")) {
                softwareEngineerList.add(employee);
            }
        }
        return softwareEngineerList;
    }

    public List<Employee> findManagers() {
        List<Employee> managerList = new ArrayList<>();

        for (Employee employee : employeeList) {
            if (employee.getRole().equals("manager")) {
                managerList.add(employee);
            }
        }
        return managerList;
    }

    public List<Employee> findVicePresidents() {
        List<Employee> vicePresidentList = new ArrayList<>();

        for (Employee employee : employeeList) {
            if (employee.getRole().equals("vp")) {
                vicePresidentList.add(employee);
            }
        }
        return vicePresidentList;
    }

    public List<Employee> findInterns() {
        List<Employee> internList = new ArrayList<>();

        for (Employee employee : employeeList) {
            if (employee.getRole().equals("intern")) {
                internList.add(employee);
            }
        }
        return internList;
    }

    public void createPending() {
        for (Employee employee : employeeList) {
            if (employee instanceof HourlyEmployee) {
                HourlyEmployee hourlyEmployee = (HourlyEmployee) employee;
                paycheckList.add(new Paycheck(employee.getName(), hourlyEmployee.getWorkedHoursFor2Weeks() * hourlyEmployee.getHourlyRate()));
            } else if (employee instanceof SalariedEmployee) {
                SalariedEmployee salariedEmployee = (SalariedEmployee) employee;
                paycheckList.add(new Paycheck(employee.getName(), salariedEmployee.getBiweekly()));
            } else {
                throw new RuntimeException("something happened");
            }
        }
    }

    public void giveSalaryRaise(Employee employee, float raise) {
        if (raise < 0) {
            throw new RuntimeException("The salary must be positive");
        }
        if (!this.employeeList.contains(employee)) {
            throw new RuntimeException("The employee doesn't exist");
        }

        if (employee instanceof HourlyEmployee) {
            HourlyEmployee hourlyEmployee = (HourlyEmployee) employee;
            hourlyEmployee.setHourlyRate(hourlyEmployee.getHourlyRate() + raise);
        } else if (employee instanceof SalariedEmployee) {
            SalariedEmployee salariedEmployee = (SalariedEmployee) employee;
            salariedEmployee.setBiweekly(salariedEmployee.getBiweekly() + raise);
        } else {
            throw new RuntimeException("The employee is not an HourlyEmployee neither a SalariedEmployee");
        }
    }
    
    public float getAvgPayCheckPending() {
        float avg;
        float sum = 0;

        if (this.paycheckList.size() == 0) {
            return -1f;
        }

        for (Paycheck p : this.paycheckList) {
            sum += p.getAmount();
        }

        avg = sum / this.paycheckList.size();
        return avg;
    }


    public float getTotalmoney() {
        float t_float = 0.f;
        for (int o = 0; o < this.paycheckList.size(); o = o + 1) {
            Paycheck p = this.paycheckList.get(o);
            t_float += p.getAmount();
        }
        return t_float;
    }

    public List<Paycheck> getPendings() {
        return this.paycheckList;
    }

}
