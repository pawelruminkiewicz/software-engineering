package pl.put.poznan.transformer.logic;

/**
 * Class represents alert for heating power limit
 */

public class Alert {

    float alertPoint;

    /**
     * Constructor of the class
     * @param build building for that we check alert
     */

    public Alert(Building build) {
        this.alertPoint = build.getAlertPoint();
    }


    /**
     * Method sets alert for room if heating of this room is higher than limit
     * @param room room where limit will be checked
     */
    public void calculate(Room room) {
        float energy = room.getHeating();
        if (alertPoint < energy) {
            room.setAlerted(true);
            return;
        } else {
            room.setAlerted(false);
            return;
        }
    }
}


