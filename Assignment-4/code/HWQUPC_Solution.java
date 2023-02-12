package edu.neu.coe.info6205.union_find;
import java.util.Random;
public class HWQUPC_Solution {

    static int no_union=0;
//    public static int count(int n){
//        int pairs = 0;
//        UF_HWQUPC uf = new UF_HWQUPC(n);
//        Random random = new Random();
//        while(uf.components()>1){
//            int p = random.nextInt(n);
//            int q = random.nextInt(n);
//            pairs++;
//            if(uf.connected(p,q)){
//                uf.union(p,q);
//                no_union++;
//            }
//        }
//        return pairs;
//
//    }
public static int count(int n) {
    int pairs = 0;
    UF_HWQUPC uf = new UF_HWQUPC(n);
    Random random = new Random();
    while(uf.components()>1) {
        int i = random.nextInt(n);
        int j = random.nextInt(n);
        pairs++;
        if (!uf.isConnected(i, j)) {
            uf.connect(i, j);
            no_union++;
        }

    }
    return pairs;
}


    public static void printConnections(int runs, int interval, int upperBound) {
        for (int i = interval; i <= upperBound; i = i+interval) {
            int total = 0;
            for (int j = 0; j < runs; j++) {
                total+=count(i);
            }
            System.out.print("Sites:" + i + " Connections - " + total/runs);
            System.out.println(" Unions - "+no_union/runs);
            no_union=0;
        }
    }
    public static void main(String[] arg) {

        printConnections(1000, 250, 1500);
    }
}
