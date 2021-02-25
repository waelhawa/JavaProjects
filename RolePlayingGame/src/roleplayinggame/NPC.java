
package roleplayinggame;

import java.util.Random;


/**
 *
 * @author waelh
 */
abstract class NPC {

static Random rand = new Random();
private int weight;
private int height;


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }
    
    abstract void speak();
}

