import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Tests {

    @Test
    public void testInsert1() {
        int[] nodeRoot = {8, 65, 103, 0, 0};
        int[] node0 = {2, 5, 0, 0, 0};
        int[] node1 = {11, 16, 33, 55, 0};
        int[] node2 = {68, 98, 0, 0, 0};
        int[] node3 = {808, 1002, 0, 0, 0};
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
        // 1 ветвь
        assertArrayEquals(root.children[1].keys, node1);
        // 2 ветвь
        assertArrayEquals(root.children[2].keys, node2);
        // 3 ветвь
        assertArrayEquals(root.children[3].keys, node3);
    }

    @Test
    public void testInsert2() {
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
        Tree.Node root = tree.getRoot();
        assertArrayEquals(root.keys, nodeRoot);
        // 0 ветвь
        assertArrayEquals(root.children[0].keys, node0);
        assertArrayEquals(root.children[0].children[0].keys, node2);

        assertArrayEquals(root.children[0].children[1].keys, node3);

        assertArrayEquals(root.children[0].children[2].keys, node4);
        // 1 ветвь
        assertArrayEquals(root.children[1].keys, node1);
        assertArrayEquals(root.children[1].children[0].keys, node5);

        assertArrayEquals(root.children[1].children[1].keys, node6);

        assertArrayEquals(root.children[1].children[2].keys, node7);
    }

    @Test
    public void testInsert3() {
        Tree tree = new Tree(3);
        int[] nodeRoot = {20, 0, 0};
        int[] node0 = {12, 0, 0};
        int[] node1 = {35, 0, 0};
        int[] node2 = {10, 0, 0};
        int[] node3 = {15, 0, 0};
        int[] node4 = {25, 0, 0};
        int[] node5 = {50, 80, 0};
        int [] array = {4, 11, 10, 12, 14, 15, 17, 20, 22, 25, 30, 35, 40, 50, 60, 80, 90, 100};
        for (int number : array) {
            tree.insert(number);
        }
        Tree.Node root = tree.getRoot();
        assertArrayEquals(root.keys, nodeRoot);
        //0 ветвь
        assertArrayEquals(root.children[0].keys, node0);
        assertArrayEquals(root.children[0].children[0].keys, node2);
        assertArrayEquals(root.children[0].children[1].keys, node3);
        //1 ветвь
        assertArrayEquals(root.children[1].keys, node1);
        assertArrayEquals(root.children[1].children[0].keys, node4);
        assertArrayEquals(root.children[1].children[1].keys, node5);
    }

    @Test
    public void testInsert4() {
        Tree tree = new Tree(6);
        int[] array = {4, 11, 10, 2, 5, 6, 3, 98, 55, 34, 7, 1, 8, 9, 0, 42, 88, 101, 102, 59, 103, 33, 56, 65,
                808, 666, 777, 66, 67, 12, 14, 16, 17, 19, 68, 909, 1001, 1002, 1003, 1004, 69};
        for (int number : array) {
            tree.insert(number);
        }
        Tree.Node root = tree.getRoot();
        int[] node1 = {55, 0, 0, 0, 0, 0};
        int[] node2 = {5, 11, 16, 0, 0, 0};
        int[] node3 = {65, 98, 103, 808, 0, 0};
        assertArrayEquals(root.keys, node1);
        assertArrayEquals(root.children[0].keys, node2);
        assertArrayEquals(root.children[1].keys, node3);
    }

    @Test
    public void testInsert5() {
        Tree tree = new Tree(6);
        int[] array = {4, 11, 10, 2, 5, 6, 3, 98, 55, 34, 7, 1, 8, 9, 0, 42, 88, 101, 102, 59, 103, 33, 56, 65, 808,
                666, 777, 66, 67, 12, 14, 16, 17, 19, 68, 909, 1001, 1002, 1003, 1004, 69, 1005, 1006, 1007, 1008,
                1009, 1010, 1011, 1012, 1013, 1014, 1015, 1016, 1017, 1018, 1019, 1020, 1021, 1022};
        for (int number : array) {
            tree.insert(number);
        }
        Tree.Node root = tree.getRoot();
        int[] node1 = {55, 103, 1005, 0, 0, 0};
        int[] node2 = {5, 11, 16, 0, 0, 0};
        int[] node3 = {65, 98, 0, 0, 0, 0};
        int[] node4 = {808, 1002, 0, 0, 0, 0};
        int[] node5 = {1008, 1011, 1014, 1017, 0, 0};
        assertArrayEquals(root.keys, node1);
        assertArrayEquals(root.children[0].keys, node2);
        assertArrayEquals(root.children[1].keys, node3);
        assertArrayEquals(root.children[2].keys, node4);
        assertArrayEquals(root.children[3].keys, node5);
    }

    @Test
    public void testRemove1() {
        Tree tree = new Tree(3);
        int[] nodeRoot = {9, 0, 0};
        int[] node0 = {6, 0, 0};
        int[] node1 = {13, 40, 0};
        int[] array = {2, 6, 8, 9, 13, 25, 30, 40, 50, 60, 31, 12};
        for (int number : array) {
            tree.insert(number);
        }
        tree.remove(31);
        tree.remove(30);
        tree.remove(60);
        Tree.Node root = tree.getRoot();
        assertArrayEquals(root.keys, nodeRoot);
        assertArrayEquals(root.children[0].keys, node0);
        assertArrayEquals(root.children[1].keys, node1);
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
        tree.remove(101);
        assertArrayEquals(root.children[1].keys, node1);
        assertArrayEquals(root.children[1].children[2].keys, node2);
        assertArrayEquals(root.children[1].children[3].keys, node3);
        tree.insert(89);
        tree.remove(72);
        tree.insert(57);
        tree.remove(69);
        tree.insert(901);
        tree.remove(98);
        tree.insert(104);
        tree.remove(777);
        tree.insert(69);
        tree.insert(93);
        tree.remove(73);
        int[] node4 = {65, 69, 88, 104, 0, 0, 0};
        int[] node5 = {66, 67, 68, 0, 0, 0, 0};
        int[] node6 = {70, 71, 74, 0, 0, 0, 0};
        int[] node7 = {89, 93, 102, 103, 0, 0, 0};
        assertArrayEquals(root.children[1].keys, node4);
        assertArrayEquals(root.children[1].children[1].keys, node5);
        assertArrayEquals(root.children[1].children[2].keys, node6);
        assertArrayEquals(root.children[1].children[3].keys, node7);
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
        tree.remove(59);
        assertArrayEquals(root.children[1].keys, node1);
        assertArrayEquals(root.children[1].children[2].keys, node2);
        assertArrayEquals(root.children[1].children[3].keys, node3);
        int[] removeArray = {42, 56, 10, 14, 12, 11, 9, 19, 7, 909, 666, 808, 101, 102, 69, 66, 88, 68, 1004, 1002,
                777, 3, 4, 0, 1, 2, 55, 16, 34, 1003, 103, 1001, 17, 98, 67};
        for (int number : removeArray) {
            tree.remove(number);
        }
        int[] node4 = {8, 0, 0, 0, 0};
        int[] node5 = {5, 6, 0, 0, 0};
        int[] node6 = {33, 65, 0, 0, 0};
        assertArrayEquals(tree.getRoot().keys, node4);
        assertArrayEquals(tree.getRoot().children[0].keys, node5);
        assertArrayEquals(tree.getRoot().children[1].keys, node6);
        tree.remove(5);
        tree.remove(6);
        tree.remove(65);
        tree.remove(8);
        tree.remove(33);
        int[] node7 = {0, 0, 0, 0, 0};
        assertArrayEquals(tree.getRoot().keys, node7);
    }

    @Test
    public void testRemove4() {
        Tree tree = new Tree(7);
        int[] array = {7, 2, 1, 4, 3, 8, 10, 25, 15, 13, 77, 34, 29, 9, 11, 50, 66, 49, 14, 87, 90, 99, 73, 72, 70,
                21, 18, 100, 220, 222, 110, 125, 113, 177, 250, 277, 107, 102, 104, 299, 266, 234, 381, 450, 311, 308,
                309, 404, 403, 402, 400, 333, 590, 509, 524, 612, 655, 800, 710, 704, 766, 629, 649, 699, 907, 929, 999,
                1111, 16, 718, 898};
        for (int number : array) {
            tree.insert(number);
        }
        Tree.Node root = tree.getRoot();
        int[] node0 = {102, 177, 250, 0, 0, 0, 0};
        int[] node1 = {87, 90, 99, 0, 0, 0, 0};
        int[] node2 = {104, 107, 110, 113, 125, 0, 0};
        tree.remove(100);
        assertArrayEquals(root.children[1].keys, node0);
        assertArrayEquals(root.children[1].children[0].keys, node1);
        assertArrayEquals(root.children[1].children[1].keys, node2);
        int[] arrayRemove = {250, 125, 113, 2222, 402, 929, 655, 509, 718, 629, 102, 107, 87, 99, 73, 49, 70, 110, 90,
                77, 234, 13, 222, 308, 11, 18, 4, 299, 381, 333, 311, 309, 277, 266, 220, 177, 104};
        for (int number : arrayRemove) {
            if (number == 2222) {
                tree.insert(number);
            } else {
                tree.remove(number);
            }
        }
        int[] node3 = {7, 16, 72, 612, 710, 907, 0};
        int[] node4 = {1, 2, 3, 0, 0, 0, 0};
        int[] node5 = {8, 9, 10, 14, 15, 0, 0};
        int[] node6 = {21, 25, 29, 34, 50, 66, 0};
        int[] node7 = {400, 403, 404, 450, 524, 590, 0};
        int[] node8 = {649, 699, 704, 0, 0, 0, 0};
        int[] node9 = {766, 800, 898, 0, 0, 0, 0};
        int[] node10 = {999, 1111, 2222, 0, 0, 0, 0};
        assertArrayEquals(tree.getRoot().keys, node3);
        assertArrayEquals(tree.getRoot().children[0].keys, node4);
        assertArrayEquals(tree.getRoot().children[1].keys, node5);
        assertArrayEquals(tree.getRoot().children[2].keys, node6);
        assertArrayEquals(tree.getRoot().children[3].keys, node7);
        assertArrayEquals(tree.getRoot().children[4].keys, node8);
        assertArrayEquals(tree.getRoot().children[5].keys, node9);
        assertArrayEquals(tree.getRoot().children[6].keys, node10);
    }

    @Test
    public void testRemove5() {
        Tree tree = new Tree(6);
        int[] array = {4, 11, 10, 2, 5, 6, 3, 98, 55, 34, 7, 1, 8, 9, 0, 42, 88, 101, 102, 59, 103, 33, 56, 65, 808,
                666, 777, 66, 67, 12, 14, 16, 17, 19, 68, 909, 1001, 1002, 1003, 1004, 69, 1005, 1006, 1007, 1008,
                1009, 1010, 1011, 1012, 1013, 1014, 1015, 1016, 1017, 1018, 1019, 1020, 1021, 1022};
        for (int number : array) {
            tree.insert(number);
        }
        int[] numbersToRemove1 = {1009, 1014, 1010, 59, 65, 102, 69, 1005, 103, 1013, 55, 1004, 1017, 1003, 1008, 808,
                1011, 1016, 1018, 1019, 1020, 1015, 1012, 1001, 1021, 16, 14, 12, 11, 42, 34, 33, 19, 17, 909, 1002,
                68, 67, 66};
        int[] nodeRoot1 = {56, 0, 0, 0, 0, 0};
        int[] nodeChild0 = {5, 8, 0, 0, 0, 0};
        int[] nodeChild1 = {101, 1006, 0, 0, 0, 0};
        for (int number : numbersToRemove1) {
            tree.removeFromNode(number, tree.getRoot());
        }
        assertArrayEquals(tree.getRoot().keys, nodeRoot1);
        assertArrayEquals(tree.getRoot().children[0].keys, nodeChild0);
        assertArrayEquals(tree.getRoot().children[1].keys, nodeChild1);
        int[] numbersToRemove2 = {5, 4, 8, 56, 3, 9, 101, 7, 88, 777, 1007, 2, 98, 666, 1022, 0, 1, 1006, 10, 6};
        for (int number : numbersToRemove2) {
            tree.removeFromNode(number, tree.getRoot());
        }
        int[] nodeRoot2 = {0, 0, 0, 0, 0, 0};
        assertArrayEquals(tree.getRoot().keys, nodeRoot2);
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
