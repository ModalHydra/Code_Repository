class Solution {

    static final String inputKey[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    ArrayList<String> output = new ArrayList<String>();
    
    public List<String> letterCombinations(String digits) {
        
        letterCombHelper(digits, "", 0);

        if(output.get(0) == ""){
            output.remove(0);
        }


        return output;
    }

    public void letterCombHelper(String digits, String current, int position){

        if(position == digits.length()){
            output.add(current);
        }
        else{
            int nextInput = digits.charAt(position) - '0';
            for(int i = 0; i < inputKey[nextInput].length(); i++){
                letterCombHelper(digits, current + inputKey[nextInput].charAt(i), position + 1);
            }
        }
    }
}