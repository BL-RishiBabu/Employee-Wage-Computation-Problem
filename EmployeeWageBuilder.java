import java.util.Random;

class EmployeeWageBuilder {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        int employeePresent = 1;

        Random random = new Random();
        int employeeCheck = random.nextInt(2);
        String status = employeePresent == employeeCheck ? "Employee is Present" : "Employee is Absent";
        System.out.println(status);
    }
}