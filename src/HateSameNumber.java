import java.util.*;

public class HateSameNumber {
    public int[] solution(int []arr) {
        List<Integer> answer = new LinkedList<>();
        int prev = -1;
        for(int num: arr){
            if(prev != num) answer.add(num);
            prev = num;
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
