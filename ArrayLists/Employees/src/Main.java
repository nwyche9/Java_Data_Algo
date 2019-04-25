import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        List<Employee> employeeList = new ArrayList<>();
        //calling the constructor
        employeeList.add(new Employee("Tony", "Stark", 002));
        employeeList.add(new Employee("Tchalla", "King", 001));
        employeeList.add(new Employee("Vi", "Sion", 003));
        employeeList.add(new Employee("Bruce", "Banner", 004));

        //looking at the various methods for arraylists
        System.out.println(employeeList.get(1));

        System.out.println(employeeList.isEmpty());

        employeeList.set(2, new Employee("Offensive", "Bias", 003));
        employeeList.add(4, new Employee("Jarvis", "System", 005));
        //employeeList.forEach(employee -> System.out.println(employee));

        // making an employee array
        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
        for ( Employee employee : employeeArray){
            System.out.println(employee);
        }


        System.out.println(employeeList.contains(new Employee("Offensive", "Bias", 003)));
        System.out.println(employeeList.indexOf(new Employee("Tony", "Stark", 002)));
        employeeList.remove(3);
        employeeList.forEach(employee -> System.out.println(employee));
    }
}
