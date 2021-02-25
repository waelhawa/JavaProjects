
package roleplayinggame;

/**
 *
 * @author waelh
 */
public class Guard extends NPC{

    public Guard() {
        this.setWeight(rand.nextInt(90) + 180);
        this.setHeight(rand.nextInt(150) + 150);
    }
    
//    public Guard(int weight, int height){
//        super.weight = weight;
//        super.height = height;
//    }
    
    
    
    @Override
    public void speak(){
        System.out.println("Any friend of the kingdom is a friend of mine!");
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
