
package scorelistdemo;

/**
 *
 * @author Wael Hawa 
 * Class CIS 2353 
 * Fall 2020
 * Project 2
 *
 */
public class ScoreList {

    private ScoreNode firstNode;

    public ScoreList() {
        this.firstNode = null;

    }//end ctor

    public ScoreList(ScoreList otherList) {
        ScoreNode nodeCopy = otherList.firstNode;
        ScoreNode node = new ScoreNode(nodeCopy.getName(), nodeCopy.getScore());
        ScoreNode currentNode = node;
        while (nodeCopy.getNextNode() != null) {
            if (this.firstNode == null) {
                this.firstNode = currentNode;
            }

            nodeCopy = nodeCopy.getNextNode();
            node = new ScoreNode(nodeCopy.getName(), nodeCopy.getScore());
            currentNode.setNextNode(node);
            currentNode = node;
        }

    }//end ctor

    public void add(String name, int score) {
        ScoreNode node = new ScoreNode(name, score);
        if (firstNode == null) {
            firstNode = node;
        } else {
            ScoreNode currentNode = firstNode;
            if (node.getScore() > firstNode.getScore()) {
                node.setNextNode(firstNode);
                firstNode = node;
            } else {
                while (currentNode.getNextNode() != null) {
                    if (node.getScore() >= currentNode.getNextNode().getScore()) {

                        node.setNextNode(currentNode.getNextNode());
                        currentNode.setNextNode(node);
                        break;
                    } else {
                        currentNode = currentNode.getNextNode();
                    }//end 3rd if-else

                }//end while-loop
                currentNode.setNextNode(node);
            }//end 2nd if-else

        }//end 1st if-else

    }//end add

    public void print() {

        ScoreNode currentNode = firstNode;
        while (currentNode.getNextNode() != null) {
            System.out.println(currentNode.getName() + " " + currentNode.getScore());
            currentNode = currentNode.getNextNode();
        }//end while-loop
        System.out.println(currentNode.getName() + " " + currentNode.getScore());
    }//end print
}//end ScoreList
