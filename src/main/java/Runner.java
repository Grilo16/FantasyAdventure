import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        GameDisplay gameDisplay = new GameDisplay();

        Skill stab = new Skill("Stab", 2);
        Skill stealth = new Skill("Stealth", 5);
        Skill haste = new Skill("Haste", 5);
        Skill incapacitate = new Skill("Incapacitate", 3);
        ArrayList<Skill> skills = new ArrayList<>();
        ArrayList<Skill> skills2 = new ArrayList<>();

        skills.add(stab);
        skills.add(stealth);
        skills.add(haste);
        skills.add(incapacitate);

        skills2.add(stab);
        skills2.add(haste);

        Rogue rogue = new Rogue("Grilo", "dagger", skills);
        Rogue rogue2 = new Rogue("Ducky", "Swords", skills2);


        rogue2.xPos += 20;
        rogue2.health = 10;

        gameDisplay.addPlayers(rogue);
        gameDisplay.addPlayers(rogue2);

        boolean keepGoing = true;
        while (keepGoing){
            for (Player player: gameDisplay.getPlayers()){
                gameDisplay.playerTurn(player);

                Scanner scanner = new Scanner(System.in);
                String userChoice = String.valueOf(scanner.nextLine().toLowerCase().charAt(0));

                if (userChoice.equals("w") || userChoice.equals("a") || userChoice.equals("s") || userChoice.equals("d")){
                    player.move(userChoice, gameDisplay);
                }else {
                    keepGoing = false;
                }
            }

        }
    }
}
