# Tree

## Source Code
### TreeNode.java
```
import java.util.ArrayList;

public class TreeNode{
    TreeNode parent;
    double distance;
    ArrayList<TreeNode> children;
    int data;

    public TreeNode(int new_data){
        this.data = new_data;
        this.parent = null;
        this.distance = 0.0;
        this.children = new ArrayList<TreeNode>();
    }

    /* set this node's parent into new parent
     * set this node's distance into distance
     * if this node's parent is not nul, then add this as parent's child
     */
    void set_parent(TreeNode new_parent, double distance){
        this.parent = new_parent;
        this.distance = distance;
        if(this.parent != null){
            this.parent.children.add(this);
        }
    }

    // alias to set_parent(new_parent, 0)
    void set_parent(TreeNode new_parent){
        this.set_parent(new_parent, 0);
    }

    /* call new_child.set_parent. The new parent of new_child should be this
     * The distance of new_child should be set to distance
     */
    void add_child(TreeNode new_child, double distance){
        new_child.set_parent(this, distance);
    }

    /* Simply remove child from this node's children */
    void remove_child(TreeNode child){
        child.parent = null;
        child.distance = 0.0;
        this.children.remove(child);
    }

    /* print this node's data, this node's distance, and distance + this node's distance
     * for each of this node's children, recursively call child's print method
     */
    void print(String spaces, double distance){
        System.out.println(spaces + this.data + " distance from parent : " + this.distance + " distance from initial node : " + (distance + this.distance));
        for(int i=0; i<this.children.size(); i++){
            this.children.get(i).print(spaces + " ", distance + this.distance);
        }
    }

    void print(){
        this.print("", 0);
    }

}
```

### Tree.java
```
public class Tree{
    TreeNode root;

    public Tree(){
        this.root = null;
    }

    public Tree(TreeNode root){
        this.root = root;
    }

    void print(){
        if(this.root == null){
            System.out.println();
        }else{
            this.root.print();
        }
    }
}
```
### TestTree.java
```
import java.util.Scanner;

public class TestTree {

    /**
     * @param args the command line arguments
     */
    static Tree t = new Tree(new TreeNode(1));
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        while (true) {
            System.out.println(" TREE INTERFACE ");
            System.out.println("1. Add child");
            System.out.println("2. Print");
            System.out.println("3. Exit");
            System.out.print("Enter your choice : ");
            int choice = input.nextInt();
            if (choice == 3) {
                break;
            } else {
                switch (choice) {
                    case 1:
                        System.out.println("1. Add child from root");
                        System.out.println("2. Add child from parent");
                        System.out.print("Enter your choice : ");
                        int choice_1 = input.nextInt();
                        switch (choice_1) {
                            case 1:
                                System.out.print("Type the new node for the tree : ");
                                int treeNode = input.nextInt();
                                System.out.print("Type the distance from the root : ");
                                double distance = input.nextDouble();
                                t.root.add_child(new TreeNode(treeNode), distance);
                                break;
                            case 2:
                                if (t.root.children.size() == 0) {
                                    System.out.println("Tree still not have a children yet!");
                                } else {
                                    System.out.print("Choose the parent index for the new node : ");
                                    int parent = input.nextInt();
                                    System.out.print("Type the new node for the tree : ");
                                    int tree_Node = input.nextInt();
                                    System.out.print("Type the distance from the root : ");
                                    double dist = input.nextDouble();
                                    t.root.children.get(parent).add_child(new TreeNode(tree_Node), dist);
                                }
                                break;
                        }
                        break;
                    case 2:
                        t.root.print();
                        break;
                }
            }
        }
    }
}
```