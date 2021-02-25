package imagesearch;

/**
 *
 * @author waelh
 */
public class ImageNode {

    private String fileName;
    private boolean animal;
    private boolean flowers;
    private boolean people;
    private boolean buildings;
    private boolean landscapes;
    private ImageNode nextNode;
    
    public ImageNode(){
        
    }

    public ImageNode(String fileName, boolean animal, boolean flowers, boolean people, boolean buildings, boolean landscapes) {
        this.animal = animal;
        this.flowers = flowers;
        this.people = people;
        this.buildings = buildings;
        this.landscapes = landscapes;
        this.fileName = fileName;
    }//end ctor

    public boolean getAnimal() {
        return animal;
    }

    public void setAnimal(boolean animal) {
        this.animal = animal;
    }

    public boolean getFlowers() {
        return flowers;
    }

    public void setFlowers(boolean flowers) {
        this.flowers = flowers;
    }

    public boolean getPeople() {
        return people;
    }

    public void setPeople(boolean people) {
        this.people = people;
    }

    public boolean getBuildings() {
        return buildings;
    }

    public void setBuildings(boolean buildings) {
        this.buildings = buildings;
    }

    public boolean getLandscapes() {
        return landscapes;
    }

    public void setLandscapes(boolean landscapes) {
        this.landscapes = landscapes;
    }

    public ImageNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ImageNode nextNode) {
        this.nextNode = nextNode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public boolean nodeVariable(int location) {
        switch (location) {
            case 0:
                return animal;
            case 1:
                return flowers;
            case 2:
                return people;
            case 3:
                return buildings;
            default:
                return landscapes;
        }
    }
    
    

    
}
