import java.util.ArrayList;

public class Business {
    private ArrayList<Employee> employees;
    private int size;

    public Business() {
        this.size = 10;
        this.employees = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            employees.add(null);
        }
    }

    public void addEmployeeToArray(Employee employee) {
        int index = employee.hashIndex();

        if (index > size) {
            System.out.println("End of the array reached. Impossible to add.");
            System.out.println();
            return;
        }

        while (index < size && employees.get(index) != null) {
            if (employees.get(index) == employee) {
                System.out.println("Employee is already inside the list.");
                System.out.println();
                return;
            }

            System.out.println("collision!");

            index = employee.hashCollision();
            if (employees.get(0) != null) {
                System.out.println("First index is already occupied. Could not add the employee.");
                System.out.println();
                return;
            }
        }

        employees.set(index, employee);
        System.out.println("String was successfully added at index " + index);
        System.out.println();

    }

    public void searchForEmployee(String name)
    {
        Employee tempEmployee = new Employee(name);
        int index = tempEmployee.hashIndex();

        if (employees.get(index).checkList(name)) {
            System.out.println("Employee found at index " + index);
            System.out.println();
            return;
        }

        index = tempEmployee.hashCollision();

        if (employees.get(index).checkList(name)) {
            System.out.println("Employee found at index " + index);
            System.out.println();
            return;
        }

        if (employees.get(0).checkList(name)) {
            System.out.println("Employee found at index 0");
            System.out.println();
            return;
        }

        System.out.println("Employee was not found inside the list.");
        System.out.println();
    }

    public void displayList() {

        for (int i = 0; i < employees.size() - 1; i++) {
            if (employees.get(i) != null) {
                System.out.println("[" + i + "]" + employees.get(i).displayEmployee());
            }
        }
        System.out.println();
    }
}

