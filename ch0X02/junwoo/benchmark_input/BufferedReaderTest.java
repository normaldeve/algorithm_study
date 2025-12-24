package junwoo.benchmark_input;

import java.io.*;

public class BufferedReaderTest {

    public static void main(String[] args) throws Exception {
        long start = System.nanoTime();

        BufferedReader br = new BufferedReader(
                new FileReader(new File("ch0X02/junwoo/benchmark_input/input.txt"))
        );

        long sum = 0;
        String line;

        while ((line = br.readLine()) != null) {
            sum += Integer.parseInt(line);
        }

        br.close();

        long end = System.nanoTime();

        PrintWriter out = new PrintWriter(new FileWriter("ch0X02/junwoo/benchmark_input/result.txt", true));
        out.println();
        out.println("====== BufferedReaderTest ======");
        out.println("result sum = " + sum);
        out.println("Scanner time(ms): " + (end - start) / 1_000_000);

        out.close();

        System.out.println("result sum = " + sum);
        System.out.println("BufferedReader time(ms): " + (end - start) / 1_000_000);
    }
}