import java.util.Random;

class EmployeeWageBuilder {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        int employeePresent = 1;
        int partTimeEmployee = 2;
        int wagePerHour = 20;
        int fullDayHour = 8;
        int partTimeHour = 8;

        int employeeHours = 0;
        int employeeWage = 0;

        Random random = new Random();
        int employeeCheck = random.nextInt(3);
        if (employeePresent == employeeCheck) {
            System.out.println("Employee is Present");
            employeeHours = fullDayHour;
        } else if (partTimeEmployee == employeeCheck) {
            employeeHours = partTimeHour;
        } else {
            System.out.println("Employee is Absent");
        }

        employeeWage = employeeHours * wagePerHour;
        System.out.println("Daily Employee Wages : " + employeeWage);
    }
}