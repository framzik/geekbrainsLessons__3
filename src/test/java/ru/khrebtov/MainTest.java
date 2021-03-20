package ru.khrebtov;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class MainTest {

    private Main main;

    @Before
    public void init() {
        main = new Main();
    }

    @Test
    public void afterFor1() {
        Assert.assertArrayEquals(new int[]{1, 7}, main.afterFor(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }

    @Test
    public void afterFor2() {
        Assert.assertArrayEquals(new int[]{1, 7, 5, 1}, main.afterFor(new int[]{4, 4, 2, 3, 4, 1, 7, 5, 1}));
    }

    @Test
    public void afterFor3() {
        Assert.assertArrayEquals(new int[]{}, main.afterFor(new int[]{1, 2, 4, 4}));
    }

    @Test(expected = RuntimeException.class)
    public void afterFor4() {
        main.afterFor(new int[]{7, 5, 1});
    }

    @Test
    public void isHaveSomeNumbers() {
        Assert.assertTrue(main.isHaveSomeNumbers(new int[]{1, 1, 1, 4, 4, 1, 4, 4}));
    }

    @Test
    public void isHaveSomeNumbers2() {
        Assert.assertFalse(main.isHaveSomeNumbers(new int[]{1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void isHaveSomeNumbers3() {
        Assert.assertFalse(main.isHaveSomeNumbers(new int[]{4, 4, 4, 4, 4, 4}));
    }

    @Test
    public void isHaveSomeNumbers4() {
        Assert.assertFalse(main.isHaveSomeNumbers(new int[]{1, 4, 4, 1, 1, 4, 3}));
    }
}