/**
 * @author kanovas
 * 28.05.16.
 */

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Euclid {

    private static Scanner in;
    private static PrintWriter out;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int a = in.nextInt();
        int b = in.nextInt();
        if (a < b) {
            int z = a;
            a = b;
            b = z;
        }
        int r = b, q;
        while (a % b != 0) {
            q = a / b;
            r = a - q * b;
            a = b;
            b = r;
        }
        out.println(r);
        out.flush();
    }

}
