package me.immathan;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest {

    BinaryTree binaryTree = new BinaryTree();

    @org.junit.Before
    public void setUp() throws Exception {
        binaryTree.insert(new Node(10));
        binaryTree.insert(new Node(20));
        binaryTree.insert(new Node(4));
        binaryTree.insert(new Node(8));
        binaryTree.insert(new Node(7));
        binaryTree.insert(new Node(30));
        binaryTree.insert(new Node(25));
    }

    @org.junit.Test
    public void insert() {
        Assert.assertEquals(binaryTree.root.data, 10);
        Assert.assertEquals(binaryTree.root.left.data, 4);
        Assert.assertEquals(binaryTree.root.left.right.left.data, 7);
    }

    @org.junit.Test
    public void searchData() {
        Assert.assertTrue(binaryTree.search(7));
        Assert.assertFalse(binaryTree.search(30));
        Assert.assertTrue(binaryTree.search(20));
        Assert.assertFalse(binaryTree.search(11));
    }

    @Test
    public void min() {
        Assert.assertEquals(binaryTree.min().data, 4);
        Assert.assertNotEquals(binaryTree.min().data, 7);
    }

    @Test
    public void max() {
        Assert.assertEquals(binaryTree.max().data, 20);
        Assert.assertNotEquals(binaryTree.max().data, 7);
    }

    @Test
    public void inOrder() {
        binaryTree.inOrder();
    }

    @Test
    public void preOrder() {
        binaryTree.preOrder();
    }

    @Test
    public void postOrder() {
        binaryTree.postOrder();
    }

    @Test
    public void remove() {
        binaryTree.remove(new Node(4));
        inOrder();
        Assert.assertEquals(binaryTree.min().data, 7);
        binaryTree.remove(new Node(7));
        inOrder();
        Assert.assertEquals(binaryTree.min().data, 8);
    }

    @Test
    public void predecessor() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(new Node(10));
        binaryTree.insert(new Node(20));
        binaryTree.insert(new Node(4));
        binaryTree.insert(new Node(8));
        binaryTree.insert(new Node(7));

        Assert.assertEquals(binaryTree.predecessor(8), 7);
        Assert.assertEquals(binaryTree.predecessor(20), 10);
    }

    @Test
    public void successor() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(new Node(10));
        binaryTree.insert(new Node(20));
        binaryTree.insert(new Node(4));
        binaryTree.insert(new Node(8));
        binaryTree.insert(new Node(7));

        Assert.assertEquals(binaryTree.successor(4), 7);
        Assert.assertEquals(binaryTree.predecessor(8), 7);
    }

}