import java.io.FileWriter;
import java.io.IOException;

public class TwoThreeBST_Q2<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;     // root of the BST
    private int n;         // number of key-value pairs in BST

    private int sum;        //sum of each node's path length

    // BST helper node data type
    private class Node {
        private Key key;           // key
        private Value val;         // associated data
        private Node left, right;  // links to left and right subtrees
        private boolean color;     // color of parent link

        public Node(Key key, Value val, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }
    }

    /***************************************************************************
     *  Standard BST search.
     ***************************************************************************/

    // return value associated with the given key, or null if no such key exists
    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    // is there a key-value pair in the symbol table with the given key?
    public boolean contains(Key key) {
        return get(key) != null;
    }


    /***************************************************************************
     *  Two-three tree insertion.
     ***************************************************************************/

    public void put(Key key, Value val) {
        root = insert(root, key, val, BLACK);
        root.color = BLACK;
        assert check();
    }

    private Node insert(Node h, Key key, Value val, boolean color) {    //also pass the color of parent node as parameter
        if (h == null) {
            n++;
            if (color == RED)
                return new Node(key, val, BLACK);   //if parent node is red, link new node with black color
            return new Node(key, val, RED);
        }

        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = insert(h.left, key, val, h.color);
        else if (cmp > 0) h.right = insert(h.right, key, val, h.color);
        else h.val = val;

        return h;
    }

    /***************************************************************************
     *  Helper functions.
     ***************************************************************************/

    // is node x red (and non-null) ?
    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }


    /***************************************************************************
     *  Utility functions.
     ***************************************************************************/
    // return number of key-value pairs in symbol table
    public int size() {
        return n;
    }

    // is the symbol table empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // height of tree (1-node tree has height 0)
    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    // return the smallest key; null if no such key
    public Key min() {
        return min(root);
    }

    private Key min(Node x) {
        Key key = null;
        while (x != null) {
            key = x.key;
            x = x.left;
        }
        return key;
    }

    // return the largest key; null if no such key
    public Key max() {
        return max(root);
    }

    private Key max(Node x) {
        Key key = null;
        while (x != null) {
            key = x.key;
            x = x.right;
        }
        return key;
    }


    /***************************************************************************
     *  Iterate using an inorder traversal.
     *  Iterating through N elements takes O(N) time.
     ***************************************************************************/
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue) {
        if (x == null) return;
        keys(x.left, queue);
        queue.enqueue(x.key);
        keys(x.right, queue);
    }


    /***************************************************************************
     *  Check integrity of two-three tree data structure.
     ***************************************************************************/
    private boolean check() {
        if (!isBST()) System.out.println("Not in symmetric order");
        if (!is23()) System.out.println("Not a 2-3 tree");
        return isBST() && is23();
    }

    // does this binary tree satisfy symmetric order?
    // Note: this test also ensures that data structure is a binary tree since order is strict
    private boolean isBST() {
        return isBST(root, null, null);
    }

    // is the tree rooted at x a BST with all keys strictly between min and max
    // (if min or max is null, treat as empty constraint)
    // Credit: Bob Dondero's elegant solution
    private boolean isBST(Node x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }

    // Does the tree have no red right links, and at most one (left)
    // red links in a row on any path?
    private boolean is23() {
        return is23(root);
    }

    private boolean is23(Node x) {
        if (x == null) return true;
        if (isRed(x.right)) return false;
        if (x != root && isRed(x) && isRed(x.left))
            return false;
        return is23(x.left) && is23(x.right);
    }

    public double getAvgPathLength() {
        sum = 0;
        calculatePath(root, 0);
        return sum * 1.0 / n;
    }

    private void calculatePath(Node node, int length) {
        if (node == null) return;
        calculatePath(node.left, length + 1);
        calculatePath(node.right, length + 1);
        sum += length;
    }

    public static void main(String[] args) {
        String COMMA_DELIMITER = ",";
        String NEW_LINE_SEPARATOR = "\n";
        String fileName="TwoThreeBST_PathLength.csv";
        String FILE_HEADER = "Size,Random,Sorted";
        FileWriter fileWriter = null;

        try
        {

            fileWriter = new FileWriter(fileName);
            fileWriter.append(FILE_HEADER.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (int sz = 1; sz < 20000; sz*=2) {   //loop for every data size from 1 to 16384
                System.out.println(sz);
                Integer[] keys = new Integer[sz];
                double random=0;   //sum of average path length of BST built by random input
                double sorted=0;    //sum of average path length of BST built by sorted input

                //compute path length of random-input-built BST
                for (int trial = 0; trial < 100; trial++) {    //loop for 100 trials for every size of data
                    TwoThreeBST_Q2<Integer, Integer> st = new TwoThreeBST_Q2<Integer, Integer>();
                    //initiate BST
                    for (int i = 0; i < sz; i++) {
                        keys[i] = (int) (Math.random() * sz);
                        st.put(keys[i], i);
                    }
                    random+= st.getAvgPathLength();
                }
                random=random/100.0;

                //compute path length of sorted-input-built BST
                TwoThreeBST_Q2<Integer, Integer> st2 = new TwoThreeBST_Q2<Integer, Integer>();
                for (int i = 0; i < sz; i++) {
                    st2.put(i, i);
                }
                sorted=st2.getAvgPathLength();

                //write to file
                fileWriter.append(Integer.toString(sz));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(Double.toString(random));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(Double.toString(sorted));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

        }
        catch (Exception e)
        {
            System.out.println("Error in CsvFileWriter");
            e.printStackTrace();
        }

        finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter");
                e.printStackTrace();
            }
        }
    }
}