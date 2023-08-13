import java.util.HashMap;
import java.util.Map;

public class Clothe {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(String[] clothe: clothes){
            if(map.containsKey(clothe[1])) map.replace(clothe[1], map.get(clothe[1])+1);
            else map.put(clothe[1], 2);
        }
        for(Integer i: map.values()) answer *= i;
        return  answer-1;
    }
}
