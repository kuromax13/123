import java.util.logging.Logger;

/**
 * Created by Acer on 04.08.2016.
 */
public class Main {
    static final int TIME_TO_EMULATE = 3;
    static Worker worker = new Worker("John");
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Zoo.createZoo();

        for(int i = 0; i < TIME_TO_EMULATE; i++) {
            logger.info(i + " hour");

            for (Cage cage : Zoo.getCages()) {
                worker.workInCage(cage);
                emulateAnimals(cage);
            }
        }
    }

    public static Cage emulateAnimals(Cage cage){
        for (Animals animal : cage.getAnimal()) {
            if (animal.getAnimalStatus() != AnimalStatus.DEAD){
                animal.emulateAction(animal, cage);
            } else {
//                worker.cleanCage(cage, animal);
//                cage.getAnimal().remove(animal);
                logger.info("This animal is dead");
            }
        }
        return cage;
    }
}
