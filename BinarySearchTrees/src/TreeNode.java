
public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data){
        this.data = data;
    }

    public void insert(int value){
        //comparing values
        if(value == data){//not allowing duplicate values
            return;
        }

        if(value < data) {//going to and inserting in the left subtree
            if (leftChild == null) {
                leftChild = new TreeNode(value);
            } else {
                leftChild.insert(value);//inserting a value
            }
        }
        else{
            if(rightChild == null){//going to and inserting in the right subtree
                rightChild = new TreeNode(value);
            }
            else{
                rightChild.insert(value);//inserting a value
            }
        }

    }

    public TreeNode get(int value){
        if(value == data){
            return this;//should return current node
        }
        if(value < data){//search left subtree
            if(leftChild != null){//checks
                return leftChild.get(value);//returning that node
            }
        }
        else{
            if(rightChild != null){//search right subtree
                return rightChild.get(value);//returning that node
            }
        }
        return null;//means couldnt find that node in tree
    }

    public void traverseInOrder(){//in-order traversal method for each node and if it has children
        if(leftChild != null){
            leftChild.traverseInOrder();//traversing left side first
        }
        System.out.print(data + ", ");
        if(rightChild != null){
            rightChild.traverseInOrder();//traversing right side next
        }
    }

    public int min(){//looking for the lowest value by traveling down left side
        if(leftChild == null){
            return data;
        }
        else {
            return leftChild.min();
        }
    }

    public void traversePreOrder(){//traverses tree looking @ each root then children
        System.out.println(data+", ");//visiting root first then left and right

        if(leftChild != null){
            leftChild.traversePreOrder();//traversing left side
        }

        if(rightChild != null){
            rightChild.traversePreOrder();//traversing right side
        }
    }

    public void traversePostOrder(){
        if(leftChild != null){
            leftChild.traversePostOrder();
        }
        if(rightChild != null){
            rightChild.traversePostOrder();
        }

        System.out.println(data+", ");
    }

    public int max(){//looking for the highest value by travelling down right side
        if(rightChild == null){
            return data;
        }
        else{
            return rightChild.max();
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
