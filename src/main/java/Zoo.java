import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

/**
 * Created by ${user} on 8/16/16.
 */
public class Zoo {
    private static List<Cage> cages = new ArrayList<Cage>();
    private static Logger logger = Logger.getLogger(Zoo.class.getName());

    public static void setCages(List<Cage> cages) {
        Zoo.cages = cages;
    }

    public static List<Cage> getCages() {
        return cages;
    }
    public static List<Animals> getAnimalsInCage(int i) {
        return getCages().get(i).getAnimal();
    }

    public static List<Cage> createZoo() {
        int randomCage = ThreadLocalRandom.current().nextInt(10) + 1;
        logger.info(randomCage + " cages are created");
        for (int i = 0; i < 1; i++){
            cages.add(new Cage(0, createAnimals()));
        }

        return cages;
    }

    public static List<Animals> createAnimals(){
        List<Animals> animals = new ArrayList<Animals>();

        int randomAnimal = ThreadLocalRandom.current().nextInt(10) + 1;
        logger.info(randomAnimal + " animals are created");

        for (int i = 0; i < 1; i++){
            animals.add(new Animals("Animal " + i, 10, 10));
        }

        return animals;
    }
}
