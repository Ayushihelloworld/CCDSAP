import java.io.*;
import java.util.*;
import java.util.StringTokenizer;


public class Main {
    static int MOD = 998244353;
    public static void main(String[] args) throws IOException {
//        InputReader sc = new InputReader(System.in);
//        PrintWriter out = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        FastReader reader = new FastReader();
        BufferedWriter output = new BufferedWriter(
                new OutputStreamWriter(System.out));
        int test = 1;

        for (int o = 1; o <= test; o++) {
            int n = 15;
            int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 ,15};
            TreeNode root = build(0, n - 1, arr);
            for (int i = 0; i < 100; i++){
                int l = reader.nextInt();int r = reader.nextInt();
                System.out.println(get(root, 0, n - 1, l - 1, r - 1));
                update(root, 0, n- 1, 10, 5);

            }
        }
    }
    public static TreeNode build( int l, int r, int[] arr){
        if (l == r){
          TreeNode node = new TreeNode(l, r, arr[l]);
          return node;
        }
        int mid = (l + r)/2;
        TreeNode n1 = build(l, mid, arr);
        TreeNode n2 =build(mid + 1, r, arr);
        TreeNode node = new TreeNode(l, r, 0);
        node.left = n1; node.right = n2;
        node.val = n1.val + n2.val;
        return node;
    }
    public static int get(TreeNode node, int ss, int se, int qs, int qe){
        if (node == null) return 0;
        if (qs <= ss && qe >= se)
            return node.val;
        if (se < qs || ss > qe)
            return 0;
        int mid = (ss + se)/2;
        return get(node.left, ss, mid, qs, qe) +
                get(node.right, mid + 1, se, qs, qe);
    }
    public static void update(TreeNode node, int ss, int se, int diff, int i){
        if (i < ss || i > se)
            return;
        node.val  += diff;
        if (se != ss){
            int mid = (se + ss)/2;
            update(node.left, ss, mid, diff, i);
            update(node.right, mid + 1, se, diff, i);
        }

    }
}
class TreeNode{
    TreeNode left; TreeNode right; int l; int r; int mid;  int val;
    public TreeNode(int left, int right, int val){
        this.l = left; this.r = right;
        this.mid= (l + r)/2;
        this.val = val;
    }

}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
