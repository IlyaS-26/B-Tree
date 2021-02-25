import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Tree {
    private final int T;
    private Node root;
    private final int minimumT;

    public Tree(int t) {
        T = t;
        this.root = new Node();
        root.n = 0;
        root.isLeaf = true;
        if (T % 2 != 0) {
            minimumT = T / 2;
        } else {
            minimumT = (T / 2) - 1;
        }
    }

    public class Node {
        boolean isLeaf = true;
        int[] keys = new int[T];
        Node[] children = new Node[T + 1];
        int n;
    }

    public Node getRoot() {
        return root;
    }

    public void insert(int k) {
        insertValue(root, k);
    }

    private void insertValue(Node x, int k) {
        int i = x.n;
        if (x.isLeaf) {
            while ((i >= 1) && (k < x.keys[i - 1])) {
                x.keys[i] = x.keys[i - 1];
                i--;
            }
            x.keys[i] = k;
            x.n++;
        } else {
            while ((i >= 1) && (k <= x.keys[i - 1])) {
                i--;
            }
            insertValue(x.children[i], k);
            if (x.children[i].n == T) {
                split(x, i, x.children[i]);
            }
        }
        if (this.root.n == T) {
            Node r = root;
            Node s = new Node();
            root = s;
            s.isLeaf = false;
            s.n = 0;
            s.children[0] = r;
            split(s, 0, r);
        }
    }

    private void split(Node x, int i, Node y) {
        Node z = new Node();
        int removed = 0;
        z.isLeaf = y.isLeaf;
        z.n = T / 2;
        for (int j = 0; j < z.n; j++) {
            if (T % 2 != 0) {
                z.keys[j] = y.keys[j + z.n + 1];
                y.keys[j + z.n + 1] = 0;
            } else {
                z.keys[j] = y.keys[j + z.n];
                y.keys[j + z.n] = 0;
            }
            removed++;
        }
        y.n = T - removed;
        for (int j = x.n; j >= i + 1; j--) {
            x.children[j + 1] = x.children[j];
        }
        x.children[i + 1] = z;
        for (int j = x.n - 1; j >= i; j--) {
            x.keys[j + 1] = x.keys[j];
        }
        x.keys[i] = y.keys[minimumT];
        y.keys[minimumT] = 0;
        y.n--;
        x.n = x.n + 1;
        if (!y.isLeaf) {
            if (T % 2 != 0) {
                for (int j = T / 2 + 1; j <= T; j++) {
                    z.children[-(T / 2 + 1) + j] = y.children[j];
                    y.children[j] = null;
                }
            } else {
                for (int j = T / 2 + 1; j <= T + 1; j++) {
                    z.children[-(T / 2 + 1) + j] = y.children[j - 1];
                    y.children[j - 1] = null;
                }
            }
        }
    }

    private int findKey(int value, Node node) {
        int ans = 0;
        while (ans < node.n && node.keys[ans] < value) {
            ans = ans + 1;
        }
        if (node.isLeaf && node.keys[ans] != value) {
            return -1;
        }
        return ans;
    }

    public void remove(int value) {
        removeFromNode(value, root);
    }

    public void removeFromNode(int value, Node node) {
        int i = findKey(value, node);
        if (i == -1) {
            System.out.println("Число " + value + " отсутствует в дереве");
            return;
        }
        if (i < node.n && node.keys[i] == value) {
            if (node.isLeaf) {
                removeFromLeaf(i, node);
            } else {
                removeFromNonLeaf(i, node);
            }
        } else {
            if (i > node.n) {
                removeFromNode(value, node.children[i - 1]);
            } else {
                removeFromNode(value, node.children[i]);
            }
        }
        if (!node.isLeaf && node.children[i].n < minimumT) {
            fill(i, node);
            if (node.n == 0) root = node.children[0];
        }
    }

    private void removeFromLeaf(int i, Node node) {
        for (int j = i; j < node.keys.length - 1; j++) {
            node.keys[j] = node.keys[j + 1];
        }
        node.n = node.n - 1;
    }

    private void removeFromNonLeaf(int i, Node node) {
        int k = node.keys[i];
        if (node.children[i].n >= minimumT) {
            int pred = getPred(i, node);
            node.keys[i] = pred;
            removeFromNode(pred, node.children[i]);
        } else if (node.children[i + 1].n >= minimumT) {
            int succ = getSucc(i, node);
            node.keys[i] = succ;
            removeFromNode(succ, node.children[i + 1]);
        }
    }

    private int getPred(int i, Node node) {
        Node cur = node.children[i];
        while (!cur.isLeaf) {
            cur = cur.children[cur.n];
        }
        return cur.keys[cur.n - 1];
    }

    private int getSucc(int i, Node node) {
        Node cur = node.children[i + 1];
        while (!cur.isLeaf) {
            cur = cur.children[0];
        }
        return cur.keys[0];
    }

    private void fill(int i, Node node) {
        if (i != 0 && node.children[i - 1].n > minimumT) {
            borrowFromPrev(i, node);
        } else if (i != node.n && node.children[i + 1].n > minimumT) {
            borrowFromNext(i, node);
        } else {
            if (i == node.n || i >= 1) {
                merge(i - 1, node);
            } else {
                merge(i, node);
            }
        }
    }

    private void borrowFromPrev(int i, Node node) {
        Node child = node.children[i];
        Node sibling = node.children[i - 1];
        for (int j = child.n - 1; j >= 0; j--) {
            child.keys[j + 1] = child.keys[j];
        }
        if (!child.isLeaf) {
            for (int j = child.n; j >= 0; j--) {
                child.children[j + 1] = child.children[j];
            }
        }
        child.keys[0] = node.keys[i - 1];
        if (!child.isLeaf) {
            child.children[0] = sibling.children[sibling.n];
            sibling.children[sibling.n] = null;
        }
        node.keys[i - 1] = sibling.keys[sibling.n - 1];
        child.n = child.n + 1;
        sibling.keys[sibling.n - 1] = 0;
        sibling.n = sibling.n - 1;
    }

    private void borrowFromNext(int i, Node node) {
        Node child = node.children[i];
        Node sibling = node.children[i + 1];
        child.keys[child.n] = node.keys[i];
        if (!child.isLeaf) {
            child.children[child.n + 1] = sibling.children[0];
        }
        node.keys[i] = sibling.keys[0];
        for (int j = 1; j <= sibling.n; j++) {
            sibling.keys[j - 1] = sibling.keys[j];
        }
        if (!sibling.isLeaf) {
            for (int j = 1; j <= sibling.n + 1; j++) {
                sibling.children[j - 1] = sibling.children[j];
            }
        }
        child.n = child.n + 1;
        sibling.n = sibling.n - 1;
    }

    private void merge(int i, Node node) {
        Node child = node.children[i];
        Node sibling = node.children[i + 1];
        if (!child.isLeaf) {
            for (int j = 0; j <= sibling.n; j++) {
                child.children[j + child.n + 1] = sibling.children[j];
            }
        }
        if (child.n < minimumT) {
            child.keys[(minimumT) - 1] = node.keys[i];
            for (int j = 0; j <= sibling.n; j++) {
                child.keys[j + minimumT] = sibling.keys[j];
            }
        } else {
            child.keys[minimumT] = node.keys[i];
            for (int j = 1; j <= sibling.n; j++) {
                child.keys[j + minimumT] = sibling.keys[j - 1];
            }
        }
        for (int j = i + 1; j <= node.n; j++) {
            node.keys[j - 1] = node.keys[j];
        }
        child.n = child.n + sibling.n + 1;
        for (int j = i + 1; j <= node.n; j++) {
            node.children[j] = node.children[j + 1];
        }
        node.n = node.n - 1;
    }

    public void search(int value) {
        searchFormNode(root, value);
    }

    private boolean searchFormNode(Node node, int value) {
        int i = findKey(value, node);
        if (node.isLeaf && i == -1) {
            System.out.println("Значение " + value + " не было найдено");
            return false;
        }
        if ((i <= node.n - 1) && (value == node.keys[i])) {
            System.out.println("Значение " + value + " было найдено");
            return true;
        } else return searchFormNode(node.children[i], value);
    }

    public Iterator iterator() {
        return new BTreeIterator();
    }

    private class BTreeIterator implements Iterator {

        private final Stack<Node> nodeStack;
        private final Stack<Integer> indexStack;

        public BTreeIterator() {
            nodeStack = new Stack<>();
            indexStack = new Stack<>();
            if (root.n > 0) {
                pushLeftPath(root);
            }
        }

        @Override
        public boolean hasNext() {
            return !nodeStack.empty();
        }

        @Override
        public Object next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node node = nodeStack.peek();
            int index = indexStack.pop();
            Object result = node.keys[index];
            index++;
            if (index < node.n) {
                indexStack.push(index);
            } else {
                nodeStack.pop();
            }
            if (!node.isLeaf) {
                pushLeftPath(node.children[index]);
            }
            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void pushLeftPath(Node node) {
            while (true) {
                nodeStack.push(node);
                indexStack.push(0);
                if (node.isLeaf) {
                    break;
                }
                node = node.children[0];
            }
        }
    }
}