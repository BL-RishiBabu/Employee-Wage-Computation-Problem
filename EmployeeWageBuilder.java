import java.util.Random;

class EmployeeWageBuilder {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        int employeePresent = 1;
        int wagePerHour = 20;
        int fullDayHour = 8;

        int employeeHours = 0;
        int employeeWage = 0;

        Random random = new Random();
        int employeeCheck = random.nextInt(2);
        if (employeePresent == employeeCheck) {
            System.out.println("Employee is Present");
            employeeHours = fullDayHour;
        } else {
            System.out.println("Employee is Absent");
        }

        employeeWage = employeeHours * wagePerHour;
        System.out.println("Daily Employee Wages : " + employeeWage);
    }
}