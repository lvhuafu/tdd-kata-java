package org.coach.tdd.template;

/**
 * Created by 41988 on 2017/6/3.
 */
public class LifeGame {
    public boolean caluate(int aliveCount, GameCell cell) {
        boolean result = false;
        if (aliveCount == 3) {
            result = true;
        }
        if (aliveCount == 2) {
            result = cell.getStatus();
        }
        return result;
    }

    public boolean getStatus(GameCell cell) {
        return cell.getStatus();
    }
}
