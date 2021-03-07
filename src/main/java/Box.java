import fruit.Apple;
import fruit.Fruit;
import java.util.ArrayList;

public class Box<T extends Fruit> {

  private ArrayList<T> arr;

  public Box() {
    arr = new ArrayList<>();
  }


  public float getWeight() {
    if (arr.size() == 0) {
      return 0.0f;
    }
    if (arr.get(0) instanceof Apple) {
      return arr.size() * 1.0f;
    }
    return arr.size() * 1.5f;
  }

  public boolean compare(Box<?> newBox) {
    return Math.abs(this.getWeight() - newBox.getWeight()) < 0.0001;
  }

  public void addFruit(T fruit) {
    arr.add(fruit);
  }

  public void pourOver(Box<? super T> recipientBox) {
    if(recipientBox==this){
      return;
    }
    recipientBox.arr.addAll(this.arr);
    arr.clear();
  }

}
