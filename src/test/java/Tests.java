import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Tests {

    @Test
    public void testInsert1() {
        int[] nodeRoot = {5, 0, 0, 0, 0};
        int[] node0 = {2, 3, 4, 0, 0};
        int[] node1 = {6, 10, 11, 98, 0};
        Tree tree = new Tree(5); // дерево с максимум 5 элементами
        tree.insert(4);
        tree.insert(11);
        tree.insert(10);
        tree.insert(2);
        tree.insert(5);
        tree.insert(6);
        tree.insert(3);
        tree.insert(98);
        Tree.Node root = tree.getRoot();
        assertArrayEquals(root.keys, nodeRoot);
        assertArrayEquals(root.children[0].keys, node0);
        assertArrayEquals(root.children[1].keys, node1);
    }

    @Test
    public void testInsert2() {
        int[] nodeRoot = {5, 11, 0, 0, 0};
        int[] node0 = {2, 3, 4, 0, 0};
        int[] node1 = {6, 10, 0, 0, 0};
        int[] node2 = {34, 55, 98, 0, 0};
        Tree tree = new Tree(5);
        tree.insert(4);
        tree.insert(11);
        tree.insert(10);
        tree.insert(2);
        tree.insert(5);
        tree.insert(6);
        tree.insert(3);
        tree.insert(98);
        tree.insert(55);
        tree.insert(34);
        Tree.Node root = tree.getRoot();
        assertArrayEquals(root.keys, nodeRoot);
        assertArrayEquals(root.children[0].keys, node0);
        assertArrayEquals(root.children[1].keys, node1);
        assertArrayEquals(root.children[2].keys, node2);
    }

    @Test
    public void testInsert3() {
        int[] nodeRoot = {5, 11, 0, 0, 0};
        int[] node0 = {0, 1, 2, 3, 4};
        int[] node1 = {6, 7, 8, 9, 10};
        int[] node2 = {34, 42, 55, 88, 98};
        Tree tree = new Tree(5);
        tree.insert(4);
        tree.insert(11);
        tree.insert(10);
        tree.insert(2);
        tree.insert(5);
        tree.insert(6);
        tree.insert(3);
        tree.insert(98);
        tree.insert(55);
        tree.insert(34);
        tree.insert(7);
        tree.insert(1);
        tree.insert(8);
        tree.insert(9);
        tree.insert(0);
        tree.insert(42);
        tree.insert(88);
        Tree.Node root = tree.getRoot();
        assertArrayEquals(root.keys, nodeRoot);
        assertArrayEquals(root.children[0].keys, node0);
        assertArrayEquals(root.children[1].keys, node1);
        assertArrayEquals(root.children[2].keys, node2);
    }

    @Test
    public void testInsert4() {
        int[] nodeRoot = {55, 0, 0, 0, 0};
        int[] node0 = {5, 11, 0, 0, 0};
        int[] node1 = {65, 98, 103, 0, 0};
        int[] node2 = {0, 1, 2, 3, 4};
        int[] node3 = {6, 7, 8, 9, 10};
        int[] node4 = {33, 34, 42, 0, 0};
        int[] node5 = {56, 59, 0, 0, 0};
        int[] node6 = {66, 67, 88, 0, 0};
        int[] node7 = {101, 102, 0, 0, 0};
        int[] node8 = {666, 777, 808, 0, 0};
        Tree tree = new Tree(5);
        tree.insert(4);
        tree.insert(11);
        tree.insert(10);
        tree.insert(2);
        tree.insert(5);
        tree.insert(6);
        tree.insert(3);
        tree.insert(98);
        tree.insert(55);
        tree.insert(34);
        tree.insert(7);
        tree.insert(1);
        tree.insert(8);
        tree.insert(9);
        tree.insert(0);
        tree.insert(42);
        tree.insert(88);
        tree.insert(101);
        tree.insert(102);
        tree.insert(59);
        tree.insert(103);
        tree.insert(33);
        tree.insert(56);
        tree.insert(65);
        tree.insert(808);
        tree.insert(666);
        tree.insert(777);
        tree.insert(66);
        tree.insert(67);
        Tree.Node root = tree.getRoot();
        assertArrayEquals(root.keys, nodeRoot);
        assertArrayEquals(root.children[0].keys, node0);
        assertArrayEquals(root.children[1].keys, node1);
        assertArrayEquals(root.children[0].children[0].keys, node2);
        assertArrayEquals(root.children[0].children[1].keys, node3);
        assertArrayEquals(root.children[0].children[2].keys, node4);
        assertArrayEquals(root.children[1].children[0].keys, node5);
        assertArrayEquals(root.children[1].children[1].keys, node6);
        assertArrayEquals(root.children[1].children[2].keys, node7);
        assertArrayEquals(root.children[1].children[3].keys, node8);
    }

    @Test
    public void testInsert5() {
        Tree tree = new Tree(3);
        int[] nodeRoot = {20, 0, 0};
        int[] node0 = {12, 0, 0};
        int[] node1 = {35, 0, 0};
        int[] node2 = {10, 0, 0};
        int[] node3 = {15, 0, 0};
        int[] node4 = {4, 0, 0};
        int[] node5 = {11, 0, 0};
        int[] node6 = {14, 0, 0};
        int[] node7 = {17, 0, 0};
        int[] node8 = {25, 0, 0};
        int[] node9 = {50, 80, 0};
        int[] node10 = {22, 0, 0};
        int[] node11 = {30, 0, 0};
        int[] node12 = {40, 0, 0};
        int[] node13 = {60, 0, 0};
        int[] node14 = {90, 100, 0};
        tree.insert(4);
        tree.insert(11);
        tree.insert(10);
        tree.insert(12);
        tree.insert(14);
        tree.insert(15);
        tree.insert(17);
        tree.insert(20);
        tree.insert(22);
        tree.insert(25);
        tree.insert(30);
        tree.insert(35);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);
        tree.insert(80);
        tree.insert(90);
        tree.insert(100);
        Tree.Node root = tree.getRoot();
        assertArrayEquals(root.keys, nodeRoot);
        //0 ветвь
        assertArrayEquals(root.children[0].keys, node0);
        assertArrayEquals(root.children[0].children[0].keys, node2);
        assertArrayEquals(root.children[0].children[1].keys, node3);
        assertArrayEquals(root.children[0].children[0].children[0].keys, node4);
        assertArrayEquals(root.children[0].children[0].children[1].keys, node5);
        assertArrayEquals(root.children[0].children[1].children[0].keys, node6);
        assertArrayEquals(root.children[0].children[1].children[1].keys, node7);
        //1 ветвь
        assertArrayEquals(root.children[1].keys, node1);
        assertArrayEquals(root.children[1].children[0].keys, node8);
        assertArrayEquals(root.children[1].children[1].keys, node9);
        assertArrayEquals(root.children[1].children[0].children[0].keys, node10);
        assertArrayEquals(root.children[1].children[0].children[1].keys, node11);
        assertArrayEquals(root.children[1].children[1].children[0].keys, node12);
        assertArrayEquals(root.children[1].children[1].children[1].keys, node13);
        assertArrayEquals(root.children[1].children[1].children[2].keys, node14);
    }
}
