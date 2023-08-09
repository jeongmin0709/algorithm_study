class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {4, 1000000001};
        int start = 0;
        int end = 0;
        int tempSum = 0;

        while (end < sequence.length){
            tempSum += sequence[end];
            if(tempSum>= k){
                if(tempSum == k){
                    if(end-start < answer[1]-answer[0]){
                        answer[0] = start;
                        answer[1] = end;
                        start = end;
                    }
                }else{
                    end -=1;
                    start = end;
                }
                tempSum = 0;

            }else end++;
        }
        return answer;
    }
}


