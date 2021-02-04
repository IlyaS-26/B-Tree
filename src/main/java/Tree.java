
public class Tree {
    private final int T;
    private Node root;

    public Tree(int t) {
        T = t;
        this.root = new Node();
        root.n = 0;
        root.isLeaf = true;
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
        Node r = root;
        insertValue(r, k);
    }

    private void insertValue(Node x, int k) { // x - нод, k - новый ключ
        int i = x.n; //i = кол-во нодов в x
        if (x.isLeaf) {
            while ((i >= 1) && (k < x.keys[i - 1])) {
                x.keys[i] = x.keys[i - 1];
                i--;
            }
            x.keys[i] = k;
            x.n++;
        } else { //если не лист
            while ((i >= 1) && (k < x.keys[i - 1])) {
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
        if (T % 2 == 0) {
            z.n = T / 2 - 1;
        } else {
            z.n = T / 2;
        }
        for (int j = 0; j < z.n; j++) {
            z.keys[j] = y.keys[j + z.n + 1];
            y.keys[j + z.n + 1] = 0;
            removed++;
        }
        y.n = T - removed; //обновление колличества ключей в y
        for (int j = x.n; j >= i + 1; j--) {
            x.children[j + 1] = x.children[j];
        }
        x.children[i + 1] = z;
        for (int j = x.n - 1; j >= i; j--) {
            x.keys[j + 1] = x.keys[j];
        } //Медиана в x
        if (T % 2 == 0) {
            x.keys[i] = y.keys[T / 2 + 1];
            y.keys[T / 2 + 1] = 0;
        } else {
            x.keys[i] = y.keys[T / 2];
            y.keys[T / 2] = 0;
        }
        y.n--;
        x.n = x.n + 1;
        if (!y.isLeaf) {
            for (int j = T / 2 + 1; j <= T; j++) {
                z.children[-(T / 2 + 1) + j] = y.children[j];
                y.children[j] = null;
            }
        }
    }

    public void Show() {
        Show(root);
    }

    private void Show(Node x) {
        assert (x == null);
        for (int i = 0; i < x.n; i++) {
            System.out.print(x.keys[i] + " ");
        }
        System.out.print(" ");
        if (!x.isLeaf) {
            for (int i = 0; i < x.n + 1; i++) {
                Show(x.children[i]);
            }
        }
    }

    private int findKey(int value, Node node) {
        int ans = 0;
        while (ans < node.n && node.keys[ans] < value) {
            ans = ans + 1;
        }
        return ans;
    }

    public boolean removeFromTree(int value, Tree tree) {
        if (tree.root.n == 0) {
            System.out.println("Tree doesn't exist");
            return false;
        }
        removeFromNode(value, tree.root);
        if (tree.root.n == 0) {
            Node tmp = tree.root;
            if (tree.root.isLeaf) {
                tree.root = null;
            } else {
                tree.root = tree.root.children[0];
            }
        }
        return false;
    }

    private void removeFromNode(int value, Node node) {
        int i = findKey(value, node);
        if (i < node.n && node.keys[i] == value) {
            if (node.isLeaf) {
                removeFromLeaf(i, node);
            } else {
                removeFromNode(i, node);
            }
        } else {
            if (node.isLeaf) {
                System.out.println("the key is missing in the tree");
                return;
            }
            int flag;
            if (i == node.n) {
                flag = 1;
            } else {
                flag = 0;
            }
            if (node.children[i].n < T) {
                fill(i, node);
            }
            if (flag > node.n && i > node.n) {
                removeFromNode(value, node.children[i - 1]);
            } else {
                removeFromNode(value, node.children[i]);
            }
        }
    }

    private void removeFromLeaf(int i, Node node) {
        for (int j = i + 1; j < node.n; j++) {
            node.keys[j - 1] = node.keys[j];
        }
        node.n = node.n - 1;
    }

    private boolean removeFromNonLeaf(int i, Node node) {
        int k = node.keys[i];
        if (node.children[i].n >= T) {
            int pred = getPred(i, node);
            removeFromNode(pred, node.children[i]);
        } else if (node.children[i + 1].n >= T) {
            int succ = getSucc(i, node);
            node.keys[i] = succ;
            removeFromNode(succ, node.children[i + 1]);
        } else {
            merge(i, node);
            removeFromNode(k, node.children[i]);
        }
        return false;
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
        if (i != 0 && node.children[i - 1].n >= T) {
            borrowFromPrev(i, node);
        } else if (i != node.n && node.children[i + 1].n >= T) {
            borrowFromNext(i, node);
        } else {
            if (i != node.n) {
                merge(i, node);
            } else {
                merge(i - 1, node);
            }
        }
    }

    private void borrowFromPrev(int i, Node node) {
        Node child = node.children[i];
        Node sibling = node.children[i - 1];
        for (i = child.n - 1; i >= 0; i--) {
            child.keys[i - 1] = child.keys[i];
        }
        if (!child.isLeaf) {
            for (i = child.n; i >= 0; i--) {
                child.children[i + 1] = child.children[i];
            }
        }
        child.keys[0] = node.keys[i - 1];
        if (!child.isLeaf) {
            child.children[0] = sibling.children[sibling.n];
        }
        node.keys[i - 1] = sibling.keys[sibling.n - 1];
        child.n = child.n + 1;
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
        for (int j = 1; j < sibling.n; j++) {
            sibling.keys[j - 1] = sibling.keys[j];
        }
        if (!sibling.isLeaf) {
            for (int j = 1; j <= sibling.n; j++) {
                sibling.children[j - 1] = sibling.children[j];
            }
        }
        child.n = child.n + 1;
        sibling.n = sibling.n - 1;
    }

    private void merge(int i, Node node) {
        Node child = node.children[i];
        Node sibling = node.children[i + 1];
        child.keys[T - 1] = node.keys[i];
        for (int j = 0; j < sibling.n; j++) {
            child.keys[j + T] = sibling.keys[j];
        }
        if (!child.isLeaf) {
            for (int j = 0; j <= sibling.n; j++) {
                child.children[j + T] = sibling.children[j];
            }
        }
        for (int j = i + 1; j < node.n; j++) {
            node.keys[j - 1] = node.keys[j];
        }
        child.n = child.n + sibling.n + 1;
        for (int j = i + 2; j <= node.n; j++) {
            node.children[j - 1] = node.children[j];
        }
        node.n = node.n - 1;
    }
}