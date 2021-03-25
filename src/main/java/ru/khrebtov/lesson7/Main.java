package ru.khrebtov.lesson7;

import ru.khrebtov.lesson7.anno.AfterSuite;
import ru.khrebtov.lesson7.anno.BeforeSuite;
import ru.khrebtov.lesson7.anno.Test;

public class Main {
    //Создать класс, который может выполнять «тесты», в качестве тестов выступают классы с наборами методов
// с аннотациями @Test. Для этого у него должен быть статический метод start(), которому в качестве параметра
// передается или объект типа Class, или имя класса. Из «класса-теста» вначале должен быть запущен метод
// с аннотацией @BeforeSuite, если такой имеется, далее запущены методы с аннотациями @Test, а по завершению
// всех тестов – метод с аннотацией @AfterSuite. К каждому тесту необходимо также добавить приоритеты
// (int числа от 1 до 10), в соответствии с которыми будет выбираться порядок их выполнения, если приоритет
// одинаковый, то порядок не имеет значения. Методы с аннотациями @BeforeSuite и @AfterSuite должны
// присутствовать в единственном экземпляре, иначе необходимо бросить RuntimeException при запуске «тестирования».
    @BeforeSuite
    public void printBefore() {
        System.out.println("Before");
    }

    @Test(priority = 2)
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
