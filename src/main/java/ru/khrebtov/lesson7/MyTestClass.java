package ru.khrebtov.lesson7;
//Создать класс, который может выполнять «тесты», в качестве тестов выступают классы с наборами методов
// с аннотациями @Test. Для этого у него должен быть статический метод start(), которому в качестве параметра
// передается или объект типа Class, или имя класса. Из «класса-теста» вначале должен быть запущен метод
// с аннотацией @BeforeSuite, если такой имеется, далее запущены методы с аннотациями @Test, а по завершению
// всех тестов – метод с аннотацией @AfterSuite. К каждому тесту необходимо также добавить приоритеты
// (int числа от 1 до 10), в соответствии с которыми будет выбираться порядок их выполнения, если приоритет
// одинаковый, то порядок не имеет значения. Методы с аннотациями @BeforeSuite и @AfterSuite должны
// присутствовать в единственном экземпляре, иначе необходимо бросить RuntimeException при запуске «тестирования».

import ru.khrebtov.lesson7.anno.AfterSuite;
import ru.khrebtov.lesson7.anno.BeforeSuite;
import ru.khrebtov.lesson7.anno.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MyTestClass {
    public static void main(String[] args) {
        start(Main.class);
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
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                countBeforeAno++;
            }
            if (m.isAnnotationPresent(Test.class) || m.isAnnotationPresent(BeforeSuite.class) ||
                    m.isAnnotationPresent(AfterSuite.class)) {
                methodsForTest.put(m, m.getAnnotation(Test.class).priority());
            }
        }
        if (countAfterAno > 1 || countBeforeAno > 1) {
            throw new RuntimeException(" анотаций AfterSuit||BeforeSuit в классе больше 1");
        }
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
