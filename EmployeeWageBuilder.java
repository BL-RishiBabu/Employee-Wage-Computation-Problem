import java.util.Random;

class EmployeeWageBuilder {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        final int fullTimeEmployee = 1;
        final int partTimeEmployee = 2;
        int wagePerHour = 20;
        int fullDayHour = 8;
        int partTimeHour = 4;
        int dailyWage = 0;
        int workingDaysPerMonth = 20;
        int totalEmployeeWage = 0;
        int employeeHours = 0;

        Random random = new Random();
        int employeeCheck = random.nextInt(2) + 1;

        if (employeeCheck == 1) {
            System.out.println("Employee id Full-Time");
        } else if (employeeCheck == 2) {
            System.out.println("Employee is Part-Time");
        }

        for (int day = 1; day <= workingDaysPerMonth; day++) {
            int employeePresents = random.nextInt(2);

            if (employeePresents == 1) {
                switch (employeeCheck) {
                    case fullTimeEmployee -> {
                        employeeHours = fullDayHour;
                    }

                    case partTimeEmployee -> {
                        employeeHours = partTimeHour;
                    }
                }
            } else {
                employeeHours = 0;
            }

            dailyWage = employeeHours * wagePerHour;
            totalEmployeeWage += dailyWage;
            System.out.println("Day " + day + " Wage: " + dailyWage);
        }

        System.out.println("\nDaily Employee Wages : " + totalEmployeeWage);
    }
}