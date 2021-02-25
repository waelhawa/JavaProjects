
package roleplayinggame;

/**
 *
 * @author waelh
 */

import java.util.*;
public class RPG {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        ArrayList<NPC> nonPlayables = new ArrayList();
        Random rand2 = new Random();
        int character;
        for(int i = 0; i < 100; i++){
            NPC player;
            character = rand2.nextInt(4)+1;
            switch (character) {
                case 1:
                    //rand2.nextInt(90)+160, rand2.nextInt(80)+100
                    player = new King();
                    break;
                case 2:
                    //rand2.nextInt(80)+100, rand2.nextInt(60)+90
                    player = new Queen();
                    break;
                case 3:
                    //rand2.nextInt(90) + 180, rand2.nextInt(150) + 150
                    player = new Guard();
                    break;
                default:
                    //rand2.nextInt(50) + 100, rand2.nextInt(50) + 150
                    player = new Bartender();
                    break;
            }
            
            nonPlayables.add(i, player);
        }
        
        for (int i = 0; i < nonPlayables.size(); i++){
            
            System.out.printf("%03d - ", i+1);
            nonPlayables.get(i).speak();
            System.out.println("\tWeight is " + nonPlayables.get(i).getWeight());
            System.out.println("\tHeight is " + nonPlayables.get(i).getHeight());
            
        }
            
            
    }
    
}
