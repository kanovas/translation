/**
 * @author kanovas
 * 11.06.16.
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try {
            Compiler.compile("original");
            Decompiler.decompile();
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

}
