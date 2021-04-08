package ru.khrebtov.lesson7;

import ru.khrebtov.lesson7.anno.AfterSuite;
import ru.khrebtov.lesson7.anno.BeforeSuite;
import ru.khrebtov.lesson7.anno.Test;

public class Main {

    @BeforeSuite
    public void printBefore() {
        System.out.println("Before");
    }

    @Test(priority = 3)
    public void print3() {
        System.out.println("3");
    }

    @Test(priority = 1)
    public void print1() {
        System.out.println("1");
    }

    @Test(priority = 2)
    public void print2() {
        System.out.println("2");
    }

    @AfterSuite
    public void printAfter() {
        System.out.println("After");
    }


}
