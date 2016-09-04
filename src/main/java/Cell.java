/**
 * Created by Acer on 04.08.2016.
 */
public class Cell {
    int foodCapacity;
    Animals animal;

    public Cell(int foodCapacity, Animals animal) {
        this.foodCapacity = foodCapacity;
        this.animal = animal;
    }

    public Animals getAnimal() {
        return animal;
    }

    public void setAnimal(Animals animal) {
        this.animal = animal;
    }

    public void setFoodCapacity(int foodCapacity) {
        this.foodCapacity = foodCapacity;
    }

    public int getFoodCapacity() {
        return foodCapacity;
    }
}
