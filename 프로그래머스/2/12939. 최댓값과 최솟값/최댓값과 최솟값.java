class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        } 

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }
        
        answer = min + " " + max;
        return answer;
    }
}