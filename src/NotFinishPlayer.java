    import java.util.HashMap;
    import java.util.Map;

public class NotFinishPlayer {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(String c:completion){
            if(map.containsKey(c)) map.replace(c, map.get(c)+1);
            else map.put(c, 1);
        }
        for(String p: participant){
            Integer num = map.get(p);
            if(num == null || num == 0) return p;
            map.replace(p, num-1);
        }
        return "";
    }
}
