import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class MyPrinter {

    /* Print one dimensional array */
    public void printArray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    /* Print two dimensional array */
    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] < 10){
                    System.out.print(" ");
                }
                System.out.print(" " + arr[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    /* Print two dimensional Vector */
    public static void printVector(Vector<Vector<Integer>> v) {
        for (int i = 0; i < v.size(); i++) {
            for (int j = 0; j < v.get(0).size(); j++) {
                System.out.print(" " + v.get(i).get(j));
            }
            System.out.println("");
        }
        System.out.println("");
    }

    /* Print the three diagram */
    public void printTreeDiagram(BSTNode root) {
        int maxLevel = maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<BSTNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<BSTNode> newNodes = new ArrayList<BSTNode>();
        for (BSTNode node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(BSTNode node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }
        return true;
    }

    public void printLinkedlist(LLNode root){
        if(root == null){
            System.out.print("List empty");
        }
        else {
            LLNode iter = root;
            while(iter != null && iter.next != null) {
                System.out.print(iter.data + " --> ");
                iter = iter.next;
            }
            if(iter != null) {
                System.out.print(iter.data + "");
            }
        }
        System.out.println("");
    }

}
