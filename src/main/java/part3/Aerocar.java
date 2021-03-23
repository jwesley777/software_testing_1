package part3;

public class Aerocar implements IThing {
    private IPassenger passenger;
    private int size;
    public Aerocar(int size) {
        this.size = size;
        passenger = null;
    }
    public boolean putPassenger(IPassenger passenger) {
        if (this.passenger!=null) return false;
        this.passenger = passenger;
        return true;
    }
    public void extractPassenger() {
        this.passenger = null;
    }
    public IPassenger getPassenger() {
        return passenger;
    }

    public int getSize() {
        return size;
    }
}
