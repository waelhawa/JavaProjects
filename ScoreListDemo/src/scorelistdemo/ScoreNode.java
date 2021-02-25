
package scorelistdemo;

/**
 *
 * @author Wael Hawa 
 * Class CIS 2353 
 * Fall 2020
 * Project 2
 *
 */
public class ScoreNode {

    private String name;
    private int score;
    private ScoreNode nextNode;

    public ScoreNode(String name, int score) {
        this.name = name;
        this.score = score;

    }//end ctor

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ScoreNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ScoreNode nextNode) {
        this.nextNode = nextNode;
    }
    
    
    

}
