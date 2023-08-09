import java.util.HashSet;
import java.util.Set;

public class Pokemon {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);
        return (nums.length/2 > set.size())? set.size() : nums.length/2;
    }
}
