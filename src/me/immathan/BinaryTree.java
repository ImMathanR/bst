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
                    dataNode.parent = temp;
                    temp.left = dataNode;
                    temp = dataNode;
                }
            } else if (dataNode.data > temp.data) {
                if (temp.right != null) {
                    temp = temp.right;
                } else {
                    dataNode.parent = temp;
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

    public int predecessor(int value) {
        Node node = searchNode(root, value);
        return predecessor(node).data;
    }

    public int successor(int value) {
        Node node = searchNode(root, value);
        return successor(node).data;
    }

    private void preOrder(Node node) {
        if(node != null) {
            System.out.print(" " + node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void postOrder(Node node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
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

    private Node predecessor(Node node) {
        if(node.left != null) {
            return maxNode(node.left);
        }

        Node parent = node.parent;
        while (parent != null && node == parent.left) {
            node = parent;
            parent = parent.parent;
        }

        return parent;
    }

    private Node successor(Node node) {
        if(node.right != null) {
            return minNode(node.right);
        }

        Node parent = node.parent;
        while (parent != null && node == parent.right) {
            node = parent;
            parent = parent.parent;
        }

        return parent;
    }

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
