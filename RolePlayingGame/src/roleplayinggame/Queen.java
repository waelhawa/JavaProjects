
package roleplayinggame;

/**
 *
 * @author waelh
 */
public class Queen extends NPC {

    public Queen() {
        this.setWeight(rand.nextInt(80)+100);
        this.setHeight(rand.nextInt(60)+90);
    }
    
//    public Queen(int weight, int height){
//        super.weight = weight;
//        super.height = height;
//    }
        
        
        
        @Override
        public void speak(){
            System.out.println("Welcome, friend of the realm! Speak with my husband the king!");
        }

//        @Override
//    public void setWeight(int weight) {
//        super.weight = weight;
//    }
//
//        @Override
//    public void setHeight(int height) {
//        super.height = height;
//    }

}
