// Java program to demonstrate
// extending an array
import java.lang.*;

public class ExtendArray {
    public static void main(String[] args) {
        String[] str = new String[] { "G", "E", "E" };
        // allocating space for 5 strings
        // in the extended array
        String[] ext = new String[5];
        ext[3] = "K";
        ext[4] = "S";

        // copying the array elements
        // to new extended array
        System.arraycopy(str, 0, ext, 0, str.length);

        for (String s : ext) {
            System.out.print(s);
        }
    }
}
