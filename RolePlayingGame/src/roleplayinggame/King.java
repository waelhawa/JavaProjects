
package roleplayinggame;



/**
 *
 * @author waelh
 */

public class King extends NPC {

    public King() {
        this.setWeight(rand.nextInt(90)+160);
        this.setHeight(rand.nextInt(80)+100);
    }
    
//    public King(int weight, int height){
//        super.weight = weight;
//        super.height = height;
//    }
    
    

//    @Override
//    public void setWeight(int weight) {
//        super.weight = weight;
//    }


//    @Override
//    public void setHeight(int height) {
//        super.height = height;
//    }
    
    
    
    @Override
    public void speak(){
        System.out.println("Hello traveler! Welcome to my kingdom!");
    }
    
    
    
}
