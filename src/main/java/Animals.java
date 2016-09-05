import java.util.logging.Logger;

/**
 * Created by Acer on 04.08.2016.
 */
public class Animals extends AbstractAnimal {
    private static Logger logger = Logger.getLogger(Animals.class.getName());

    public Animals(String name, int timeToEat, int timeToSleep){
        this.name = name;
        this.timeToEat = timeToEat;
        this.timeToSleep = timeToSleep;
    }

    public void eat(Animals animal, Cage cage) {
        animal.setTimeToEat(animal.getTimeToEat() + 1);
        cage.setFoodCapacity(cage.getFoodCapacity() - 1);
    }

    public void move() {
        setTimeToEat(getTimeToEat() - 1);
        setTimeToSleep(getTimeToSleep() - 1);
        logger.info("Lets go for a walk. When to eat = " + getTimeToEat());
        logger.info("Lets go for a walk. When to sleep = " + getTimeToSleep());

        timeToDie();
    }

    public void findFood(Animals animal, Cage cage) {
        eat(animal, cage);
        setTimeToEat(getTimeToEat() + 1);
    }

    public void timeToDie(){
        if (getTimeToEat() == 0){
            System.out.println("Good Bye");
            System.exit(0);
        }
    }

    public void emulateAction(Animals animal, Cage cage) {
        if (animal.getTimeToEat() < 4){
            logger.info("It is time to eat !" + animal.getTimeToEat());
            animal.findFood(animal, cage);
        } else {
            animal.move();
        }
    }
}
