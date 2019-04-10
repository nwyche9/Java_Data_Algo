public class DblLinkedList {
    private EmployeeNode head;
    private int sizes;
    private EmployeeNode tail;


    public void addToFront(Employee employee){
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        //need a previous field for the head node
        if(head == null){
            tail = node;
        }else{
            head.setPrevious(node);
        }

        head = node;
        sizes++;
    }

    public int getSize(){
        return sizes;
    }

    public boolean isEmpty(){
        return head == null;
    }
    //method to print the list
    public void printList(){
        EmployeeNode current = head;
        System.out.print("HEAD ->");
        while(current != null){
            System.out.print(current);
            System.out.print(" <=> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
    public void addToTail(Employee employee){
        EmployeeNode node = new EmployeeNode(employee);
        //setting the previous tail to point to the node in the list
        if(tail == null){
            head = node;
        }
        else{
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        sizes++;

    }

    //method to remove first node
    public EmployeeNode removeFromFront(){
        if(isEmpty()){
            return null;
        }
        EmployeeNode removedNode = head;
        if(head.getNext() == null){
            tail = null;
        }
        else{
            head.getNext().setPrevious(null);
        }

        head = head.getNext();
        sizes--;
        removedNode.setNext(null);
        return removedNode;
    }
    public EmployeeNode removeFromEnd(){
        if(isEmpty()){
            return null;
        }
        EmployeeNode removeNode = tail;
        //if only one node in the list
        if(tail.getPrevious() == null){
            head = null;
        }
        else{
            tail.getPrevious().setNext(null);
        }

        tail = tail.getPrevious();
        sizes--;
        removeNode.setPrevious(null);
        return removeNode;
    }
    //return true if added an employee to before an existing one
    public boolean addBefore(Employee newemployee, Employee existingemployee){
        if(isEmpty()){
            return false;
        }
        //while employee exists find that employee, unless empty
        EmployeeNode current = head;
        while(current != null && !current.getEmployee().equals(existingemployee)){
            current = current.getNext();
        }
        if(current == null){
            return false;
        }
        //chaning the references to the previous and next nodes
        EmployeeNode newNode = new EmployeeNode(newemployee);
        newNode.setPrevious(current.getPrevious());
        newNode.setNext(current);
        current.setPrevious(newNode);
        //if adding new node to the head of the list
        if(current == head){
            head = newNode;
        }
        else{
            newNode.getPrevious().setNext(newNode);
        }
        sizes++;
        return true;
    }
}
