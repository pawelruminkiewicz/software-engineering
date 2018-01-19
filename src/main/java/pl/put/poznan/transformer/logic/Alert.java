package pl.put.poznan.transformer.logic;


public class Alert {

    float alertPoint;

    public Alert(Building build) {
        this.alertPoint = build.getAlertPoint();
    }


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


