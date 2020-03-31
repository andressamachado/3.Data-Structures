public class Employee {
    private int employeeNumber;
    private String employeeName;
    private float employeeSalary;

    public Employee(int employeeNumber, String employeeName, float employeeSalary) {
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
    }

    public Employee(String employeeName) {
        this.employeeName = employeeName;
    }

    public int hashIndex() {
        return employeeName.charAt(0) % 10;
    }

    public int hashCollision() {
        if (employeeName.length() < 2) {
            return 0;
        }
        return employeeName.charAt(1) % 10;
    }

    public boolean checkList(String name) {
        if (employeeName.equals(name)) {
            return true;
        }
        return false;
    }

    public String displayEmployee() {
        return employeeName + " " + employeeNumber + " has salary $" + employeeSalary;
    }
}
