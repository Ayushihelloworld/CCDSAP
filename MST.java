package com.company;

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
        int N = reader.nextInt();
        int M = reader.nextInt();
       HashSet<Node> set = new HashSet<>();
       PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
           @Override
           public int compare(Node o1, Node o2) {
               return o1.value - o2.value;
           }
       });
        Node[] array = new Node[N + 1];
        for (int i = 0; i < N + 1; i++){array[i] = new Node(i);}
        for (int i = 0; i < M; i++){
            int u = reader.nextInt(); int v = reader.nextInt(); int w = reader.nextInt();
            array[u].list.add(new int[]{v, w});
            array[v].list.add(new int[]{u, w});
        }
        array[1].value = 0;
        pq.add(array[1]);
        int ans = 0;
        int[] p = new int[N + 1];
        //set.add(array[1]);
        while (!pq.isEmpty()){
            Node u = pq.poll();
            int [] min_edge = new int[2];
            int edge = Integer.MAX_VALUE;
            set.add(u);
            //System.out.println(u.name);
            if (!u.visited) {
                for (int[] k : u.list) {

                    if (!set.contains(array[k[0]]) && k[0] != u.name) {
                 //       System.out.println(u.name + " " + k[0]);
                        if (u.value + k[1] <= array[k[0]].value) {
                            array[k[0]].value = u.value + k[1];
                            p[k[0]] = u.name;
                        }
                        if (array[k[0]].value < edge) {
                            edge = array[k[0]].value;
                            min_edge = new int[]{k[0], k[1]};
                        }
                        pq.add(array[k[0]]);
                     //   array[k[0]].visited = true;
                    }
                }
                if (edge != Integer.MAX_VALUE) ans += min_edge[1];
            }
            u.visited = true;
        }
//        for (int i = 0; i < N+ 1; i++){
//            System.out.println(array[i].name + " " + array[i].value);
//        }
//        for (int i = 0; i < N + 1; i++){
//            System.out.println(array[i].name + " " +  p[i]);
//        }
        ans = 0;
        for (int i = 1; i < N + 1; i++){
            for (int[] k: array[i].list){
                if (k[0] == p[i]){
                    ans += k[1];
                }
            }

        }
        System.out.println(ans);
    }

        // }
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
