
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
        int[] keys = new int[2 * T - 1];
        Node[] children = new Node[2 * T];
        int n;
    }

    public void insert(int k) {
        Node r = root;
        if ((r.n == 2 * T - 1)) {
            Node s = new Node();
            root = s;
            s.isLeaf = false;
            s.n = 0;
            s.children[0] = r;
            split(s, 0, r);
            insertValue(s, k);
        } else {
            insertValue(r, k);
        }
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
            while ((i >= 1) && (k < x.keys[i - 1])) {
                i--;
            }
            if (x.children[i].n == 2 * T - 1) {
                split(x, i, x.children[i]);
                if (k > x.keys[i]) {
                    i++;
                }
            }
            insertValue(x.children[i], k);
        }
    }

    private void split(Node x, int i, Node y) {
        Node z = new Node();
        z.isLeaf = y.isLeaf;
        z.n = T - 1;
        for (int j = 0; j <= T - 2; j++) {
            z.keys[j] = y.keys[j + T];
            y.keys[j + T] = 0;
        }
        if (!y.isLeaf) {
            for (int j = 0; j <= T - 1; j++) {
                z.children[j] = y.children[j + T];
            }
        }
        y.n = T - 1;
        for (int j = x.n; j >= i + 1; j--) {
            x.children[j + 1] = x.children[j];
        }
        x.children[i + 1] = z;
        for (int j = x.n - 1; j > i - 1; j--) {
            x.keys[j + 1] = x.keys[j];
        }
        x.keys[i] = y.keys[T - 1];
        y.keys[T - 1] = 0;
        x.n = x.n + 1;
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
}
