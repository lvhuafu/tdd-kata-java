package org.coach.tdd.template;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;


import org.junit.Before;
import org.junit.Test;

/**
 * Created by 41988 on 2017/6/3.
 */
public class LifeGameTest {
    private LifeGame lifegame;
    private GameCell cell;

    @Before
    public void setUp() throws Exception {
        lifegame = new LifeGame();
        cell = new GameCell();
    }

    @Test
    public void shouldAliveWhenAroundAliveIsThree() throws Exception {
        assertTrue(lifegame.nextStatus(3, cell));
    }

    @Test
    public void shouldNotChangeWhenAliveIsTwo() throws Exception {
        assertThat(lifegame.nextStatus(2, cell), is(lifegame.getStatus(cell)));
    }

    @Test
    public void shouldDeadWhenAliveIsNotThreeOrTwo() throws Exception {
        assertFalse(lifegame.nextStatus(5, cell));
    }

    @Test
    public void shouldReturnRightAliveNum() throws Exception {
        assertThat(lifegame.caluteAlives(cell, new ChessBoard(8, 8)), is(0));
    }
}
