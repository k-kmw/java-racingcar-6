package racingcar.model;

public class Car {

    private final String name;
    private StringBuilder track;

    public Car(String name) {
        this.name = name;
        this.track = new StringBuilder();
    }

    public String getName() {
        return name;
    }

    public StringBuilder getTrack() {
        return track;
    }

    public void tryMove(int randomNum) {
        if (randomNum >= 4) {
            track.append("-");
        }
    }
}
