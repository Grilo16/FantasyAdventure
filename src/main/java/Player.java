import java.util.ArrayList;

public abstract class Player  implements Actionable{
    int health;
    String name;
    String weapon;

    int xPos;
    int oldXPos;
    int oldYPos;
    int yPos;

    int energy;
    int attackPow;
    int strength;
    int agility;
    int intelligence;
    int dexterity;

    String avatar;
    int energyToMove;

    ArrayList<Skill> skills;



    public Player(String name, String weapon, ArrayList<Skill> skills) {
        this.health = 100;
        this.name = name;
        this.weapon = weapon;
        this.xPos = 10;
        this.yPos = 26;
        this.energy = 10;
        this.attackPow = 100;
        this.strength = 10;
        this.agility = 10;
        this.intelligence = 10;
        this.dexterity = 10;
        this.energyToMove = 10;
        this.skills = skills;

    }

    public int getEnergyToMove() {
        return energyToMove;
    }

    public String getName() {
        return this.name;
    }


    public String getWeapon() {
        return this.weapon;
    }

    public int getHealth() {
        return this.health;
    }

    public int getEnergy() {
        return this.energy;
    }

    public int getAttackPow() {
        return this.attackPow;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getAgility() {
        return this.agility;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public int getxPos() {
        return this.xPos;
    }

    public int getyPos() {
        return this.yPos;
    }

    public int getOldXPos() {
        return this.oldXPos;
    }

    public int getOldYPos() {
        return this.oldYPos;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void moveUp(){
        this.oldXPos = xPos;
        this.oldYPos = yPos;
        this.yPos -= 2;
    }
    public void moveDown(){
        this.oldXPos = xPos;
        this.oldYPos = yPos;
        this.yPos += 2;
    }
    public void moveLeft(){
        this.oldXPos = xPos;
        this.oldYPos = yPos;
        this.xPos -= 5;
    }
    public void moveRight(){
        this.oldXPos = xPos;
        this.oldYPos = yPos;
        this.xPos += 5;
    }

    public ArrayList<Skill> getSkills() {
        return this.skills;
    }

    public void move(String key , GameDisplay game) {
        if (key.equals("w")){
            this.moveUp();
        } else if (key.equals("s")) {
            this.moveDown();
        } else if (key.equals("a")) {
            this.moveLeft();
        } else if (key.equals("d")) {
            this.moveRight();
        }
        game.movePlayer(this);
    }


}
