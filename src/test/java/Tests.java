import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

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
        int[] nodeRoot = {8, 0, 0, 0, 0};
        int[] node0 = {2, 5, 0, 0, 0};
        int[] node1 = {11, 55, 0, 0, 0};
        int[] node2 = {0, 1, 0, 0, 0};
        int[] node3 = {3, 4, 0, 0, 0};
        int[] node4 = {6, 7, 0, 0, 0};
        int[] node5 = {9, 10, 0, 0, 0};
        int[] node6 = {34, 42, 0, 0, 0};
        int[] node7 = {88, 98, 0, 0, 0};
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
        assertArrayEquals(root.children[0].children[0].keys, node2);
        assertArrayEquals(root.children[0].children[1].keys, node3);
        assertArrayEquals(root.children[0].children[2].keys, node4);
        assertArrayEquals(root.children[1].keys, node1);
        assertArrayEquals(root.children[1].children[0].keys, node5);
        assertArrayEquals(root.children[1].children[1].keys, node6);
        assertArrayEquals(root.children[1].children[2].keys, node7);
    }

    @Test
    public void testInsert4() {
        int[] nodeRoot = {8, 65, 103, 0, 0};
        int[] node0 = {2, 5, 0, 0, 0};
        int[] node1 = {11, 16, 33, 55, 0};
        int[] node2 = {68, 98, 0, 0, 0};
        int[] node3 = {808, 1002, 0, 0, 0};
        int[] node4 = {0, 1, 0, 0, 0};
        int[] node5 = {3, 4, 0, 0, 0};
        int[] node6 = {6, 7, 0, 0, 0};
        int[] node7 = {9, 10, 0, 0, 0};
        int[] node8 = {12, 14, 0, 0, 0};
        int[] node9 = {17, 19, 0, 0, 0};
        int[] node10 = {34, 42, 0, 0, 0};
        int[] node11 = {56, 59, 0, 0, 0};
        int[] node12 = {66, 67, 0, 0, 0};
        int[] node13 = {69, 88, 0, 0, 0};
        int[] node14 = {101, 102, 0, 0, 0};
        int[] node15 = {666, 777, 0, 0, 0};
        int[] node16 = {909, 1001, 0, 0, 0};
        int[] node17 = {1003, 1004, 0, 0, 0};
        Tree tree = new Tree(5);
        int[] array = {4, 11, 10, 2, 5, 6, 3, 98, 55, 34, 7, 1, 8, 9, 0, 42, 88, 101, 102, 59, 103, 33, 56, 65,
                808, 666, 777, 66, 67, 12, 14, 16, 17, 19, 68, 909, 1001, 1002, 1003, 1004, 69};
        for (int number : array) {
            tree.insert(number);
        }
        Tree.Node root = tree.getRoot();
        assertArrayEquals(root.keys, nodeRoot);
        // 0 ветвь
        assertArrayEquals(root.children[0].keys, node0);
        assertArrayEquals(root.children[0].children[0].keys, node4);
        assertArrayEquals(root.children[0].children[1].keys, node5);
        assertArrayEquals(root.children[0].children[2].keys, node6);
        // 1 ветвь
        assertArrayEquals(root.children[1].keys, node1);
        assertArrayEquals(root.children[1].children[0].keys, node7);
        assertArrayEquals(root.children[1].children[1].keys, node8);
        assertArrayEquals(root.children[1].children[2].keys, node9);
        assertArrayEquals(root.children[1].children[3].keys, node10);
        assertArrayEquals(root.children[1].children[4].keys, node11);
        // 2 ветвь
        assertArrayEquals(root.children[2].keys, node2);
        assertArrayEquals(root.children[2].children[0].keys, node12);
        assertArrayEquals(root.children[2].children[1].keys, node13);
        assertArrayEquals(root.children[2].children[2].keys, node14);
        // 3 ветвь
        assertArrayEquals(root.children[3].keys, node3);
        assertArrayEquals(root.children[3].children[0].keys, node15);
        assertArrayEquals(root.children[3].children[1].keys, node16);
        assertArrayEquals(root.children[3].children[2].keys, node17);
    }

    @Test
    public void testInsert5() {
        Tree tree = new Tree(5);
        int[] list = {4, 11, 10, 2, 5, 6, 3, 98, 55, 34, 7, 1, 8, 9, 0, 42, 88, 101, 102, 59, 103, 33, 56, 65, 808,
                666, 777, 66, 67, 12, 14, 16, 17, 19, 68, 909, 1001, 1002, 1003, 1004, 69, 1005, 1006, 1007, 1008, 1009,
                1010, 1011, 1012, 1013, 1014, 1015, 1016, 1017, 1018, 1019, 1020, 1021, 1022};
        for (int element : list) {
            tree.insert(element);
        }
        int[] nodeRoot = {103, 0, 0, 0, 0};
        int[] node0 = {8, 65, 0, 0, 0};
        int[] node1 = {1005, 1014, 0, 0, 0};
        int[] node2 = {2, 5, 0, 0, 0};
        int[] node3 = {11, 16, 33, 55, 0};
        int[] node4 = {68, 98, 0, 0, 0};
        int[] node5 = {808, 1002, 0, 0, 0};
        int[] node6 = {1008, 1011, 0, 0, 0};
        int[] node7 = {1017, 1020, 0, 0, 0};
        int[] node8 = {0, 1, 0, 0, 0};
        int[] node9 = {3, 4, 0, 0, 0};
        int[] node10 = {6, 7, 0, 0, 0};
        int[] node11 = {9, 10, 0, 0, 0};
        int[] node12 = {12, 14, 0, 0, 0};
        int[] node13 = {17, 19, 0, 0, 0};
        int[] node14 = {34, 42, 0, 0, 0};
        int[] node15 = {56, 59, 0, 0, 0};
        int[] node16 = {66, 67, 0, 0, 0};
        int[] node17 = {69, 88, 0, 0, 0};
        int[] node18 = {101, 102, 0, 0, 0};
        int[] node19 = {666, 777, 0, 0, 0};
        int[] node20 = {909, 1001, 0, 0, 0};
        int[] node21 = {1003, 1004, 0, 0, 0};
        int[] node22 = {1006, 1007, 0, 0, 0};
        int[] node23 = {1009, 1010, 0, 0, 0};
        int[] node24 = {1012, 1013, 0, 0, 0};
        int[] node25 = {1015, 1016, 0, 0, 0};
        int[] node26 = {1018, 1019, 0, 0, 0};
        int[] node27 = {1021, 1022, 0, 0, 0};
        Tree.Node root = tree.getRoot();
        assertArrayEquals(root.keys, nodeRoot);
        // 0 ветвь
        assertArrayEquals(root.children[0].keys, node0);
        assertArrayEquals(root.children[0].children[0].keys, node2);
        assertArrayEquals(root.children[0].children[0].children[0].keys, node8);
        assertArrayEquals(root.children[0].children[0].children[1].keys, node9);
        assertArrayEquals(root.children[0].children[0].children[2].keys, node10);

        assertArrayEquals(root.children[0].children[1].keys, node3);
        assertArrayEquals(root.children[0].children[1].children[0].keys, node11);
        assertArrayEquals(root.children[0].children[1].children[1].keys, node12);
        assertArrayEquals(root.children[0].children[1].children[2].keys, node13);
        assertArrayEquals(root.children[0].children[1].children[3].keys, node14);
        assertArrayEquals(root.children[0].children[1].children[4].keys, node15);

        assertArrayEquals(root.children[0].children[2].keys, node4);
        assertArrayEquals(root.children[0].children[2].children[0].keys, node16);
        assertArrayEquals(root.children[0].children[2].children[1].keys, node17);
        assertArrayEquals(root.children[0].children[2].children[2].keys, node18);
        // 1 ветвь
        assertArrayEquals(root.children[1].keys, node1);
        assertArrayEquals(root.children[1].children[0].keys, node5);
        assertArrayEquals(root.children[1].children[0].children[0].keys, node19);
        assertArrayEquals(root.children[1].children[0].children[1].keys, node20);
        assertArrayEquals(root.children[1].children[0].children[2].keys, node21);

        assertArrayEquals(root.children[1].children[1].keys, node6);
        assertArrayEquals(root.children[1].children[1].children[0].keys, node22);
        assertArrayEquals(root.children[1].children[1].children[1].keys, node23);
        assertArrayEquals(root.children[1].children[1].children[2].keys, node24);

        assertArrayEquals(root.children[1].children[2].keys, node7);
        assertArrayEquals(root.children[1].children[2].children[0].keys, node25);
        assertArrayEquals(root.children[1].children[2].children[1].keys, node26);
        assertArrayEquals(root.children[1].children[2].children[2].keys, node27);
    }

    @Test
    public void testInsert6() {
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

    @Test
    public void testRemove1() {
        Tree tree = new Tree(3);
        int[] nodeRoot = {9, 0, 0};
        int[] node0 = {6, 0, 0};
        int[] node1 = {13, 40, 0};
        int[] node2 = {2, 0, 0};
        int[] node3 = {8, 0, 0};
        int[] node4 = {12, 0, 0};
        int[] node5 = {25, 0, 0};
        int[] node6 = {50, 0, 0};
        tree.insert(2);
        tree.insert(6);
        tree.insert(8);
        tree.insert(9);
        tree.insert(13);
        tree.insert(25);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);
        tree.insert(31);
        tree.insert(12);
        tree.removeFromNode(31, tree.getRoot());
        tree.removeFromNode(30, tree.getRoot());
        tree.removeFromNode(60, tree.getRoot());
        Tree.Node root = tree.getRoot();
        assertArrayEquals(root.keys, nodeRoot);
        assertArrayEquals(root.children[0].keys, node0);
        assertArrayEquals(root.children[1].keys, node1);
        assertArrayEquals(root.children[0].children[0].keys, node2);
        assertArrayEquals(root.children[0].children[1].keys, node3);
        assertArrayEquals(root.children[1].children[0].keys, node4);
        assertArrayEquals(root.children[1].children[1].keys, node5);
        assertArrayEquals(root.children[1].children[2].keys, node6);
    }

    @Test
    //удаление при взаимствовании у ближайших братьев значений, т.к. у удаляемого узла не выполняется условие > T / 2.
    public void testRemove2() {
        Tree tree = new Tree(7);
        int[] list = {4, 11, 10, 2, 5, 6, 3, 98, 55, 34, 7, 1, 8, 9, 0, 42, 88, 101, 102, 59, 103, 33, 56, 65, 808,
                666, 777, 66, 67, 12, 14, 16, 17, 19, 68, 909, 1001, 1002, 1003, 1004, 69, 1005, 1006, 1007, 1008, 1009,
                1010, 1011, 1012, 1013, 1014, 1015, 1016, 1017, 1018, 1019, 1020, 1021, 1022, 70, 71, 72, 73, 74};
        for (int element : list) {
            tree.insert(element);
        }
        int[] node1 = {66, 70, 74, 103, 0, 0, 0};
        int[] node2 = {71, 72, 73, 0, 0, 0, 0};
        int[] node3 = {88, 98, 102, 0, 0, 0, 0};
        Tree.Node root = tree.getRoot();
        tree.removeFromNode(101, tree.getRoot());
        assertArrayEquals(root.children[1].keys, node1);
        assertArrayEquals(root.children[1].children[2].keys, node2);
        assertArrayEquals(root.children[1].children[3].keys, node3);

        tree.insert(89);
        int[] node4 = {66, 70, 88, 103, 0, 0, 0};
        int[] node5 = {71, 73, 74, 0, 0, 0, 0};
        int[] node6 = {89, 98, 102, 0, 0, 0, 0};
        tree.removeFromNode(72, tree.getRoot());
        assertArrayEquals(root.children[1].keys, node4);
        assertArrayEquals(root.children[1].children[2].keys, node5);
        assertArrayEquals(root.children[1].children[3].keys, node6);

        tree.insert(57);
        int[] node7 = {65, 70, 88, 103, 0, 0, 0};
        int[] node8 = {56, 57, 59, 0, 0, 0, 0};
        int[] node9 = {66, 67, 68, 0, 0, 0, 0};
        tree.removeFromNode(69, tree.getRoot());
        assertArrayEquals(root.children[1].keys, node7);
        assertArrayEquals(root.children[1].children[0].keys, node8);
        assertArrayEquals(root.children[1].children[1].keys, node9);

        tree.insert(901);
        int[] node10 = {65, 70, 88, 666, 0, 0, 0};
        int[] node11 = {89, 102, 103, 0, 0, 0, 0};
        int[] node12 = {777, 808, 901, 0, 0, 0, 0};
        tree.removeFromNode(98, tree.getRoot());
        assertArrayEquals(root.children[1].keys, node10);
        assertArrayEquals(root.children[1].children[3].keys, node11);
        assertArrayEquals(root.children[1].children[4].keys, node12);

        tree.insert(104);
        int[] node13 = {65, 70, 88, 104, 0, 0, 0};
        int[] node14 = {89, 102, 103, 0, 0, 0, 0};
        int[] node15 = {666, 808, 901, 0, 0, 0, 0};
        tree.removeFromNode(777, tree.getRoot());
        assertArrayEquals(root.children[1].keys, node13);
        assertArrayEquals(root.children[1].children[3].keys, node14);
        assertArrayEquals(root.children[1].children[4].keys, node15);

        tree.insert(69);
        tree.insert(93);
        int[] node16 = {65, 69, 88, 104, 0, 0, 0};
        int[] node17 = {66, 67, 68, 0, 0, 0, 0};
        int[] node18 = {70, 71, 74, 0, 0, 0, 0};
        int[] node19 = {89, 93, 102, 103, 0, 0, 0};
        tree.removeFromNode(73, tree.getRoot());
        assertArrayEquals(root.children[1].keys, node16);
        assertArrayEquals(root.children[1].children[1].keys, node17);
        assertArrayEquals(root.children[1].children[2].keys, node18);
        assertArrayEquals(root.children[1].children[3].keys, node19);
    }

    @Test
    public void testRemove3() {
        Tree tree = new Tree(5);
        int[] array = {4, 11, 10, 2, 5, 6, 3, 98, 55, 34, 7, 1, 8, 9, 0, 42, 88, 101, 102, 59, 103, 33, 56, 65,
                808, 666, 777, 66, 67, 12, 14, 16, 17, 19, 68, 909, 1001, 1002, 1003, 1004, 69};
        for (int number : array) {
            tree.insert(number);
        }
        int[] node1 = {11, 16, 33, 0, 0};
        int[] node2 = {17, 19, 0, 0, 0};
        int[] node3 = {34, 42, 55, 56, 0};
        Tree.Node root = tree.getRoot();
        tree.removeFromNode(59, tree.getRoot());
        assertArrayEquals(root.children[1].keys, node1);
        assertArrayEquals(root.children[1].children[2].keys, node2);
        assertArrayEquals(root.children[1].children[3].keys, node3);

        tree.removeFromNode(42, tree.getRoot());
        tree.removeFromNode(56, tree.getRoot());
        int[] node4 = {34, 55, 0, 0, 0};
        assertArrayEquals(root.children[1].children[3].keys, node4);

        tree.removeFromNode(10, tree.getRoot());
        int[] node5 = {16, 33, 0, 0, 0};
        int[] node6 = {9, 11, 12, 14, 0};
        int[] node7 = {17, 19, 0, 0, 0};
        assertArrayEquals(root.children[1].keys, node5);
        assertArrayEquals(root.children[1].children[0].keys, node6);
        assertArrayEquals(root.children[1].children[1].keys, node7);

        tree.removeFromNode(14, tree.getRoot());
        tree.removeFromNode(12, tree.getRoot());
        int[] node8 = {9, 11, 0, 0, 0};
        assertArrayEquals(root.children[1].children[0].keys, node8);
        assertArrayEquals(root.children[1].children[1].keys, node7);

        tree.removeFromNode(11, tree.getRoot());
        int[] node9 = {65, 103, 0, 0, 0};
        int[] node10 = {2, 5, 8, 33, 0};
        int[] node11 = {0, 1, 0, 0, 0};
        int[] node12 = {3, 4, 0, 0, 0};
        int[] node13 = {6, 7, 0, 0, 0};
        int[] node14 = {9, 16, 17, 19, 0};
        int[] node15 = {34, 55, 0, 0, 0};
        assertArrayEquals(root.keys, node9);
        assertArrayEquals(root.children[0].keys, node10);
        assertArrayEquals(root.children[0].children[0].keys, node11);
        assertArrayEquals(root.children[0].children[1].keys, node12);
        assertArrayEquals(root.children[0].children[2].keys, node13);
        assertArrayEquals(root.children[0].children[3].keys, node14);
        assertArrayEquals(root.children[0].children[4].keys, node15);

        tree.removeFromNode(9, tree.getRoot());
        tree.removeFromNode(19, tree.getRoot());
        tree.removeFromNode(7, tree.getRoot());
        int[] node16 = {2, 8, 33, 0, 0};
        int[] node17 = {3, 4, 5, 6, 0};
        int[] node18 = {16, 17, 0, 0, 0};
        assertArrayEquals(root.children[0].keys, node16);
        assertArrayEquals(root.children[0].children[1].keys, node17);
        assertArrayEquals(root.children[0].children[2].keys, node18);

        tree.removeFromNode(909, tree.getRoot());
        int[] node19 = {65, 0, 0, 0, 0};
        int[] node20 = {68, 98, 103, 1002, 0};
        int[] node21 = {666, 777, 808, 1001, 0};
        int[] node22 = {101, 102, 0, 0, 0};
        int[] node23 = {1003, 1004, 0, 0, 0};
        assertArrayEquals(root.keys, node19);
        assertArrayEquals(root.children[1].keys, node20);
        assertArrayEquals(root.children[1].children[2].keys, node22);
        assertArrayEquals(root.children[1].children[3].keys, node21);
        assertArrayEquals(root.children[1].children[4].keys, node23);

        tree.removeFromNode(666, tree.getRoot());
        tree.removeFromNode(808, tree.getRoot());
        tree.removeFromNode(101, tree.getRoot());
        int[] node24 = {68, 103, 1002, 0, 0};
        int[] node25 = {69, 88, 98, 102, 0};
        assertArrayEquals(root.children[1].keys, node24);
        assertArrayEquals(root.children[1].children[1].keys, node25);

        tree.removeFromNode(102, tree.getRoot());
        tree.removeFromNode(69, tree.getRoot());
        tree.removeFromNode(66, tree.getRoot());
        tree.removeFromNode(88, tree.getRoot());
        tree.removeFromNode(68, tree.getRoot());
        tree.removeFromNode(1004, tree.getRoot());
        int[] node26 = {33, 0, 0, 0, 0};
        int[] node27 = {2, 8, 0, 0, 0};
        int[] node28 = {65, 103, 0, 0, 0};
        assertArrayEquals(root.keys, node26);
        assertArrayEquals(root.children[0].keys, node27);
        assertArrayEquals(root.children[1].keys, node28);

        tree.removeFromNode(1002, tree.getRoot());
        tree.removeFromNode(777, tree.getRoot());
        tree.removeFromNode(3, tree.getRoot());
        tree.removeFromNode(4, tree.getRoot());
        tree.removeFromNode(0, tree.getRoot());
        int[] node29 = {8, 33, 65, 103, 0};
        assertArrayEquals(tree.getRoot().keys, node29);

        tree.removeFromNode(1, tree.getRoot());
        tree.removeFromNode(2, tree.getRoot());
        tree.removeFromNode(55, tree.getRoot());
        int[] node30 = {8, 65, 103, 0, 0};
        int[] node31 = {5, 6, 0, 0, 0};
        int[] node32 = {16, 17, 33, 34, 0};
        assertArrayEquals(tree.getRoot().keys, node30);
        assertArrayEquals(tree.getRoot().children[0].keys, node31);
        assertArrayEquals(tree.getRoot().children[1].keys, node32);

        tree.removeFromNode(16, tree.getRoot());
        tree.removeFromNode(34, tree.getRoot());
        tree.removeFromNode(1003, tree.getRoot());
        int[] node33 = {8, 65, 0, 0, 0};
        int[] node34 = {17, 33, 0, 0, 0};
        int[] node35 = {67, 98, 103, 1001, 0};
        assertArrayEquals(tree.getRoot().keys, node33);
        assertArrayEquals(tree.getRoot().children[1].keys, node34);
        assertArrayEquals(tree.getRoot().children[2].keys, node35);

        tree.removeFromNode(103, tree.getRoot());
        tree.removeFromNode(1001, tree.getRoot());
        tree.removeFromNode(17, tree.getRoot());
        int[] node36 = {65, 0, 0, 0, 0};
        int[] node37 = {5, 6, 8, 33, 0};
        int[] node38 = {67, 98, 0, 0, 0};
        assertArrayEquals(tree.getRoot().keys, node36);
        assertArrayEquals(tree.getRoot().children[0].keys, node37);
        assertArrayEquals(tree.getRoot().children[1].keys, node38);

        tree.removeFromNode(98, tree.getRoot());
        tree.removeFromNode(67, tree.getRoot());
        int[] node39 = {8, 0, 0, 0, 0};
        int[] node40 = {5, 6, 0, 0, 0};
        int[] node41 = {33, 65, 0, 0, 0};
        assertArrayEquals(tree.getRoot().keys, node39);
        assertArrayEquals(tree.getRoot().children[0].keys, node40);
        assertArrayEquals(tree.getRoot().children[1].keys, node41);

        tree.removeFromNode(5, tree.getRoot());
        int[] node42 = {6, 8, 33, 65, 0};
        assertArrayEquals(tree.getRoot().keys, node42);

        tree.removeFromNode(6, tree.getRoot());
        tree.removeFromNode(65, tree.getRoot());
        tree.removeFromNode(8, tree.getRoot());
        tree.removeFromNode(33, tree.getRoot());
        int[] node43 = {0, 0, 0, 0, 0};
        assertArrayEquals(tree.getRoot().keys, node43);
    }

    @Test
    public void testRemove4() {
        Tree tree = new Tree(7);
        int[] array = {7, 2, 1, 4, 3, 8, 10, 25, 15, 13, 77, 34, 29, 9, 11, 50, 66, 49, 14, 87, 90, 99, 73, 72, 70,
                21, 18, 100, 220, 222, 110, 125, 113, 177, 250, 277, 107, 102, 104, 299, 266, 234, 381, 450, 311, 308, 309,
                404, 403, 402, 400, 333, 590, 509, 524, 612, 655, 800, 710, 704, 766, 629, 649, 699, 907, 929, 999, 1111,
                16, 718, 898};
        for (int number : array) {
            tree.insert(number);
        }
        Tree.Node root = tree.getRoot();
        int[] node0 = {102, 177, 250, 0, 0, 0, 0};
        int[] node1 = {87, 90, 99, 0, 0, 0, 0};
        int[] node2 = {104, 107, 110, 113, 125, 0, 0};
        tree.removeFromNode(100, tree.getRoot());
        assertArrayEquals(root.children[1].keys, node0);
        assertArrayEquals(root.children[1].children[0].keys, node1);
        assertArrayEquals(root.children[1].children[1].keys, node2);

        tree.removeFromNode(250, tree.getRoot());
        int[] node3 = {102, 125, 234, 0, 0, 0, 0};
        int[] node4 = {104, 107, 110, 113, 0, 0, 0};
        int[] node5 = {177, 220, 222, 0, 0, 0, 0};
        assertArrayEquals(root.children[1].keys, node3);
        assertArrayEquals(root.children[1].children[1].keys, node4);
        assertArrayEquals(root.children[1].children[2].keys, node5);

        tree.removeFromNode(125, tree.getRoot());
        int[] node6 = {87, 90, 99, 0, 0, 0, 0};
        int[] node7 = {102, 113, 234, 0, 0, 0, 0};
        int[] node8 = {104, 107, 110, 0, 0, 0, 0};
        int[] node9 = {177, 220, 222, 0, 0, 0, 0};
        assertArrayEquals(root.children[1].keys, node7);
        assertArrayEquals(root.children[1].children[0].keys, node6);
        assertArrayEquals(root.children[1].children[1].keys, node8);
        assertArrayEquals(root.children[1].children[2].keys, node9);

        tree.removeFromNode(113, tree.getRoot());
        int[] node10 = {34, 308, 0, 0, 0, 0, 0};
        int[] node11 = {4, 13, 18, 0, 0, 0, 0};
        int[] node12 = {77, 110, 234, 0, 0, 0, 0};
        assertArrayEquals(root.keys, node10);
        assertArrayEquals(root.children[0].keys, node11);
        assertArrayEquals(root.children[1].keys, node12);

        tree.insert(2222);
        tree.removeFromNode(402, tree.getRoot());
        int[] node13 = {400, 509, 655, 766, 929, 0, 0};
        int[] node14 = {309, 311, 333, 381, 0, 0, 0};
        assertArrayEquals(root.children[2].keys, node13);
        assertArrayEquals(root.children[2].children[0].keys, node14);

        tree.removeFromNode(929, tree.getRoot());
        int[] node15 = {400, 509, 655, 718, 907, 0, 0};
        int[] node16 = {699, 704, 710, 0, 0, 0, 0};
        int[] node17 = {766, 800, 898, 0, 0, 0, 0};
        assertArrayEquals(root.children[2].keys, node15);
        assertArrayEquals(root.children[2].children[3].keys, node16);
        assertArrayEquals(root.children[2].children[4].keys, node17);

        tree.removeFromNode(655, tree.getRoot());
        int[] node18 = {400, 509, 649, 718, 907, 0, 0};
        int[] node19 = {524, 590, 612, 629, 0, 0, 0};
        assertArrayEquals(root.children[2].keys, node18);
        assertArrayEquals(root.children[2].children[2].keys, node19);

        tree.removeFromNode(509, tree.getRoot());
        int[] node20 = {381, 450, 649, 718, 907, 0, 0};
        int[] node21 = {309, 311, 333, 0, 0, 0, 0};
        int[] node22 = {400, 403, 404, 0, 0, 0, 0};
        assertArrayEquals(root.children[2].keys, node20);
        assertArrayEquals(root.children[2].children[0].keys, node21);
        assertArrayEquals(root.children[2].children[1].keys, node22);

        tree.removeFromNode(718, tree.getRoot());
        int[] node23 = {381, 450, 629, 710, 907, 0, 0};
        int[] node24 = {524, 590, 612, 0, 0, 0, 0};
        int[] node25 = {649, 699, 704, 0, 0, 0, 0};
        assertArrayEquals(root.children[2].keys, node23);
        assertArrayEquals(root.children[2].children[2].keys, node24);
        assertArrayEquals(root.children[2].children[3].keys, node25);

        tree.removeFromNode(629, tree.getRoot());
        int[] node26 = {381, 612, 710, 907, 0, 0, 0};
        int[] node27 = {309, 311, 333, 0, 0, 0, 0};
        int[] node28 = {400, 403, 404, 450, 524, 590, 0};
        assertArrayEquals(root.children[2].keys, node26);
        assertArrayEquals(root.children[2].children[0].keys, node27);
        assertArrayEquals(root.children[2].children[1].keys, node28);

        tree.removeFromNode(102, tree.getRoot());
        tree.removeFromNode(107, tree.getRoot());
        tree.removeFromNode(87, tree.getRoot());
        tree.removeFromNode(99, tree.getRoot());
        tree.removeFromNode(73, tree.getRoot());
        tree.removeFromNode(49, tree.getRoot());
        tree.removeFromNode(70, tree.getRoot());
        tree.removeFromNode(110, tree.getRoot());
        tree.removeFromNode(90, tree.getRoot());
        tree.removeFromNode(77, tree.getRoot());
        tree.removeFromNode(234, tree.getRoot());
        int[] node29 = {381, 0, 0, 0, 0, 0, 0};
        int[] node30 = {4, 13, 18, 34, 222, 308, 0};
        int[] node31 = {612, 710, 907, 0, 0, 0, 0};
        assertArrayEquals(root.keys, node29);
        assertArrayEquals(root.children[0].keys, node30);
        assertArrayEquals(root.children[1].keys, node31);

        tree.removeFromNode(13, tree.getRoot());
        tree.removeFromNode(222, tree.getRoot());
        tree.removeFromNode(308, tree.getRoot());
        tree.removeFromNode(11, tree.getRoot());
        tree.removeFromNode(18, tree.getRoot());
        tree.removeFromNode(4, tree.getRoot());
        tree.removeFromNode(299, tree.getRoot());
        int[] node32 = {7, 16, 34, 104, 277, 0, 0};
        int[] node33 = {612, 710, 907, 0, 0, 0, 0};
        assertArrayEquals(root.children[0].keys, node32);
        assertArrayEquals(root.children[1].keys, node33);

        tree.removeFromNode(381, tree.getRoot());
        int[] node34 = {333, 0, 0, 0, 0, 0, 0};
        int[] node35 = {7, 16, 34, 104, 0, 0, 0};
        int[] node36 = {177, 220, 266, 277, 309, 311, 0};
        assertArrayEquals(root.keys, node34);
        assertArrayEquals(root.children[0].keys, node35);
        assertArrayEquals(root.children[0].children[4].keys, node36);

        tree.removeFromNode(333, tree.getRoot());
        tree.removeFromNode(311, tree.getRoot());
        tree.removeFromNode(309, tree.getRoot());
        tree.removeFromNode(277, tree.getRoot());
        tree.removeFromNode(266, tree.getRoot());
        tree.removeFromNode(220, tree.getRoot());
        tree.removeFromNode(177, tree.getRoot());
        tree.removeFromNode(104, tree.getRoot());
        int[] node37 = {7, 16, 72, 612, 710, 907, 0};
        int[] node38 = {1, 2, 3, 0, 0, 0, 0};
        int[] node39 = {8, 9, 10, 14, 15, 0, 0};
        int[] node40 = {21, 25, 29, 34, 50, 66, 0};
        int[] node41 = {400, 403, 404, 450, 524, 590, 0};
        int[] node42 = {649, 699, 704, 0, 0, 0, 0};
        int[] node43 = {766, 800, 898, 0, 0, 0, 0};
        int[] node44 = {999, 1111, 2222, 0, 0, 0, 0};
        assertArrayEquals(tree.getRoot().keys, node37);
        assertArrayEquals(tree.getRoot().children[0].keys, node38);
        assertArrayEquals(tree.getRoot().children[1].keys, node39);
        assertArrayEquals(tree.getRoot().children[2].keys, node40);
        assertArrayEquals(tree.getRoot().children[3].keys, node41);
        assertArrayEquals(tree.getRoot().children[4].keys, node42);
        assertArrayEquals(tree.getRoot().children[5].keys, node43);
        assertArrayEquals(tree.getRoot().children[6].keys, node44);
    }

    @Test
    public void iterator1() {
        Tree tree = new Tree(5);
        int[] iteratorArray = new int[17];
        int[] array = {4, 11, 10, 2, 5, 6, 3, 98, 55, 34, 7, 1, 8, 9, 0, 42, 88};
        for (int number : array) {
            tree.insert(number);
        }
        Iterator iterator = tree.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            Integer a = (Integer) iterator.next();
            iteratorArray[index] = a;
            index++;
        }
        Arrays.sort(array);
        assertArrayEquals(iteratorArray, array);
    }

    @Test
    public void iterator2() {
        Tree tree = new Tree(7);
        int[] iteratorArray = new int[71];
        int[] array = {7, 2, 1, 4, 3, 8, 10, 25, 15, 13, 77, 34, 29, 9, 11, 50, 66, 49, 14, 87, 90, 99, 73, 72, 70,
                21, 18, 100, 220, 222, 110, 125, 113, 177, 250, 277, 107, 102, 104, 299, 266, 234, 381, 450, 311, 308, 309,
                404, 403, 402, 400, 333, 590, 509, 524, 612, 655, 800, 710, 704, 766, 629, 649, 699, 907, 929, 999, 1111,
                16, 718, 898};
        for (int number : array) {
            tree.insert(number);
        }
        Iterator iterator = tree.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            Integer a = (Integer) iterator.next();
            iteratorArray[index] = a;
            index++;
        }
        Arrays.sort(array);
        assertArrayEquals(iteratorArray, array);
    }
}
