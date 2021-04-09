//Avoid division by decimal digits :). Always try to multiply with whole numbers or fractions instead.
//if getting wrong answer then use long/double instead of int/float
//e + e = o; o + o = e; e + o = o;
//see stuff in a jugaad way... if you are being complicated you are doing it wrong baby girl :)
//If a=b+1 and b is even, then a∧b=1
//Be confident in Maths you are not that bad at it.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        FastReader reader = new FastReader();
        int test = reader.nextInt();
        for (int o = 0; o < test; o++) {
         //   reader.next();
            HashSet<int[]> set = new HashSet<>();
            int N = reader.nextInt();
           // System.out.println(N);
            int[] parent = new int[N + 1];
            int[] size = new int[N + 1];
            for (int i = 1; i < N + 1; i++) {
                size[i] = 1;
                parent[i] = i;
            }

            ArrayList<int[]> list = new ArrayList<>();
            int[][] grid = new int[N + 1][2];
            for (int i = 1; i <= N - 1; i++) {
                int a1 = reader.nextInt();
                int a2 = reader.nextInt();
                int[] arr = new int[]{a1, a2};
                set.add(arr);
                grid[i] = arr;
            }
            //System.out.println("oui");
            int Q = reader.nextInt();
            Stack<int[]> stack = new Stack<>();
            for (int i = 0; i < Q; i++) {

                String k = reader.next();
               // System.out.println(Q);
                if (k.equals("Q")) {
                    stack.add(new int[]{-1, -1});
                 //   System.out.println("ooh");
                } else {
                    int a = reader.nextInt();
                    int[] l = grid[a];
                    stack.add(l);
                    set.remove(l);
                }
            }
            for (int[] p : set) {
                union(parent, size, p[0], p[1]);
            }

            StringBuilder ans = new StringBuilder();
            while (!stack.isEmpty()) {
                int[] kk = stack.pop();
                if (kk[0] == -1 && kk[1] == -1) {
                    int pos = ans(parent, size);
                    ans.append(pos + "\n");
                } else {
                    union(parent, size, kk[0], kk[1]);
                 //   System.out.println(Arrays.toString(parent) + " " + Arrays.toString(size));
                }
            }
            System.out.println(ans.reverse().toString());
            //System.out.println("");
        }
    }
    public static int find(int[] arr, int i){
    if (arr[i] == i) return i;
    return find(arr, arr[i]);
    }
    public static void union(int[] parent, int[] size,  int a, int b){
        a = find(parent, a);
        b = find(parent, b);
        if (a != b) {
            if (size[a] < size[b]) {
                parent[b] = a;
                size[a] += size[b];
            }
            else {
                parent[b] = a;
                size[a] += size[b];
            }
        }
    }
    public static int ans(int[] parent, int[] size){
        int b = 1; int com= 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < parent.length; i++){
                if (parent[i] == i){com += 1; list.add(size[i]);}
        }
        ArrayList<Integer> summation = new ArrayList<>();
        summation.add(list.get(0));
        for (int i = 1; i < list.size(); i++){
            summation.add(summation.get( i- 1) + list.get(i));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        for (int i = 1; i < list.size(); i++){
            int k = summation.get(i - 1)*list.get(i) + ans.get(i - 1);
            ans.add(k);
        }
        return ans.get(ans.size() - 1);
    }
        //}
}
class Node{
    int name;
    int value;
    boolean visited = false;
    ArrayList<int[]> list = new ArrayList<>();
    public Node(int name){
        this.name = name;
        this.value= Integer.MAX_VALUE;
    }
}

class FastReader
{
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt()
    {
        return Integer.parseInt(next());
    }

    long nextLong()
    {
        return Long.parseLong(next());
    }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }
}

/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
