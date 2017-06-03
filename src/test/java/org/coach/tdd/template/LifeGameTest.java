package org.coach.tdd.template;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static junit.framework.TestCase.assertTrue;


import org.junit.Test;

/**
 * Created by 41988 on 2017/6/3.
 */
public class LifeGameTest {
    @Test
    public void shouldAliveWhenAroundAliveIsThree() throws Exception {
        LifeGame lifegame = new LifeGame();
        GameCell cell = new GameCell();
        assertTrue(lifegame.caluate(3, cell));
    }

    @Test
    public void shouldNotChangeWhenAliveIsTwo() throws Exception {
        LifeGame lifegame = new LifeGame();
        GameCell cell = new GameCell();
        assertThat(lifegame.caluate(2, cell), is(lifegame.getStatus(cell)));
    }
}
