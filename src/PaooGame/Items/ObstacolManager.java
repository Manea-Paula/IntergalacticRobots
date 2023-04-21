package PaooGame.Items;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ObstacolManager {

    private static ObstacolManager instance;

    private List<Obstacol> obstacole = new ArrayList<Obstacol>();

    private ObstacolManager() {
        // Constructorul privat pentru a asigura crearea unei singure instanțe a acestei clase
    }

    public static ObstacolManager getInstance() {
        if (instance == null) {
            instance = new ObstacolManager();
        }
        return instance;
    }

    public void addObstacle(Obstacol obstacol) {
        obstacole.add(obstacol);
    }

    public void removeObstacle(Obstacol obstacol) {
        obstacole.remove(obstacol);
    }

    public void updateObstacles() {
        for (Obstacol obstacol : obstacole) {
            obstacol.Update();
        }
    }

    public void drawObstacles(Graphics g) {
        for (Obstacol obstacol : obstacole) {
            obstacol.Draw(g);
        }
    }

}
