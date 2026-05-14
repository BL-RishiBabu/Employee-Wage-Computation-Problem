import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface IComputeEmpWage {
    void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth);
    void computeEmpWage();
}

class CompanyEmpWage {
    public final String company;
    public final int empRatePerHour;
    public final int numOfWorkingDays;
    public final int maxHoursPerMonth;
    public int totalEmpWage;
    public List<Integer> dailyWages;

    public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        this.company = company;
        this.empRatePerHour = empRatePerHour;
        this.numOfWorkingDays = numOfWorkingDays;
        this.maxHoursPerMonth = maxHoursPerMonth;
        this.dailyWages = new ArrayList<>();
    }

    public void setTotalEmpWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }

    @Override
    public String toString() {
        return "Company: " + company + "\nDaily Wages: " + dailyWages + "\nTotal Monthly Wage: " + totalEmpWage + "\n";
    }
}

public class EmployeeWageBuilder implements IComputeEmpWage {
    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;

    private List<CompanyEmpWage> companyEmpWageList;

    public EmployeeWageBuilder() {
        companyEmpWageList = new ArrayList<>();
    }

    @Override
    public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
        companyEmpWageList.add(companyEmpWage);
    }

    @Override
    public void computeEmpWage() {
        for (CompanyEmpWage companyEmpWage : companyEmpWageList) {
            companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
            System.out.println(companyEmpWage);
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
            int dailyWage = empHrs * companyEmpWage.empRatePerHour;
            companyEmpWage.dailyWages.add(dailyWage);
        }
        return totalEmpHrs * companyEmpWage.empRatePerHour;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program\n");
        
        IComputeEmpWage empWageBuilder = new EmployeeWageBuilder();
        empWageBuilder.addCompanyEmpWage("D-Mart", 20, 20, 100);
        empWageBuilder.addCompanyEmpWage("Reliance", 25, 22, 120);
        empWageBuilder.addCompanyEmpWage("Amazon", 30, 25, 150);
        empWageBuilder.computeEmpWage();
    }
}