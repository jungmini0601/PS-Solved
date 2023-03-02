import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    private final static BufferedReader br 
        = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        
        // 모두 동일한 경우
        if(arr[0] == arr[1] && arr[1] == arr[2]) {
            System.out.println(10000 + arr[0] * 1000);
            return;
        }
        
        // 모두 다른 경우
        if(arr[0] != arr[1] && arr[1] != arr[2] && arr[0] != arr[2]) {
            System.out.println(arr[2] * 100);
            return;
        }
        
        // 2개가 같다면 무조건 1번이 공통임 (정렬이 되었기 때문에)
        System.out.println(arr[1] * 100 + 1000);
    }
}