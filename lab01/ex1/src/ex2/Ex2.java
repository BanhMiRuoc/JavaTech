import java.util.Random;

import vn.edu.tdtu.ArrayHandler;
import vn.edu.tdtu.ArrayOutput;

public class Ex2 {
    public static void main(String[] args) {
        Random random = new Random();
        int a[] = new int[10];
        int b[] = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = random.nextInt(100);
            b[i] = random.nextInt(100);
        }
        //print array
        ArrayOutput.print(a);
        ArrayOutput.print(b);

        int c[] = ArrayHandler.merge(a,b);
        ArrayOutput.print(c);

        ArrayHandler.sort(c);
        ArrayOutput.write(c, "output.txt");


    }
}