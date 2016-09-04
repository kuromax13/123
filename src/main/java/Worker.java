/**
 * Created by ${user} on 8/23/16.
 */
public class Worker {
    private String name;
    final int MIN_FOOD_CAPACITY_IN_CAGE = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Worker(String name) {
        this.name = name;
    }

    public void workInCage(Cage cage){
        int food = 10 - cage.getFoodCapacity(); // 10 - max capacity of the foof in the cage
        if (isEnoughFoodInCage(cage)){
            System.out.println("There is enough food here = " + cage.getFoodCapacity());
        } else {
            cage.setFoodCapacity(food);
        }
    }

    public Cage cleanCage(Cage cage, Animals animal){
        if (animal == null) {
            cage.getAnimal().remove(animal);
        }

        return cage;
    }

    public boolean isEnoughFoodInCage(Cage cage){
        return cage.getFoodCapacity() > MIN_FOOD_CAPACITY_IN_CAGE;
    }
}
