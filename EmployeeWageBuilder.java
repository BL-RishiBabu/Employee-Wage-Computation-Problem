import java.util.Random;

class EmployeeWageBuilder {
    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;
    public static final int FULL_DAY_HOUR = 8;
    public static final int PART_TIME_HOUR = 4;

    public static int computeEmployeeWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        
        int totalEmployeeHours = 0;
        int totalWorkingDays = 0;
        int totalEmployeeWage = 0;

        Random random = new Random();
        int employeeCheck = random.nextInt(2) + 1;

        System.out.println("\n--- Computing Wage for Company: " + company + " ---");
        System.out.println("Employee Type: " + (employeeCheck == IS_FULL_TIME ? "Full-Time" : "Part-Time"));

        while (totalEmployeeHours < maxHoursPerMonth && totalWorkingDays < numOfWorkingDays) {
            totalWorkingDays++;
            int employeeHours = 0;
            int employeePresents = random.nextInt(2);

            if (employeePresents == 1) {
                switch (employeeCheck) {
                    case IS_FULL_TIME -> employeeHours = FULL_DAY_HOUR;
                    case IS_PART_TIME -> employeeHours = PART_TIME_HOUR;
                }
            }

            if (totalEmployeeHours + employeeHours > maxHoursPerMonth) {
                employeeHours = maxHoursPerMonth - totalEmployeeHours;
            }

            totalEmployeeHours += employeeHours;
            int dailyWage = employeeHours * empRatePerHour;
            totalEmployeeWage += dailyWage;
        }

        System.out.println("Total Days Worked: " + totalWorkingDays);
        System.out.println("Total Hours Worked: " + totalEmployeeHours);
        System.out.println("Total Monthly Wage for " + company + ": " + totalEmployeeWage);        
        return totalEmployeeWage;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        
        computeEmployeeWage("D-Mart", 20, 20, 100);
        computeEmployeeWage("Reliance", 25, 22, 120);
        computeEmployeeWage("Amazon", 30, 25, 150);
    }
}