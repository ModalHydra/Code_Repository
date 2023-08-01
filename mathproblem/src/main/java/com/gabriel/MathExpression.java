package com.gabriel;
public class MathExpression {
    private String expression;
    private int difficulty;


    
    public MathExpression(String expression) {
        if(validExpression(expression)){
            this.expression = expression;
        }
        else{
            System.out.println("Invaid Expression");
            this.expression = "2 + 2";
        }
        calculateDifficulty();
    }

    public boolean validExpression(){
        String compressedExpression = expression.replaceAll(" ", "");
        int len = compressedExpression.length();
        boolean output = true;

        for(int i = 0; i < len; i++){
            char temp = compressedExpression.charAt(i);
            
            switch(temp){
                case '+':
                case '-':
                case '*':
                case '/':
                case '.':
                    if(i == 0 || i == len -1){
                        output = false;
                    }
                    else if(!Character.isDigit(compressedExpression.charAt(i - 1)) || !Character.isDigit(compressedExpression.charAt(i + 1))){
                        output = false;
                    }
                    break;
                default:
                    if(!Character.isDigit(temp)){
                        output = false;
                    }
                    break;
            }
        }

        // if first character is not a num return false

        // each operator must have a num before and after it

        // each . must have a num before and after it

        // there can be no alpha characters


        return output;
    }

    public boolean validExpression(String express){
        String compressedExpression = express.replaceAll(" ", "");
        int len = compressedExpression.length();
        boolean output = true;

        for(int i = 0; i < len; i++){
            char temp = compressedExpression.charAt(i);
            
            switch(temp){
                case '+':
                case '-':
                case '*':
                case '/':
                case '.':
                    if(i == 0 || i == len -1){
                        output = false;
                    }
                    else if(!Character.isDigit(compressedExpression.charAt(i - 1)) || !Character.isDigit(compressedExpression.charAt(i + 1))){
                        output = false;
                    }
                    break;
                default:
                    if(!Character.isDigit(temp)){
                        output = false;
                    }
                    break;
            }
        }

        // if first character is not a num return false

        // each operator must have a num before and after it

        // each . must have a num before and after it

        // there can be no alpha characters


        return output;
    }

    private void calculateDifficulty(){
        difficulty = 0;
        String compressedExpression = expression.replaceAll(" ", "");
        int len = compressedExpression.length();

        for(int i = 0; i < len; i++){
            char temp = compressedExpression.charAt(i);

            switch(temp){
                case '+':
                    difficulty += 5;
                    break;
                case '-':
                    difficulty += 5;
                    break;
                case '*':
                    difficulty += 10;
                    break;
                case '/':
                    difficulty += 15;
                    break;
                case '.':
                    break;
                default:
                    difficulty += 5;
                    break;
            }
        }

    }


    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        if(validExpression(expression)){
            this.expression = expression;
        }
        else{
            System.out.println("Invaid Expression");
            this.expression = "2 + 2";
        }
        calculateDifficulty();
    }

    public int getDifficulty() {
        return difficulty;
    }
    
    
}
