package org.coach.tdd.template;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 41988 on 2017/6/3.
 */
public class LifeGameTest {
    @Test
    public void ShouldAliveWhenAroundAliveIsThree() throws Exception {
        LifeGame lifegame = new LifeGame();
        assertTrue(lifegame.caluate(3));
    }
}