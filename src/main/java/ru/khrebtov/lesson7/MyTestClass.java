package ru.khrebtov.lesson7;

import ru.khrebtov.lesson7.anno.AfterSuite;
import ru.khrebtov.lesson7.anno.BeforeSuite;
import ru.khrebtov.lesson7.anno.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MyTestClass {
    public static void main(String[] args) {
//        start(Main.class);
        start("ru.khrebtov.lesson7.Main");
    }

    public static void start(Class c) {
        if (c == null) {
            throw new IllegalArgumentException("Class не может быть null");
        }

        int countBeforeAno = 0;
        int countAfterAno = 0;
        Map<Method, Integer> methodsForTest = new HashMap<>();
        Method[] methods = c.getDeclaredMethods();

        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                countAfterAno++;
                methodsForTest.put(m, Integer.MIN_VALUE);
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                countBeforeAno++;
                methodsForTest.put(m, Integer.MAX_VALUE);
            }
            if (m.isAnnotationPresent(Test.class)) {
                methodsForTest.put(m, m.getAnnotation(Test.class).priority());
            }
        }

        if (countAfterAno > 1 || countBeforeAno > 1) {
            throw new RuntimeException(" анотаций AfterSuit||BeforeSuit в классе больше 1");
        }

        methodsForTest.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(methodIntegerEntry -> {
                    try {
                        methodIntegerEntry.getKey().invoke(c.newInstance());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                });
    }

    public static void start(String className) {
        Class c = null;
        try {
            c = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        start(c);
    }
}
