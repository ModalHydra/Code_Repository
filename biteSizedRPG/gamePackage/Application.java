package gamePackage;

import java.util.Scanner;

public class Application {


    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter a Player name: ");
        String name = scanner.nextLine();

        Player player = new Player(name);
        Monster monster = new Monster("Zombie");


        while(player.health > 0 && monster.health > 0){
            player.printHealth();
            monster.printHealth();

            System.out.println("Choose your action\n1. attack\n2. defend\n3. use a potion");
            int action = scanner.nextInt();
            
            switch (action) {
                case 1:
                    player.attack(monster);
                    break;
                case 2:
                    player.defend();
                    break;
                case 3:
                    player.useHealthPotion();
                    break;
                default:
                    System.out.println("invalid action choice skip turn");
                    break;
            }

            monster.randomAction(player);
        }

        if(player.health <= 0){
            System.out.println("You lose " + player.name);
        }
        else{
            System.out.println("You have slain the " + monster.name);
        }

        scanner.close();
    }
    
}
