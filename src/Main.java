public class Main {
    public static void main(String[] args){
        Employee tchalla = new Employee("Tchalla","King",001);
        Employee stark = new Employee("Tony", "Stark", 002);
        Employee bias = new Employee("Offensive", "Bias", 003);
        Employee bruce = new Employee("Bruce", "Banner", 004);

        DblLinkedList lst = new DblLinkedList();

        lst.addToFront(tchalla);
        lst.addToFront(stark);
        lst.addToFront(bias);
        lst.addToFront(bruce);

        Employee cap = new Employee("Captain","America",005);
        lst.addToTail(cap);
        lst.printList();
        lst.addBefore(new Employee("Admiral","Thrawn",010), bias);
        System.out.println(lst.getSize());
        lst.removeFromFront();
        lst.printList();
        lst.removeFromEnd();
        lst.printList();
        System.out.println(lst.getSize());
    }
}
