package org.coach.tdd.template;

/**
 * Created by 41988 on 2017/6/3.
 */
public class GameCell {
    private boolean isAlive = false;
    private int x = 0;
    private int y = 0;

    public GameCell(int i, int j) {
        x = i;
        y = j;
    }

    public GameCell() {
    }

    public boolean getStatus() {
        return isAlive;
    }

    public void setSatus(boolean status) {
        isAlive = status;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }
}
