import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(5);
        int[] array = {4, 11, 10, 2, 5, 6, 3, 98, 55, 34, 7, 1, 8, 9, 0, 42, 88};
        for (int number : array) {
            tree.insert(number);
        }
        Iterator iterator = tree.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        tree.remove(88);
        tree.remove(88);
        tree.search(88);
        tree.search(98);
    }
}
