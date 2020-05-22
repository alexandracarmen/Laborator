package com.company;
import java.util.*;

public class Main {
        public static void main(String args[]){

            int Maxim = 0;
            int Minim = Integer.MAX_VALUE;

            int n = Integer.parseInt(args[0]);
            int k = Integer.parseInt(args[1]);

            String[] words = new String[n];
            boolean[][] adjacency = new boolean[n][n];
            int[] nrVecini = new int[n];
            Arrays.fill(nrVecini, 0);

            for(int i = 0; i < n; i++){
                words[i] = randomw(args, k);
                System.out.println(words[i]);
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++) {
                    if (i != j)
                    {
                        if (Adiacent(words[i], words[j], k))
                        {
                            adjacency[i][j] = true;
                            nrVecini[i]++;
                        } else
                            {
                            adjacency[i][j] = false;
                        }
                    }
                    System.out.print(adjacency[i][j] ? "1 " : "0 ");
                }

                if(nrVecini[i] > Maxim){
                    Maxim = nrVecini[i];
                }


                if(nrVecini[i] < Minim){
                    Minim = nrVecini[i];
                }

                System.out.println();
            }

            System.out.println();
            System.out.print("Cei mai buni vecini: ");
            for(int i = 0; i < n; i++){
                if(checkLineSumOfArray(adjacency[i], n) == Maxim){
                    System.out.print(words[i] + "(" + Maxim + ") ");
                }
            }

            System.out.println();

            System.out.print("Cei mai  timizi: ");
            for(int i = 0; i < n; i++){
                if(checkLineSumOfArray(adjacency[i], n) == Minim){
                    System.out.print(words[i] + "(" + Minim + ") ");
                }
            }

            if(isConnected(n,adjacency))
                System.out.println("\nGraful este conex");
            else
                System.out.println("\nGraful nu este conex");


        }

        public static boolean Adiacent(String w1, String w2, int k){
            for(int i = 0; i < k; i++){
                if(w1.indexOf(w2.charAt(i)) > -1){
                    return true;
                }
            }
            return false;
        }

        public static String randomw(String args[], int k){
            String word = "";
            Random random = new Random();
            for(int i = 0; i < k; i++){
                word = word.concat(args[random.nextInt(args.length - 2) + 2]);
            }
            return word;
        }

        public static int checkLineSumOfArray(boolean adjacency[], int n){
            int sum = 0;
            for(int i = 0; i < n; i++){
                if(adjacency[i]){
                    sum++;
                }
            }

            return sum;
        }
    static public  void DFS(int u, boolean[] visited,int n,boolean[][] adj)
    {
        visited[u] = true;
        for(int v = 0; v<n; v++) {
            if(adj[u][v]) {
                if(!visited[v]) DFS(v, visited,n, adj);
            }
        }
    }

    static public boolean isConnected(int n,boolean[][] adj)
    {
        boolean[] vis ;
        vis=new boolean[n];
        for(int p=0; p <n; p++)
        {
            for(int i = 0; i<n; i++) vis[i] = false;
            DFS(p, vis,n,adj);

            for(int i = 0; i<n; i++)
            {
                if(!vis[i])
                    return false;
            }
        }

        return true;
    }


}

