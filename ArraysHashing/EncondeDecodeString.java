package ArraysHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncondeDecodeString {
    public static void main(String[] args) {
        List<String> strs = Arrays.asList("need", "code", "love", "you");
        String encoded = encode(strs);
        System.out.println("Original list: " + strs.toString());
        System.out.println("Encoded String: " + encoded);
        List<String> decoded = decode(encoded);
        System.out.println("Decoded String: " + decoded.toString());

    }

    public static String encode(List<String> strs) {
        String encodedRes = "";
        // to add into one string make sure to add
        // the length as an int before with #
        // # after int tells when to stop when decoding
        for (String s : strs) {
            encodedRes += s.length() + "#" + s;
        }
        return encodedRes;
    }

    public static List<String> decode(String str) {
        // holds the res
        List<String> decodedRes = new ArrayList<>();

        //
        int i = 0;
        // iterate through entire encoded string
        while (i < str.length()) {
            // start at index i
            int j = i; // reset j at i after each word
            // j will iterate until the # is found
            // while i stays in place
            while (str.charAt(j) != '#') j++;

            // after the # sign is found then get the int value before #
            int length = Integer.valueOf(str.substring(i,j));
            
            // move i to other end of the word but adding the length
            i = j + 1 + length;
            // get the word after adding 1 and length to i
            // j is currently at # so + 1
            decodedRes.add(str.substring(j + 1, i));
        }
        return decodedRes;
    }
    
}
