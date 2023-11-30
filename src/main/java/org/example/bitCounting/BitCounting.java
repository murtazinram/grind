package org.example.bitCounting;

import java.util.ArrayList;
import java.util.List;

public class BitCounting {
    public static int countBits(int n){
        List<Integer> list = new ArrayList();
        int b;
        while(n != 0) {
            b = n % 2;
            list.add(b);
            n = n/2;
        }
        return list.stream().mapToInt(i->i).sum();
    }

    public static void main(String[] args) {
        countBits(1234);
    }
}
