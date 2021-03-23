package part3;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int space;
    private List<IThing> things;
    public Room(int space) {
        things = new ArrayList<IThing>();
        this.space = space;
    }
    public int getSpace() {
        return space;
    }
    public boolean contains(IThing thing) {
        return things.contains(thing);
    }
    public boolean putThing(IThing thing) {
        if (things.contains(thing)) return false;
        int requiredSpace = thing.getSize();
        int usedSpace = things.stream().mapToInt(IThing::getSize).sum();
        if (usedSpace+requiredSpace<=space) {
            things.add(thing);
            return true;
        }
        return false;
    }
    public boolean extractThing(IThing thing) {
        return things.remove(thing);
    }
}
