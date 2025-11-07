import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

/**
    Add a method void depthFirst(Visitor v) to the Tree class of
    Section 17.4 (below).
    Keep visiting until the visit method returns false.
*/
public class Tree
{
    private Node root;

    class Node
    {
        public Object data;
        public List<Node> children;

        /**
            Computes the size of the subtree whose root is this node.
            @return the number of nodes in the subtree
        */
        public int size()
        {
            int sum = 0;
            for (Node child : children) { sum = sum + child.size(); }
            return 1 + sum;
        }
    }

    /**
        Constructs an empty tree.
    */
    public Tree()
    {
        root = null;
    }

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    public Tree(Object rootData)
    {
        root = new Node();
        root.data = rootData;
        root.children = new ArrayList<>();
    }

    /**
        Adds a subtree as the last child of the root.
    */
    public void addSubtree(Tree subtree)
    {
        root.children.add(subtree.root);
    }

    /**
        Computes the size of this tree.
        @return the number of nodes in the tree
    */
    public int size()
    {
        if (root == null) { return 0; }
        else { return root.size(); }
    }

    /*
     * A visitor method is called for each visited node during a tree traversal.
     */
    public interface Visitor {
        /*
         * The visit method is called for each visited node
         * @param data: The data of the node being visited
         */
        boolean visit(Object data);
    }

    public void depthFirst(Visitor v)
    {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        boolean cont = true;
        while(cont && stack.size() > 0) {
            Node n = stack.pop();
            cont = v.visit(n.data);
            if(cont == true) {
                for(Node child : n.children) {
                    stack.push(child);
                }
            }
        }
    }

    /*
     * Traverse the tree in postorder.
     * @param v: The visitor to be invoked on each node.
     */
    public void postorder(Visitor v) {
        Tree.postorder(this.root, v);
    }
    
    /*
     * Traverse the tree in postorder.
     * @param v: The visitor to be invoked on each node.
     */
    private static void postorder(Node n, Visitor v) {
        if (n == null) {
            return;
        }
        v.visit(n.data);
        for (Node child : n.children) {
            Tree.postorder(child, v);
        }
    }
}
