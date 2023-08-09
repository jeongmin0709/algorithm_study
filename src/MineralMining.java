import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MineralMining {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int maxMiningNum = (minerals.length < (picks[0]+picks[1]+picks[2])*5)? minerals.length:(picks[0]+picks[1]+picks[2])*5; //캘수있는 최대 광물의 수
        List<int[]> fatigueList = new ArrayList<>();
        int diaFatigue = 0; // 다이아 곡갱이로 캣을때의 피로도
        int ironFatigue = 0; // 철 곡갱이로 캣을때의 피로도
        int stoneFatigue = 0; // 돌 곡갱이로 캣을때의 피로도
        int j=0;
        for(int i=0; i < maxMiningNum; i++){
            j++;
            if(minerals[i].equals("diamond")){
                diaFatigue +=1;
                ironFatigue +=5;
                stoneFatigue +=25;
            }else if(minerals[i].equals("iron")){
                diaFatigue +=1;
                ironFatigue +=1;
                stoneFatigue +=5;
            }else {
                diaFatigue +=1;
                ironFatigue +=1;
                stoneFatigue +=1;
            }
            if(j==5 || i == maxMiningNum-1){
                int[] fatigue = {diaFatigue, ironFatigue, stoneFatigue};
                fatigueList.add(fatigue);
                diaFatigue = 0;
                ironFatigue = 0;
                stoneFatigue = 0;
                j=0;
            }
        }
        //돌곡갱이로캣을때 피로도순으로 내림차순 정렬
        fatigueList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2]- o1[2];
            }
        });
        for (int i=0; i<fatigueList.size(); i++){
            if(i< picks[0]) answer += fatigueList.get(i)[0];
            else if(i< picks[0]+picks[1]) answer += fatigueList.get(i)[1];
            else answer += fatigueList.get(i)[2];
        }
        return answer;
    }
}

