package binarytree;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void add(int value) {
        root = add(root, value);
    }

    private Node add(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = add(current.left, value);
        } else if (value > current.value) {
            current.right = add(current.right, value);
        }
        return current;
    }

    public void delete(int value) {
        root = delete(root, value, DeleteStrategy.IN_ORDER_SUCCESSOR);
    }

    private Node delete(Node current, int value, DeleteStrategy strategy) {
        if (current == null) {
            return null;
        }

        if (value < current.value) {
            current.left = delete(current.left, value, strategy);
        } else if (value > current.value) {
            current.right = delete(current.right, value, strategy);
        } else {
            if (current.left == null && current.right == null) {
                return null;
            }

            if (current.left == null) {
                return current.right;
            }

            if (current.right == null) {
                return current.left;
            }

            switch (strategy) {
                case IN_ORDER_SUCCESSOR -> {
                    int smallestValue = findSmallestValue(current.right);
                    current.value = smallestValue;
                    current.right = delete(current.right, smallestValue, strategy);
                }
                case IN_ORDER_PREDECESSOR -> {
                    int largestValue = findLargestValue(current.left);
                    current.value = largestValue;
                    current.left = delete(current.left, largestValue, strategy);
                }
            }
        }

        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    private int findLargestValue(Node root) {
        return root.right == null ? root.value : findLargestValue(root.right);
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.println(node.value);
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.println(node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.println(node.value);
        }
    }

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public enum DeleteStrategy {
        IN_ORDER_PREDECESSOR, IN_ORDER_SUCCESSOR;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(20);

        System.out.println("In-Order Traversal:");
        tree.traverseInOrder(tree.root);

        System.out.println("Pre-Order Traversal:");
        tree.traversePreOrder(tree.root);

        System.out.println("Post-Order Traversal:");
        tree.traversePostOrder(tree.root);

        System.out.println("Deleting leaf node 10");
        tree.delete(10);
        tree.traverseInOrder(tree.root);

        System.out.println("Deleting leaf node 3");
        tree.delete(3);
        tree.traverseInOrder(tree.root);
    }
}
