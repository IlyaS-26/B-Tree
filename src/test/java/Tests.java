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
        tree.insert(12);
        tree.insert(14);
        tree.insert(16);
        tree.insert(17);
        tree.insert(19);
        tree.insert(68);
        tree.insert(909);
        tree.insert(1001);
        tree.insert(1002);
        tree.insert(1003);
        tree.insert(1004);
        tree.insert(69);
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
}
