package me.immathan;

public class BinaryTree {

    Node root;

    public BinaryTree() {

    }

    /**
     * To insert a Node into the BST
     * @param dataNode Node to insert
     */
    public void insert(Node dataNode) {
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
            } else { // This means that the data is already in the tree
                break;
            }
        }
    }

    public void remove(Node node) {
        removeNode(root, node.data);
    }

    public void inOrder() {
        inOrder(root);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void preOrder(Node node) {
        if(node != null) {
            System.out.print(" " + node.data);
            inOrder(node.left);
            inOrder(node.right);
        }
    }

    private void postOrder(Node node) {
        if(node != null) {
            inOrder(node.left);
            inOrder(node.right);
            System.out.print(" " + node.data);
        }
    }

    private void inOrder(Node node) {
        if(node != null) {
            inOrder(node.left);
            System.out.print(" " + node.data);
            inOrder(node.right);
        }
    }

    //private void transplant()

    private Node removeNode(Node node, int data) {
        if(node == null) {
            return null;
        }

        if(data < node.data) {
            node.left = removeNode(node.left, data);
        } else if(data > node.data) {
            node.right = removeNode(node.right, data);
        } else {
            if(node.left == null) {
                return node.right;
            } else if(node.right == null) {
                return node.left;
            }

            node.data = minNode(node.right).data;
            node.right = removeNode(node.right, node.data);
        }

        return node;
    }

    /**
     * To search for a data into the BST
     * @param data Integer data to search
     * @return true if the data is present
     */
    public boolean search(int data) {
        return searchNode(root, data) != null;
    }

    public Node min() {
        if(root == null) {
            return null;
        }
        return minNode(root);
    }

    public Node max() {
        if(root == null) {
            return null;
        }
        return maxNode(root);
    }

    private Node maxNode(Node node) {
        if(node == null) {
            return null;
        }

        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private Node minNode(Node node) {
        if(node == null) {
            return null;
        }

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node searchNode(Node node, int data) {
        if(node == null) {
            return null;
        }
        if(node.data < data) {
            return searchNode(node.right, data);
        } else if(node.data > data) {
            return searchNode(node.left, data);
        }
        return node;
    }

}
