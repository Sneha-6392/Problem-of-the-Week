import java.util.*;
public class Solution2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        HashMap<Integer, Integer> subNum = new HashMap<>();
        subNum.put(0, 1);
        int sum=0;
        int count=0;
        for (int i : nums) {
            sum+=i;
            if (subNum.containsKey(sum-k)) {
                count+=subNum.get(sum-k);
            }
            subNum.put(sum, subNum.getOrDefault(sum, 0)+1);
        }
        System.out.println(count);
        sc.close();
    }
}
