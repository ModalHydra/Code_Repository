package com.gabriel;

import java.util.Random;
import java.util.Stack;

public class MathMan {
    private int intelligence;
    private int numProblemsSolved;
    private String name;

    
    public MathMan(int intelligence, String name) {
        this.intelligence = intelligence;
        this.name = name;
        this.numProblemsSolved = 0;
    }


    public double solveExpression(MathExpression problem){
        if(canSolve(problem)){
            double solution = 0;
            String expression = problem.getExpression();
            
            // put it into a stack
            Stack<Double> stack = new Stack<>();
            expression = expression.replaceAll(" ", ""); // get rid of spaces
            
            int len = expression.length();
            double currentNum;
            String numBuilder = "";
            char currentOperation = '+';

            for(int i = 0; i < len; i++){
                char temp = expression.charAt(i);

                if(Character.isDigit(temp) || temp == '.'){ // build the current number
                    numBuilder += temp;
                }
                
                if(i == len -1 || (!Character.isDigit(temp) && temp != '.')){ // every time an operator or last number
                    
                    currentNum = Double.valueOf(numBuilder);
                    numBuilder = "";

                    switch(currentOperation){
                        case '+':
                            stack.push(currentNum);
                            break;
                        case '-':
                            stack.push(-currentNum);
                            break;
                        case '*':
                            stack.push(stack.pop() * currentNum);
                            break;
                        case '/':
                            stack.push(stack.pop() / currentNum);
                            break;
                        default:
                            break;
                    }
                    currentOperation = temp;
                }
            }

            while(!stack.empty()){
                solution += stack.pop();
            }
            
            numProblemsSolved++;
            intelligence++;

            return solution;
        }
        else{
            intelligence += 2;
            Random rand = new Random();
            return rand.nextInt(10000);
        }
    }

    public boolean canSolve(MathExpression problem){

        if(problem.getDifficulty() > intelligence){
            return false;
        }
        else{
            return true;
        }
    }


    public int getIntelligence() {
        return intelligence;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    public int getNumProblemsSolved() {
        return numProblemsSolved;
    }
    public void setNumProblemsSolved(int numProblemsSolved) {
        this.numProblemsSolved = numProblemsSolved;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
