import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {

    private static final BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<Integer> list = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            list.add(i);
        }

        int cnt = 0;

        for(int i = 0; i < arr.length; i++) {
            int index = list.indexOf(arr[i]);
            int elem = list.get(index);
            int length = list.size();
            int leftShift = index;
            int rightShift = length - index - 1;


            if(leftShift <= rightShift) {
                while(list.get(0) != elem) {
                    int item = list.remove(0);
                    list.add(item);
                    cnt++;
                }

            } else {
                while(list.get(list.size() - 1) != elem) {
                    int item = list.remove(list.size() - 1);
                    list.add(0, item);
                    cnt++;
                }
                int item = list.remove(list.size() - 1);
                list.add(0, item);
                cnt++;
            }

            list.remove(0);
        }

        System.out.println(cnt);
    }
}