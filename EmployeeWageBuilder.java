import java.util.Random;

class EmpWageBuilder {
    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;

    private final String company;
    private final int empRatePerHour;
    private final int numOfWorkingDays;
    private final int maxHoursPerMonth;
    private int totalEmpWage;

    public EmpWageBuilder(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        this.company = company;
        this.empRatePerHour = empRatePerHour;
        this.numOfWorkingDays = numOfWorkingDays;
        this.maxHoursPerMonth = maxHoursPerMonth;
    }

    public void computeEmpWage() {
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;
        Random random = new Random();

        int empCheck = random.nextInt(2) + 1;

        while (totalEmpHrs < maxHoursPerMonth && totalWorkingDays < numOfWorkingDays) {
            totalWorkingDays++;
            int empHrs = 0;
            int empPresence = random.nextInt(2);

            if (empPresence == 1) {
                switch (empCheck) {
                    case IS_FULL_TIME -> empHrs = 8;
                    case IS_PART_TIME -> empHrs = 4;
                }
            }

            if (totalEmpHrs + empHrs > maxHoursPerMonth) {
                empHrs = maxHoursPerMonth - totalEmpHrs;
            }

            totalEmpHrs += empHrs;
        }

        this.totalEmpWage = totalEmpHrs * empRatePerHour;
    }

    @Override
    public String toString() {
        return "Total Monthly Wage for Company: " + company + " is " + totalEmpWage;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        EmpWageBuilder dmart = new EmpWageBuilder("D-Mart", 20, 20, 100);
        EmpWageBuilder reliance = new EmpWageBuilder("Reliance", 25, 22, 120);
        EmpWageBuilder amazon = new EmpWageBuilder("Amazon", 30, 25, 150);

        dmart.computeEmpWage();
        System.out.println(dmart);

        reliance.computeEmpWage();
        System.out.println(reliance);

        amazon.computeEmpWage();
        System.out.println(amazon);
    }
}