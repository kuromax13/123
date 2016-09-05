import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by Acer on 04.08.2016.
 */
public class Animals extends AbstractAnimal {
    Random random = new Random();
    private static Logger logger = Logger.getLogger(Animals.class.getName());

    public Animals(String name, int timeToEat, int timeToSleep, AnimalStatus animalStatus){
        this.name = name;
        this.timeToEat = timeToEat;
        this.timeToSleep = timeToSleep;
        this.animalStatus = animalStatus;
    }

    public Cage emulateAction(Animals animal, Cage cage) {
        if (animal != null){
            if (animal.getTimeToEat() < 4){
                logger.info("It is time to eat !" + animal.getTimeToEat());
                animal.findFood(animal, cage);
            } else {
                animal.move(animal);
            }
        } else {
            logger.warning("This animal is dead");
        }
        return cage;
    }

    public Animals findFood(Animals animal, Cage cage) {
        int chanceToFindFood = random.nextInt(10);

        move(animal);
        if (chanceToFindFood > 9){
            eat(animal, cage);
        }
        return animal;
    }

    public Animals eat(Animals animal, Cage cage) {
        int foodToEat = random.nextInt(cage.getFoodCapacity());
        animal.setTimeToEat(animal.getTimeToEat() + foodToEat);
        cage.setFoodCapacity(cage.getFoodCapacity() - foodToEat);
        return animal;
    }

    public Animals move(Animals animal) {
        animal.setTimeToEat(getTimeToEat() - 1);
        animal.setTimeToSleep(getTimeToSleep() - 1);
        logger.info("Lets go for a walk. When to eat = " + getTimeToEat());
        logger.info("Lets go for a walk. When to sleep = " + getTimeToSleep());

        animal = timeToDie(animal);
        return animal;
    }

    public Animals timeToDie(Animals animal){
        if (getTimeToEat() <= 0){
            logger.warning("Animal is dead.");
            animal.setAnimalStatus(AnimalStatus.DEAD);
        }
        return animal;
    }
}
