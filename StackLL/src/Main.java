public class Main {
    public static void main(String[] args){
        Employee tony = new Employee("Tony","Stark",002);
        Employee king = new Employee("Harlequinn", "King",003);
        Employee meliodas = new Employee("Meliodas","demon",004);
        Employee ban = new Employee("Ban", "Theif",005);
        Employee end = new Employee("Knight","grandmaster", 006);


        LinkedStack stack = new LinkedStack();
        stack.push(tony);
        stack.push(king);
        stack.push(meliodas);
        stack.push(ban);
        stack.push(end);


        //stack.printStack();
        System.out.println("Popped " + stack.pop());
        System.out.println(stack.peek());

    }
}
