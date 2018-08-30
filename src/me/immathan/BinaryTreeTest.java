package me.immathan;

import org.junit.Assert;

public class BinaryTreeTest {

    BinaryTree binaryTree = new BinaryTree();

    @org.junit.Before
    public void setUp() throws Exception {
        binaryTree.insert(10);
        binaryTree.insert(20);
        binaryTree.insert(4);
        binaryTree.insert(8);
        binaryTree.insert(7);
    }

    @org.junit.Test
    public void insert() {
        Assert.assertEquals(binaryTree.root.data, 10);
        Assert.assertEquals(binaryTree.root.left.right.left.data, 7);
    }

    @org.junit.Test
    public void searchData() {
        Assert.assertTrue(binaryTree.searchData(7));
        Assert.assertFalse(binaryTree.searchData(30));
        Assert.assertTrue(binaryTree.searchData(20));
        Assert.assertFalse(binaryTree.searchData(11));
    }
}