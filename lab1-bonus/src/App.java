import java.util.PriorityQueue;
import java.util.Queue;

public class App {
    private static boolean suntAdiacente(String str1, String str2) {
        int[] flags = new int[256];
        for (int i = 0; i < str1.length(); ++i) {
            flags[str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length(); ++i) {
            if (flags[str2.charAt(i)] != 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean esteNumeric(String str) {
        for (int i = 0; i < str.length(); ++i) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }

    private static int numarAdiacente(boolean[][] adiacente, int idx, int n) {
        int counter = 0;
        for (int i = 0; i < n; ++i) {
            counter += (adiacente[idx][i] ? 1 : 0);
        }
        return counter;
    }

    private static int numarMaximAdiacente(String[] cuvinte, boolean[][] adiacente, int n) {
        int maxCounter = 0;
        for (int i = 0; i < n; ++i) {
            int counter = numarAdiacente(adiacente, i, n);
            maxCounter = Math.max(maxCounter, counter);
        }
        return maxCounter;
    }

    private static int numarMinimAdiacente(String[] cuvinte, boolean[][] adiacente, int n) {
        int minCounter = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            int counter = numarAdiacente(adiacente, i, n);
            minCounter = Math.min(minCounter, counter);
        }
        return minCounter;
    }

    private static void afiseazaCeleMaiAdiacente(String[] cuvinte, boolean[][] adiacente, int n) {
        System.out.print("Cuvintele adiacente maxim: ");
        int maxCounter = numarMaximAdiacente(cuvinte, adiacente, n);
        for (int i = 0; i < n; ++i) {
            if (maxCounter == numarAdiacente(adiacente, i, n)) {
                System.out.print(cuvinte[i] + " ");
            }
        }
        System.out.println();
    }

    private static void afiseazaCeleMaiPutinAdiacente(String[] cuvinte, boolean[][] adiacente, int n) {
        System.out.print("Cuvintele adiacente minim: ");
        int minCounter = numarMinimAdiacente(cuvinte, adiacente, n);
        for (int i = 0; i < n; ++i) {
            if (minCounter == numarAdiacente(adiacente, i, n)) {
                System.out.print(cuvinte[i] + " ");
            }
        }
        System.out.println();
    }

    private static boolean acelasiNumarDeAdiacente(String[] cuvinte, boolean[][] adiacente, int n) {
        return numarMinimAdiacente(cuvinte, adiacente, n) == numarMaximAdiacente(cuvinte, adiacente, n);
    }

    private static void BFS(boolean[][] adiacente, int n, int start, boolean[] visited) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(start);
        visited[start] = true;
        System.out.print(start + " ");
        while (!queue.isEmpty()) {
            int node = queue.remove();
            visited[node] = true;
            for (int i = 0; i < n; ++i) {
                if (adiacente[node][i] && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    System.out.print(i + " ");
                }
            }
        }
        System.out.println();
    }

    private static boolean esteConex(boolean[][] adiacente, int n) {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            visited[i] = false;
        }
        BFS(adiacente, n, 0, visited);
        boolean flag = true;
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                flag = false;
                break;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                BFS(adiacente, n, i, visited);
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        // Compulsatory part -------------------------------------------------------------------------------
//        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "Java", "PHP", "Swift", "Java"};
//        int n = (int) (Math.random() * 1_000_000);
//
//        n *= 3;
//        n += 0b10101;
//        n += 0xFF;
//        n *= 6;
//
//        // calculez cifra de control
//        int result = (n % 9 == 0 ? 9 : n % 9);
//        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);


        // Optional part ---------------------------------------------------------------------------------------
        long startTime = System.currentTimeMillis();

        if (args.length < 3) {
            System.out.println("Argumente insuficiente!");
            System.exit(-1);
        }

        if (!esteNumeric(args[0])) {
            System.out.println("n este invalid!");
            System.exit(-1);
        }

        if (!esteNumeric(args[1])) {
            System.out.println("k este invalid!");
            System.exit(-1);
        }

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt((args[1]));

        for (int i = 2; i < args.length; ++i) {
            if (args[i].length() > 1 || !Character.isLetter(args[i].charAt(0))) {
                System.out.println("Argumentele aplicatiei nu sunt litere");
                System.exit(-1);
            }
        }

        char[] litere = new char[args.length - 2];
        int m = 0;
        for (int i = 2; i < args.length; ++i) {
            litere[m++] = args[i].charAt(0);
        }

        String[] cuvinte = new String[n];
        for (int i = 0; i < n; ++i) {
            java.lang.StringBuilder cuvant = new StringBuilder();
            for (int j = 0; j < k; ++j) {
                int idx = (int) (Math.random() * m);
                cuvant.append(litere[idx]);
            }
            cuvinte[i] = cuvant.toString();
        }

        if (n < 30_000) {
            for (String cuvant : cuvinte) {
                System.out.print(cuvant + " ");
            }
            System.out.println();
        }

        boolean[][] adiacente = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) adiacente[i][j] = false;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (suntAdiacente(cuvinte[i], cuvinte[j])) {
                    adiacente[i][j] = adiacente[j][i] = true;
                }
            }
        }

        if (n < 30_000) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    System.out.print(adiacente[i][j] + " ");
                }
                System.out.println();
            }
        }

        afiseazaCeleMaiAdiacente(cuvinte, adiacente, n);
        afiseazaCeleMaiPutinAdiacente(cuvinte, adiacente, n);
        System.out.println(acelasiNumarDeAdiacente(cuvinte, adiacente, n) ? "ACELASI NUMAR DE ADIACENTE!" : "NU AVEM ACELASI NUMAR DE ADIACENTE!");

        long endTime = System.currentTimeMillis();
        System.out.println(esteConex(adiacente, n) ? "\nGraful este conex!" : "Graful NU este conex!");
        if (n >= 30000) {
            System.out.println("Timpul rularii aplicatiei este: " + (endTime - startTime) * 1_000_000L + " nanosecunde!");
        }
    }
}
