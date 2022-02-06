package com.github.glo2003.payroll;

public class HourlyEmployee extends Employee {
    private float hourlyRate;
    private final float workedHoursFor2Weeks;

    // TODO constructor

    public HourlyEmployee(String name, String role, int vacation_days, float rate, float amount) {
        super(name, role, vacation_days);
        this.hourlyRate = rate;
        this.workedHoursFor2Weeks = amount;
    }

    public float getHourlyRate() {
        return hourlyRate;
    }

    public float getWorkedHoursFor2Weeks() {
        return workedHoursFor2Weeks;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "name='" + this.getName() + '\'' +
                ", role='" + this.getRole() + '\'' +
                ", vacation_days=" + this.getVacation_days() +
                ", hourlyRate=" + hourlyRate +
                ", amount=" + workedHoursFor2Weeks +
                '}';
    }
}
