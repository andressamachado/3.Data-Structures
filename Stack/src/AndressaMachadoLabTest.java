import java.util.InputMismatchException;
import java.util.Scanner;

public class AndressaMachadoLabTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Business listOfEmployees = new Business();
        Employee employee = null;
        int choice = 0;

        do {
            System.out.print("Enter 1 to add an employee, 2 to display all employees, 3 to search for employee, 4 to quit:");

            try {
                choice = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("You must enter a number. Try again:");
                choice =5;
            }

            switch (choice) {
                //Add employee
                case 1:
                    int employeeNum = 0;
                    String employeeName = "";
                    float employeeSalary = 0.0f;

                    System.out.print("Enter employee number:");
                    try{
                        employeeNum = scanner.nextInt();
                    } catch (InputMismatchException e){
                        System.out.println("must be valid number.");
                        return;
                    }

                    System.out.print("Enter employee name:");
                    try{
                        employeeName = scanner.next().toLowerCase();
                    } catch (InputMismatchException e){
                        System.out.println("must be valid number.");
                        return;
                    }

                    System.out.print("Enter employee salary: ");
                    try{
                        employeeSalary = scanner.nextFloat();
                    } catch (InputMismatchException e){
                        System.out.println("must be valid number.");
                        return;
                    }

                    employee = new Employee(employeeNum, employeeName, employeeSalary);
                    listOfEmployees.addEmployeeToArray(employee);

                    break;
                //Display all employees

                case 2:
                    listOfEmployees.displayList();
                    break;

                //Search for employee
                case 3:
                    String name = "";
                    System.out.print("Enter name to search for: ");
                    try {
                        name = scanner.next().toLowerCase();
                    } catch (InputMismatchException e) {
                        System.out.println("Please, enter a name to be searched for.");
                    }

                    listOfEmployees.searchForEmployee(name);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        } while (choice != 4);
    }
}
