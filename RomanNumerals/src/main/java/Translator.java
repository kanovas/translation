/**
 * @author kanovas
 * 10.05.16.
 */

import java.io.*;
import java.util.*;


public class Translator {

    private HashMap<Character, Integer> dictionary = new HashMap<Character, Integer>();


    Translator() {
        dictionary.put('I', 1);
        dictionary.put('V', 5);
        dictionary.put('X', 10);
        dictionary.put('L', 50);
        dictionary.put('C', 100);
        dictionary.put('D', 500);
        dictionary.put('M', 1000);
    }

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    private int decimal(String roman) {
        int res = 0;
        int current = 0;
        int cifer;
        for (int i = roman.length()-1; i > -1; i--) {
            cifer = dictionary.get(roman.charAt(i));
            if (cifer < current) res -= cifer;
            else {
                res += cifer;
                current = cifer;
            }
        }
        return res;
    }

    public String toDecimal(InputStream input) {
        StringBuilder res = new StringBuilder();
        Scanner in = new Scanner(input);
        String current;
        while (in.hasNext()) {
            current = in.next();
            if (current.equals("et")) res.append('+');
            else res.append(decimal(current));
        }
        res.append("\n");
        return res.toString();
    }

    public String toRoman(int decimal) {
        StringBuilder res = new StringBuilder();
        List<Integer> values = new ArrayList<Integer>(dictionary.values());
        Collections.sort(values, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        for (Integer cifer: values) {
            while (decimal >= cifer) {
                decimal -= cifer;
                res.append(getKeyByValue(dictionary, cifer));
            }
        }
        return res.toString();
    }

}
