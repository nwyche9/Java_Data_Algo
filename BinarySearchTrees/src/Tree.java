public class Tree {

    private TreeNode root;

    //node insertion, if tree empty insert node as root, if not empty compare to root to put less on left and greater on right
    //not taking duplicate nodes in this implementation

    //level traversal does every node on a tree level
    //in-order traversal start at left most node then root of subtree and continue to end of tree, left->root->right
    //pre-order start at roots then to leaves, root->left->right
    //post-order start at leaves then roots left->right->root

    public void insert(int value){
        if(root == null) {
            root = new TreeNode(value);
        }
        else {
            root.insert(value);
        }
    }

    public void traverseInOrder(){
        if(root != null){
            root.traverseInOrder();//calling in-order traversal method
        }
    }

    public void traversePreOrder(){
        if(root != null){
            root.traversePreOrder();//calling pre-order traversal method
        }
    }

    public void traversePostOrder(){
        if(root != null){
            root.traversePostOrder();//calling post-order traversal method
        }
    }
    public TreeNode get(int value){
        if(root != null){
            return root.get(value);//getting the value if tree not empty
        }
        return null;//tree is empty
    }

    public void delete(int value){//deleting for nodes with only one leaf
        root = delete(root, value);//passing root of subtree to then find v
    }

    private TreeNode delete(TreeNode subtreeRoot, int value){//when deleting with 2 children, left take largest, right take smallest
        if(subtreeRoot == null){//checking if root is null
            return subtreeRoot;
        }

        if(value < subtreeRoot.getData()){
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));//moving to left subtree and looking @ those children, will replace if needs to be replaced
        }
        else if(value > subtreeRoot.getData()){
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(),value));//moving to right subtree and looking @ those children, will replace if needs to be replaced
        }
        else{//dealing with the children of the root, of node has 0 or 1 child
            if(subtreeRoot.getLeftChild()==null){//either is a leaf or has right child
                return subtreeRoot.getRightChild();//if leaf get rid of node, if right child replace with right child
            }
            else if(subtreeRoot.getRightChild()==null){
                return subtreeRoot.getLeftChild();//if leaf get rid of node, if has left child replace with left child
            }
            //node has 2 children, going right so must find min value to replace root, and nulling where that node was
            subtreeRoot.setData(subtreeRoot.getRightChild().min());//setting new root
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));//deleting where node was
        }
        return subtreeRoot;//giving us that node
    }

    public int min(){
        if(root == null){//means tree is empty
            return Integer.MIN_VALUE;//returning smallest possible int
        }
        else {
            return root.min();
        }
    }

    public int max(){
        if(root == null){//means tree is empty
            return Integer.MAX_VALUE;//returning largest possible int
        }
        else{
            return root.max();
        }
    }
}
