import java.util.Random;

class CompanyEmpWage {
    public final String company;
    public final int empRatePerHour;
    public final int numOfWorkingDays;
    public final int maxHoursPerMonth;
    public int totalEmpWage;

    public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        this.company = company;
        this.empRatePerHour = empRatePerHour;
        this.numOfWorkingDays = numOfWorkingDays;
        this.maxHoursPerMonth = maxHoursPerMonth;
    }

    public void setTotalEmpWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }

    @Override
    public String toString() {
        return "Total Monthly Wage for Company: " + company + " is " + totalEmpWage;
    }
}

public class EmployeeWageBuilder {
    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;

    private int numOfCompany = 0;
    private CompanyEmpWage[] companyEmpWageArray;

    public EmployeeWageBuilder() {
        companyEmpWageArray = new CompanyEmpWage[5];
    }

    public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        companyEmpWageArray[numOfCompany] = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
        numOfCompany++;
    }

    public void computeEmpWage() {
        for (int i = 0; i < numOfCompany; i++) {
            companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
            System.out.println(companyEmpWageArray[i]);
        }
    }

    private int computeEmpWage(CompanyEmpWage companyEmpWage) {
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;
        Random random = new Random();
        int empCheck = random.nextInt(2) + 1;

        while (totalEmpHrs < companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays) {
            totalWorkingDays++;
            int empHrs = 0;
            int empPresence = random.nextInt(2);

            if (empPresence == 1) {
                switch (empCheck) {
                    case IS_FULL_TIME -> empHrs = 8;
                    case IS_PART_TIME -> empHrs = 4;
                }
            }

            if (totalEmpHrs + empHrs > companyEmpWage.maxHoursPerMonth) {
                empHrs = companyEmpWage.maxHoursPerMonth - totalEmpHrs;
            }
            totalEmpHrs += empHrs;
        }
        return totalEmpHrs * companyEmpWage.empRatePerHour;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        
        EmployeeWageBuilder empWageBuilder = new EmployeeWageBuilder();
        empWageBuilder.addCompanyEmpWage("D-Mart", 20, 20, 100);
        empWageBuilder.addCompanyEmpWage("Reliance", 25, 22, 120);
        empWageBuilder.addCompanyEmpWage("Amazon", 30, 25, 150);
        empWageBuilder.computeEmpWage();
    }
}