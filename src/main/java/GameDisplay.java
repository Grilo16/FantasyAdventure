import java.util.ArrayList;

public class GameDisplay {
    private int height;
    private int width ;

    StringBuilder map;

    private ArrayList<Player> players;


    public GameDisplay() {
        this.height = 30;
        this.width = 100;
        this.players = new ArrayList<>();
        generateMap();
    }

    public void generateMap(){
        String newMap = "";
        for (int i = 0 ; i < height; i++){
            if (i == 0 || i == height -1){
                for (int j = 0; j < width; j++){
                    newMap += "-";
                }
                    newMap += "\n";
                    continue;
            }else {
                for (int j = 0; j < width; j++){
                    if (j == 0 || j == width -1){
                        newMap += "|";
                        continue;
                    }
                    newMap += " ";
                }
            }
            newMap += "\n";
        }
        this.map = new StringBuilder(newMap);
        addCollumnLine(60, 1, 12);
        addCollumnLine(40, 1, 12);
        addCollumnLine(70, 1, 12);
        addCollumnLine(83   , 1, 12);

        addRowLine(0, 12, 98);
        addRowLine(42, 3, 19);
        addRowLine(62, 7, 36);
        addRowLine(62, 2, 36);

        addText( 4, 2, "Health :                       ");
        addText( 10, 4, "Player :                      ");
        addText( 10, 6, "Class :                       ");
        addText( 10, 8, "Weapon :                      ");
        addText( 10, 10, "Energy :                     ");

        addText(45,1, "Attack Power:");
        addText(48,4, "Str :       ");
        addText(48,6, "Agi :       ");
        addText(48,8, "Int :       ");
        addText(48,8, "Int :       ");
        addText(48,10, "Dex :      ");

        addText(75,1, "Action");
        addText(86,1, "Energy Cost");
        addText(65,1, "Key");

        addText(66,3, "W");
        addText(66,4, "A");
        addText(66,5, "S");
        addText(66,6, "D");

        addText(66,8, "1");
        addText(66,9, "2");
        addText(66,10, "3");
        addText(66,11, "4");

        addText(72,3, " Move Up");
        addText(72,4, " Move Down");
        addText(72,5, " Move Left");
        addText(72,6, " Move Right");

        for (Player player: players){
            addText(player.getxPos(), player.getyPos(), player.getAvatar());
        }
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }
    public void addPlayers(Player playerToAdd){
        this.players.add(playerToAdd);

        for (Player player: players){
            addText(player.getxPos(), player.getyPos(), player.getAvatar());
        }
    }

    public void movePlayer(Player player){
            addText(player.getOldXPos(), player.getOldYPos(), "  ");
            addText(player.getxPos(), player.getyPos(), player.getAvatar());
            generateMap();

    }

    public void playerTurn(Player player){
        generateMap();
        String healthBar = "";
        for (int i = 0 ; i < player.getHealth()/5; i++){
            healthBar += "#";
        }
        addText(14,2, healthBar);
        addText( 20, 4,  player.getName());
        addText( 20, 6, "Rogue");
        addText( 20, 8, player.getWeapon());
        addText( 20, 10, String.valueOf(player.getEnergy()));

        addText(50,2, String.valueOf(player.getAttackPow()));
        addText(54,4, String.valueOf(player.getStrength()));
        addText(54,6, String.valueOf(player.getAgility()));
        addText(54,8, String.valueOf(player.getIntelligence()));
        addText(54,10, String.valueOf(player.getDexterity()));

        for (int i = 3 ; i < 7 ; i++){
            addText(90, i, String.valueOf(player.getEnergyToMove()));
        }

        int yPos = 8;

        for (Skill skill : player.getSkills()){
                addText(72, yPos, skill.getName());
                addText(90, yPos, String.valueOf(skill.getEnergyCost()));
                yPos++;
        }

        System.out.println(this);
    }

    public void addCollumnLine(int startX, int startY, int height){
        for (int i = 0; i < height; i ++){
            int position = ((startY + i) * 101) + startX +2;
            this.map.setCharAt(position, '|');
        }
    }

    public void addRowLine(int startX, int startY, int length) {
        for (int i = 0; i < length; i++) {
            int position = (startY * 101) + startX + 1;
            this.map.setCharAt(position + i , '-');
        }
    }

    public void addText(int startX, int startY, String text ){
        for (int i = 0; i < text.length(); i++) {
            int position = (startY * 101) + startX + 1;
            this.map.setCharAt(position + i , text.charAt(i));
        }
    }

    @Override
    public String toString() {
        return this.map.toString();
    }


}
