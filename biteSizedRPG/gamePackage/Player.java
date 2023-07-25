package gamePackage;

public class Player{

    public String name;
    public int health;
    public boolean isDefending;
    
    
    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.isDefending = false;
    }

    public void useHealthPotion(){
        this.health += 20;
    }

    
    public void attack(Monster mon){
        if(this.isDefending){
            this.isDefending = false;
        }
        
        if(!mon.isDefending){
            mon.health -= 20;
        }
        else{
            System.out.println("Your attack was blocked.");
        }
    }

    public void defend(){
        this.isDefending = true;
    }

    public void printHealth(){
        System.out.println(this.name + " has " + this.health + " remaining.");
    }

    

    
    



}