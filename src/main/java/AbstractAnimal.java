/**
 * Created by Acer on 04.08.2016.
 */
public abstract class AbstractAnimal {
    protected String name;
    protected int timeToSleep;
    protected int timeToEat;

    public String getName() {
        return name;
    }

    public int getTimeToSleep() {
        return timeToSleep;
    }

    public int getTimeToEat() {
        return timeToEat;
    }

    public void setTimeToEat(int timeToEat) {
        this.timeToEat = timeToEat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeToSleep(int timeToSleep) {
        this.timeToSleep = timeToSleep;
    }
}
