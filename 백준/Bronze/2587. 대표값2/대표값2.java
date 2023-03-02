import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    private final static BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        int[] arr = new int[5];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        arr = IntStream.of(arr)
                .sorted()
                .toArray();

        double avg = IntStream.of(arr)
                .average().getAsDouble();

        System.out.println((int) avg);
        System.out.println(arr[2]);
    }
}