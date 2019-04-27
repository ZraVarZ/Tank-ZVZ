package view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.TankModel;

public class Tank {
    private Pane tankPane = new Pane();
    private TankModel tank;

    public Tank(int pozX, int pozY) {
        this.tank = new TankModel(pozX, pozY);
    }

    public Pane getTankPane() {
        return tankPane;
    }

    public TankModel getTank() {
        return tank;
    }
}
