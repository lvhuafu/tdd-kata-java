package org.coach.tdd.template;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by 41988 on 2017/6/3.
 */
public class GameCellTest {
    GameCell cell;
    @Test
    public void testGetStatus() throws Exception {
        cell = new GameCell();
        assertThat(cell.getStatus(),is(false));
        cell.setSatus(true);
        assertThat(cell.getStatus(),is(true));
    }

    @Test
    public void testSetSatus() throws Exception {
        cell = new GameCell();
        cell.setSatus(true);
        assertThat(cell.getStatus(),is(true));
        cell.setSatus(false);
        assertThat(cell.getStatus(),is(false));
    }

    @Test
    public void testGetX() throws Exception {
        cell = new GameCell(1,1);
        assertThat(cell.getX(),is(1));
    }

    @Test
    public void testGetY() throws Exception {
        cell = new GameCell(1,1);
        assertThat(cell.getY(),is(1));
    }
}