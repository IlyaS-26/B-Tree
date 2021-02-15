
public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(5);
        int[] array = {4, 11, 10, 2, 5, 6, 3, 98, 55, 34, 7, 1, 8, 9, 0, 42, 88, 101, 102, 59, 103, 33, 56, 65,
                808, 666, 777, 66, 67, 12, 14, 16, 17, 19, 68, 909, 1001, 1002, 1003, 1004, 69, 15};
        for (int number : array) {
            tree.insert(number);
        }
        tree.removeFromNode(17, tree.getRoot());
        tree.Show();
    }
}
