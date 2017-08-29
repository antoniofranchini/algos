import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree {

    public class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    BinarySearchTree(){
        this.root = null;
    }

    public void setRoot(Node root){
        this.root = root;
    }

    public Node getRoot(){
        return this.root;
    }

    public void addNode(int data){
        if(this.root == null){
            this.root = new Node(data);
        }
        else {
            addNode(data, this.root);
        }
    }

    public Node createNode(int data){
        return new Node(data);
    }

    public void addNode(int data, Node root){
        if(data < root.data){
            if(root.left == null) {
                root.left = new Node(data);
            }
            else{
                addNode(data, root.left);
            }
        }
        else{
            if(root.right == null) {
                root.right = new Node(data);
            }
            else{
                addNode(data, root.right);
            }
        }
    }

    public void printTree(){
        if(this.root == null){
            System.out.println("The tree is empty");
        }
        else{
            printTree(this.root);
        }
    }

    public void printTree(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }

    //          5
    //        /    \
    //       2      8
    //     /  \    /
    //    1   4   6
    //
    //
    //   5 2 8 1 4 6

    public boolean isBinaryTree(Node root, int min, int max){
        /* An empty tree is a Binary Tree */
        if (root == null)
            return true;
        /* False if this node violates the min/max constraints */
        if (root.data < min || root.data > max)
            return false;
        /* Otherwise check the subtrees recursively tightening the min/max constraints */
        return (isBinaryTree(root.left, min, root.data) &&
                isBinaryTree(root.right, root.data, max));
    }

    public Node getLowestCommonAncestor(Node root, Node n1, Node n2){
        /* return null if this path didn't find neither n1 or n2 */
        if (root == null)
            return null;

        /* return this node if this path did find either n1 or n2 */
        if (root == n1 || root == n2)
            return root;

        /* continue searching in the left and right paths (for either one of the two nodes or null) */
        Node leftTree = getLowestCommonAncestor(root.left, n1, n2);
        Node rightTree = getLowestCommonAncestor(root.right, n1, n2);

        /* if the current node subtree contain the two target nodes then this is the ancestor */
        if(leftTree != null && rightTree != null ){
            return root;
        }
        /* otherwise the left child is the the ancestor */
        else if(leftTree != null){
            return leftTree;
        }
        /* otherwise the right child is the the ancestor */
        else{
            return rightTree;
        }
    }

}
