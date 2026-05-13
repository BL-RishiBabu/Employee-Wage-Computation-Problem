import java.util.Random;

class EmployeeWageBuilder {
    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;
    public static final int WAGE_PER_HOUR = 20;
    public static final int FULL_DAY_HOUR = 8;
    public static final int PART_TIME_HOUR = 4;
    public static final int MAX_WORKING_DAYS = 20;
    public static final int MAX_WORKING_HOURS = 100;

    public static int computeEmployeeWage() {
        int totalEmployeeHours = 0;
        int totalWorkingDays = 0;
        int totalEmployeeWage = 0;

        Random random = new Random();
        int employeeCheck = random.nextInt(2) + 1;

        System.out.println("Employee Type: " + (employeeCheck == IS_FULL_TIME ? "Full-Time" : "Part-Time"));

        while (totalEmployeeHours < MAX_WORKING_HOURS && totalWorkingDays < MAX_WORKING_DAYS) {
            totalWorkingDays++;
            int employeeHours = 0;
            int employeePresents = random.nextInt(2);

            if (employeePresents == 1) {
                switch (employeeCheck) {
                    case IS_FULL_TIME -> employeeHours = FULL_DAY_HOUR;
                    case IS_PART_TIME -> employeeHours = PART_TIME_HOUR;
                }
            }

            if (totalEmployeeHours + employeeHours > MAX_WORKING_HOURS) {
                employeeHours = MAX_WORKING_HOURS - totalEmployeeHours;
            }

            totalEmployeeHours += employeeHours;
            int dailyWage = employeeHours * WAGE_PER_HOUR;
            totalEmployeeWage += dailyWage;

            System.out.println("Day " + totalWorkingDays + " Hours: " + employeeHours + " | Wage: " + dailyWage);
        }

        System.out.println("\nTotal Days Worked: " + totalWorkingDays);
        System.out.println("Total Hours Worked: " + totalEmployeeHours);
        return totalEmployeeWage;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        int finalWage = computeEmployeeWage();        
        System.out.println("Total Monthly Employee Wage: " + finalWage);
    }
}