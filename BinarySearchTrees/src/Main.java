public class Main {

    public static void main(String[] args){//can store any type of data in binary search tree

        Tree intTree = new Tree();

        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);
        intTree.insert(17);

        //printing the tree
        intTree.traverseInOrder();
        System.out.println();
        intTree.traversePreOrder();
        System.out.println();
        //testing getting the data
        //System.out.println(intTree.get(19).getData());
        //System.out.println(intTree.get(30).getData());
        //System.out.println(intTree.get(888));

        //printing the min and max of the tree
        //System.out.println(intTree.min());
        //System.out.println(intTree.max());

        //trying out cases: node with no child
        //intTree.delete(15);
        //intTree.traverseInOrder();
        //System.out.println();

        //node with 1 child
        //intTree.delete(27);
        //intTree.traverseInOrder();
        //System.out.println();

        //node with 2 children
        //intTree.delete(20);
        //intTree.traverseInOrder();

    }
}
