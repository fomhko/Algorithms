class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> score = new Stack<Integer>();
        score.push(0);
        for(int i = 0; i < S.length();i++){
            if(S.charAt(i) == '('){
                score.push(0);
            }
            else if(S.charAt(i) == ')'){
                int temp = score.pop();
                if(temp == 0) temp = 1;
                else{
                    temp = temp * 2;
                }
                temp += score.pop();
                score.push(temp);
            }
        }
        return score.pop();
    }
}
