import fruit.Apple;
import fruit.Orange;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    Integer[] arrInt = new Integer[]{1, 2, 3};
    Float[] arrFloat = new Float[]{0.0f, 1.2f, 3.0f};
    String[] arrString = new String[]{"ABC", "CDE", "FGH"};
    swap(arrInt, 0, 2);
    swap(arrFloat, 0, 2);
    swap(arrString, 0, 2);

    ArrayList<Float> strings = intoArrayList(arrFloat);
    System.out.println(strings.getClass().getName());

    Apple apple = new Apple();
    Orange orange = new Orange();
    Box<Orange> orangeBox = new Box<>();
    Box<Apple> appleBox = new Box<>();
    appleBox.addFruit(apple);
    appleBox.addFruit(new Apple());
    appleBox.addFruit(new Apple());
    orangeBox.addFruit(orange);
    orangeBox.addFruit(orange);
    System.out.println(appleBox.getWeight());
    System.out.println(orangeBox.getWeight());
    System.out.println(appleBox.compare(orangeBox));
    Box<Apple> newAppleBox = new Box<>();
    newAppleBox.addFruit(apple);
    System.out.println("Вес новой коробки до пересыпания: " + newAppleBox.getWeight());
    appleBox.pourOver(newAppleBox);
    System.out.println("Вес новой коробки после пересыпания: " + newAppleBox.getWeight());
    System.out.println("Вес старой коробки после пересыпания: " + appleBox.getWeight());

  }

  public static <T> void swap(T[] arr, int firstElementIndex, int secondElementIndex) {
    if (firstElementIndex >= 0 && firstElementIndex < arr.length && secondElementIndex >= 0
        && secondElementIndex < arr.length) {
      T memory = arr[firstElementIndex];
      arr[firstElementIndex] = arr[secondElementIndex];
      arr[secondElementIndex] = memory;
      System.out.println(Arrays.toString(arr));
    } else {
      System.out.println("Индексы выходят за пределы массива");
    }
  }

  public static <T> ArrayList<T> intoArrayList(T[] arr) {
    return new ArrayList<>(Arrays.asList(arr));
  }


}
