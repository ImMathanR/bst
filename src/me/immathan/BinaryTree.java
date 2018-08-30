package me.immathan;

public class BinaryTree {

    Node root;

    public BinaryTree() {

    }

    public void insert(int data) {
        Node dataNode = new Node(data);
        if (root == null) {
            this.root = dataNode;
            return;
        }

        Node temp = root;
        while (temp != null) {
            if (dataNode.data < temp.data) {
                if (temp.left != null) {
                    temp = temp.left;
                } else {
                    temp.left = dataNode;
                    temp = dataNode;
                }
            } else if (dataNode.data > temp.data) {
                if (temp.right != null) {
                    temp = temp.right;
                } else {
                    temp.right = dataNode;
                    temp = dataNode;
                }
            } else { // This means that the data which we are inserting is already in the tree
                break;
            }
        }
    }

    private boolean search(Node node, int data) {
        if(node == null) {
            return false;
        }
        if(node.data < data) {
            return search(node.right, data);
        } else if(node.data > data) {
            return search(node.left, data);
        }
        return true;
    }

    public boolean searchData(int data) {
        return search(root, data);
    }

}
