public class Tree {

    // INSERT
    static Node insert(Node root, int data) {

        // Empty tree
        if (root == null) {
            return new Node(data);
        }

        // Go left
        if (data < root.data) {
            root.left = insert(root.left, data);
        }

        // Go right
        else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        // If data == root.data, do nothing
        return root;
    }


    // DELETE
    static Node delete(Node root, int data) {

        // Data not found
        if (root == null) {
            return null;
        }

        // Search left
        if (data < root.data) {
            root.left = delete(root.left, data);
        }

        // Search right
        else if (data > root.data) {
            root.right = delete(root.right, data);
        }

        // Node found
        else {

            // No left child
            if (root.left == null) {
                return root.right;
            }

            // No right child
            else if (root.right == null) {
                return root.left;
            }

            // Two children
            else {
                int min = minimum(root.right);

                root.data = min;

                root.right = delete(root.right, min);
            }
        }

        return root;
    }


    // FIND MINIMUM
    static int minimum(Node node) {

        while (node.left != null) {
            node = node.left;
        }

        return node.data;
    }


    // INORDER
    static void inorder(Node root) {

        if (root != null) {

            inorder(root.left);

            System.out.print(root.data + " ");

            inorder(root.right);
        }
    }


    // PREORDER
    static void preorder(Node root) {

        if (root != null) {

            System.out.print(root.data + " ");

            preorder(root.left);

            preorder(root.right);
        }
    }


    // POSTORDER
    static void postorder(Node root) {

        if (root != null) {

            postorder(root.left);

            postorder(root.right);

            System.out.print(root.data + " ");
        }
    }


    public static void main(String[] args) {

        Node root = null;

        // Insert
        root = insert(root, 75);
        root = insert(root, 50);
        root = insert(root, 100);
        root = insert(root, 25);
        root = insert(root, 60);
        root = insert(root, 90);
        root = insert(root, 120);

        /*
                  75
                 /  \
               50    100
              / \    /  \
            25  60  90  120
        */

        System.out.print("Inorder: ");
        inorder(root);

        System.out.println();

        System.out.print("Preorder: ");
        preorder(root);

        System.out.println();

        System.out.print("Postorder: ");
        postorder(root);

        System.out.println();


        // Delete
        root = delete(root, 100);

        System.out.print("After deleting 100: ");
        inorder(root);
    }
}


class Node {

    int data;

    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}