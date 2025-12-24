package junwoo.benchmark_input;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Scanner로 입력 받기
 *
 * @author junnukim1007gmail.com
 * @date 25. 12. 24.
 */
public class ScannerTest {
    public static void main(String[] args) throws Exception {
        long start = System.nanoTime();

        Scanner sc = new Scanner(new File("ch0X02/junwoo/benchmark_input/input.txt"));
        long sum = 0;
        while (sc.hasNextInt()) {
            sum += sc.nextInt();
        }

        long end = System.nanoTime();

        PrintWriter out = new PrintWriter(new FileWriter("ch0X02/junwoo/benchmark_input/result.txt", true));
        out.println();
        out.println("====== ScannerTest ======");
        out.println("result sum = " + sum);
        out.println("Scanner time(ms): " + (end - start) / 1_000_000);

        out.close();

        System.out.println("result sum : " + sum);
        System.out.println("Scanner time(ms): " + (end - start) / 1_000_000);
    }
}
