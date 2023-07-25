package gamePackage;
import java.util.Random;

public class Monster{
    public String name;
    public int health;
    public boolean isDefending;
    
    
    public Monster(String name) {
        this.name = name;
        this.health = 100;
        this.isDefending = false;
    }

    public void attack(Player play){
        if(this.isDefending){
            this.isDefending = false;
        }
        
        if(!play.isDefending){
            play.health -= 20;
        }
        else{
            System.out.println("Your attack was blocked.");
        }
    }

    public void useHealthPotion(){
        this.health += 20;
    }

    public void defend(){
        this.isDefending = true;
    }

    public void printHealth(){
        System.out.println(this.name + " has " + this.health + " remaining.");
    }

    public void randomAction(Player play){
        Random rand = new Random();
        int action = rand.nextInt(3) + 1;

        switch (action) {
            case 1:
                System.out.println(this.name + " is attacking");
                attack(play);
                break;
            case 2:
                System.out.println(this.name + " is using a potion");
                useHealthPotion();
                break;
            case 3:
                System.out.println(this.name + " is defending");
                defend();
                break;
            default:
                System.out.println("there was a problem");
                break;
        }
    }
    
    
    
}
