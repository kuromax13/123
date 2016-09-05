import java.util.logging.Logger;

/**
 * Created by Acer on 04.08.2016.
 */
public class Main {
    static final int TIME_TO_EMULATE = 2;
    static Worker worker = new Worker("Jon");
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Zoo.createZoo();

        for(int i = 0; i < TIME_TO_EMULATE; i++) {
            logger.info(i + " hour");

            for (Cage cage : Zoo.getCages()) {
                emulateAnimals(cage);
                emulateWorker(cage);
            }
        }
    }

    private static void emulateWorker(Cage cage) {
        worker.workInCage(cage);
    }

    public static void emulateAnimals(Cage cage){
        for (Animals animal : cage.getAnimal()) {
            animal.emulateAction(animal, cage);
        }
    }
}
