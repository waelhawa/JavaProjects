package imagesearch;

import java.util.ArrayList;

/**
 *
 * @author waelh
 */
public class ImageList {

    private ImageNode firstNode;
    private ImageNode lastNode;
    private ImageNode nullNode;

    public ImageList() {
        this.firstNode = null;
        this.lastNode = null;
        this.nullNode = null;

    }//end ctor

    public void add(String fileName, boolean animal, boolean flowers, boolean people, boolean buildings, boolean landscapes) {
        ImageNode node = new ImageNode(fileName, animal, flowers, people, buildings, landscapes);
        if (firstNode == null) {
            firstNode = node;
            lastNode = node;
            lastNode.setNextNode(nullNode);
        } else {
            lastNode.setNextNode(node);
            lastNode = node;
            lastNode.setNextNode(nullNode);

        }

    }//end add

    public void print() {

        ImageNode currentNode = firstNode;
        while (currentNode.getNextNode() != null) {
            System.out.println(currentNode.getFileName() + " has\nAnimals " + currentNode.getAnimal() + "\nFlowers " + currentNode.getFlowers() + "\nPeople " + currentNode.getPeople()
                    + "\nBuildings " + currentNode.getBuildings() + "\nLandscapes " + currentNode.getLandscapes() + "\n\n");
            currentNode = currentNode.getNextNode();
        }//end while-loop
        System.out.println(currentNode.getFileName() + " has\nAnimals " + currentNode.getAnimal() + "\nFlowers " + currentNode.getFlowers() + "\nPeople " + currentNode.getPeople()
                + "\nBuildings " + currentNode.getBuildings() + "\nLandscapes " + currentNode.getLandscapes());
    }//end print

    public ArrayList search(boolean logicGate, boolean... args) {
        boolean operand = true;
        boolean andGate = true;
        boolean bool;
        ImageNode node;
        ArrayList<String> array = new ArrayList<>();
        node = firstNode;
        while (node != nullNode) {
            bool = true;
            if (!logicGate) {
                for (int x = 0; x < args.length; x++) {
                    if (args[x] && bool){
                        operand = node.nodeVariable(x);
                        bool = false;
                        }
                    if (args[x] && !bool){
                        andGate = node.nodeVariable(x);
                    }
                    
                }
                

            }
            for (int x = 0; x < args.length; x++) {

                    if (args[x] && node.nodeVariable(x) && operand && andGate) {
                        array.add(node.getFileName());
                    }

            }//end for
            node = node.getNextNode();
        }//end while
        for (int i = 0; i < array.size(); i++) {
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(i).equals(array.get(j))) {
                    array.remove(j);
                }
            }
        }

        return array;
    }//end
}//end ImageList
