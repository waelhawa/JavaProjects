
package roleplayinggame;

/**
 *
 * @author waelh
 */
public class Bartender extends NPC {

    public Bartender() {
        this.setWeight(rand.nextInt(50) + 100);
        this.setHeight(rand.nextInt(50) + 150);
    }
    
//    public Bartender(int weight, int height){
//        super.weight = weight;
//        super.height = height;
//    }
    
    


    @Override
    public void speak (){
        System.out.println("What’ll ya have, mate?");
    }

//    @Override
//    public void setWeight(int weight) {
//        super.weight = weight;
//    }
//
//    @Override
//    public void setHeight(int height) {
//        super.height = height;
//    }

}
