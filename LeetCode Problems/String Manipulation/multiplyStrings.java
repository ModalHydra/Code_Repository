class Solution {
    public String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }



        int len1 = num1.length();
        int len2 = num2.length();

        String output = "0";
        String temp1 = "";

        num1 = reverse(num1);
        //num2 = reverse(num2);
        
        for(int i = 0; i < len1; i++){
            temp1 = partialMultiply(num2, num1.charAt(i), i);
            output = addStrings(temp1, output);
        }

        

        //output = addStrings("0", "123");
        
        return output;
        // can't convert strings to int directly
    }

    String partialMultiply(String num1, char num2, int pos){
        String output = "";
        int temp1;
        int temp2 = Integer.valueOf(num2) - '0';
        int carryOver = 0;
        int partialMultiply;
        String sPM;


        int len1 = num1.length();
        num1 = reverse(num1);

        for(int i = 0; i < pos; i++){
            output += "0";
        }

        for(int i = 0; i < len1; i++){
            temp1 = Integer.valueOf(num1.charAt(i)) - '0';
            partialMultiply = temp1 * temp2 + carryOver;
            sPM = String.valueOf(partialMultiply);
            if(sPM.length() == 1){
                output += sPM.charAt(0);
                carryOver = 0;
            }
            else{
                output += sPM.charAt(1);
                carryOver = Integer.valueOf(sPM.charAt(0)) - '0';
            }
        }
        if(carryOver > 0){
            output += String.valueOf(carryOver);
        }

        return reverse(output);
    }

    String addStrings(String num1, String num2){
        String output = "";
        int len1 = num1.length();
        int len2 = num2.length();
        int difference = Math.abs(len1 - len2);

        num1 = reverse(num1);
        num2 = reverse(num2);

        if(len1 < len2){
            for(int i = 0; i < difference; i++){
                num1 += "0";
            }
        }
        else if (len1 > len2){
            for(int i = 0; i < difference; i++){
                num2 += "0";
            }
        }


        int temp1;
        int temp2;
        int carryOver = 0;
        int partialSum;
        String sPS;

        

        for(int i = 0; i < Math.max(len1, len2); i++){
            temp1 = Integer.valueOf(num1.charAt(i)) - '0';
            temp2 = Integer.valueOf(num2.charAt(i)) - '0';
            partialSum = temp1 + temp2 + carryOver;
            sPS = String.valueOf(partialSum);
            if(sPS.length() == 1){
                output += sPS.charAt(0);
                carryOver = 0;
            }
            else{
                output += sPS.charAt(1);
                carryOver = Integer.valueOf(sPS.charAt(0)) - '0';
            }
        }
        if(carryOver > 0){
            output += String.valueOf(carryOver);
        }

        return reverse(output);

    }

    String reverse(String num){
        String output = "";
        int len = num.length();

        for(int i = len -1; i >= 0; i--){
            output += num.charAt(i);
        }

        return output;
    }
}