import java.util.Random;

class EmployeeWageBuilder {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        final int employeePresent = 1;
        final int partTimeEmployee = 2;
        int wagePerHour = 20;
        int fullDayHour = 8;
        int partTimeHour = 8;

        int employeeHours = 0;
        int employeeWage = 0;

        Random random = new Random();
        int employeeCheck = random.nextInt(3);

        switch (employeeCheck) {
            case employeePresent -> {
                System.out.println("Employee is Full-Time");
                employeeHours = fullDayHour;
            }
                
            case partTimeEmployee -> {
                System.out.println("Employee is Part-Time");
                employeeHours = partTimeHour;
            }
            
            default -> {
                System.out.println("Employee is Absent");
                employeeHours = 0;
            }
        }

        employeeWage = employeeHours * wagePerHour;
        System.out.println("Daily Employee Wages : " + employeeWage);
    }
}