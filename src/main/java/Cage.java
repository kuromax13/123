import java.util.List;

/**
 * Created by Acer on 04.08.2016.
 */
public class Cage {
    int foodCapacity;
    List<Animals> animal;

    public Cage(int foodCapacity, List<Animals> animal) {
        this.foodCapacity = foodCapacity;
        this.animal = animal;
    }

    public List<Animals> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Animals> animal) {
        this.animal = animal;
    }

    public void setFoodCapacity(int foodCapacity) {
        this.foodCapacity = foodCapacity;
    }

    public int getFoodCapacity() {
        return foodCapacity;
    }
}
