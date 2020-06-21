package com.rafel.test;

import java.util.Scanner;

public class BigNumber {
    public static String BigAdd(String A, String B) {
        StringBuffer sb1 = new StringBuffer(A).reverse();
        StringBuffer sb2 = new StringBuffer(B).reverse();

        StringBuffer res = new StringBuffer();

        if (A.length() < B.length()) {
            for (int i = 0; i < B.length() - A.length(); i++) {
                sb1.append(0);
            }
        } else {
            for (int i = 0; i < A.length() - B.length(); i++) {
                sb2.append(0);
            }
        }

        int index1 = 0;
        int index2 = 0;

        int add = 0;

        while (index1 < A.length()) {
            int temp = (sb1.charAt(index1++) - '0') + (sb2.charAt(index2++) - '0') + add;
            res.append(temp % 10);
            add = temp / 10;

        }

        if (add > 0) res.append(add);
        return res.reverse().toString();
    }

    public static String BigSub(String A, String B) {
        boolean flag=(Math.abs(Integer.parseInt(A)) > Math.abs(Integer.parseInt(B))&&A.charAt(0) == '-') ||
                (Math.abs(Integer.parseInt(A)) < Math.abs(Integer.parseInt(B)) && B.charAt(0) == '-');

        if (A.charAt(0) == '-') A = A.substring(1);
        else B = B.substring(1);

        StringBuffer sb1;
        StringBuffer sb2;
        // 长度大的sb1是被减数，效地sb2是减数
        if (Math.abs(Integer.parseInt(A)) > Math.abs(Integer.parseInt(B))) {
            sb1 = new StringBuffer(A).reverse();
            sb2 = new StringBuffer(B).reverse();
            for (int i = 0; i < A.length() - B.length(); i++) {
                sb2.append(0);
            }
        } else {
            sb2 = new StringBuffer(A).reverse();
            sb1 = new StringBuffer(B).reverse();
            for (int i = 0; i < B.length() - A.length(); i++) {
                sb2.append(0);
            }
        }

        StringBuffer res = new StringBuffer();

        int index1 = 0;
        int index2 = 0;

        int sub = 0;

        while (index1 < sb1.length()) {
            int temp;
            if (sb1.charAt(index1) - '0' + sub < sb2.charAt(index2) - '0') {
                temp = sb1.charAt(index1) - '0' + 10 - (sb2.charAt(index2) - '0') + sub;
                sub = -1;
            } else {
                temp = sb1.charAt(index1) - '0' - (sb2.charAt(index2) - '0') + sub;
            }
            res.append(temp);
            index1++;
            index2++;
        }

        String result=res.reverse().toString().substring(1);

        if (flag) result+="-";

        return result;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        String m = scanner.next();

        if (n.charAt(0) == '-' || m.charAt(0) == '-') System.out.println(BigSub(n, m));
        else System.out.println(BigAdd(n, m));

    }
}
