
//dont use if memory is tight, use array
public class Main {

    public static void main(String[] args){

        Employee tchalla = new Employee("Tchalla", "King", 001);
        Employee stark = new Employee("Tony", "Stark", 002);
        Employee bias = new Employee("Offensive", "Bias", 003);
        Employee bruce = new Employee("Bruce", "Banner", 004);

        EmployeeLinkedList lst = new EmployeeLinkedList();

        System.out.println(lst.isEmpty());

        lst.addToFront(tchalla);
        lst.addToFront(stark);
        lst.addToFront(bias);
        lst.addToFront(bruce);

        System.out.println(lst.getSize());

        lst.printList();
        lst.removeFromFront();
        System.out.println(lst.getSize());
        lst.printList();

    }

}
