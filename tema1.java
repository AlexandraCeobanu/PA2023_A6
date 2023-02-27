//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Locale;

public class tema1 {
    static long timpStart=System.nanoTime();
    public static void main(String[] args) {
         int n;
        if (args.length > 0) {
            try {
                n = Integer.parseInt(args[0]);
                System.out.println(n);
                ConstruiesteMatrice(n);
            } catch (NumberFormatException var3) {
                System.err.println("Argumentul " + args[0] + " trebuie sa fie un int.");
                System.exit(1);
            }
        } else {
            System.out.println("Nu sunt destule argumente.");
            System.exit(2);
        }

    }
    public static void ConstruiesteMatrice(int n) {
        int[][] matrice = new int[n][n];
        int i;
        for(i = 0; i < n; ++i) {
            matrice[0][i] = i + 1;
        }
        int j;
        for(i = 1; i < n; ++i) {
            for(j = 0; j < n; ++j) {
                if (j == 0) {
                    matrice[i][j] = matrice[i - 1][n - 1];
                } else {
                    matrice[i][j] = matrice[i - 1][j - 1];
                }
            }
        }
        /*for(i = 0; i < n; ++i) {
            for(j = 0; j < n; ++j) {
                System.out.println(matrice[i][j] + " ");
            }
            System.out.println();*/
        String[] linii=new String[n];
        String[] coloane=new String[n];
        for( i=0;i<n;i++)
        {
            StringBuilder sb1=new StringBuilder();
            StringBuilder sb2=new StringBuilder();
            for(j=0;j<n;j++)
            {
                sb1.append(Integer.toString(matrice[i][j]));
                sb2.append(Integer.toString(matrice[j][i]));
            }
            linii[i]=sb1.toString();
            coloane[i]=sb2.toString();
        }
        if(n<1000) {
            for (i = 0; i < n; i++)
                System.out.println(linii[i]);
            System.out.println();
            for (i = 0; i < n; i++)
                System.out.println(coloane[i]);
        }
        else
        {
            long timpStop=System.nanoTime();
            long timpRulare=timpStop-timpStart;
            System.out.println("Running Time: "+timpRulare);
        }
    }
}
