
public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(5);
        int[] array = {4, 11, 10, 2, 5, 6, 3, 98, 55, 34, 7, 1, 8, 9, 0, 42, 88, 101, 102, 59, 103, 33, 56, 65,
                808, 666, 777, 66, 67, 12, 14, 16, 17, 19, 68, 909, 1001, 1002, 1003, 1004, 69};
        for (int number : array) {
            tree.insert(number);
        }
        tree.removeFromNode(59, tree.getRoot());
        tree.removeFromNode(42, tree.getRoot());
        tree.removeFromNode(56, tree.getRoot());
        tree.removeFromNode(10, tree.getRoot());
        tree.removeFromNode(14, tree.getRoot());
        tree.removeFromNode(12, tree.getRoot());
        tree.removeFromNode(11, tree.getRoot());
        tree.removeFromNode(9, tree.getRoot());
        tree.removeFromNode(19, tree.getRoot());
        tree.removeFromNode(7, tree.getRoot());
        tree.removeFromNode(909, tree.getRoot());
        tree.removeFromNode(666, tree.getRoot());
        tree.removeFromNode(808, tree.getRoot());
        tree.removeFromNode(101, tree.getRoot());
        tree.removeFromNode(102, tree.getRoot());
        tree.removeFromNode(69, tree.getRoot());
        tree.removeFromNode(66, tree.getRoot());
        tree.removeFromNode(88, tree.getRoot());
        tree.removeFromNode(68, tree.getRoot());
        tree.removeFromNode(1004, tree.getRoot());
        tree.Show();
    }
}
