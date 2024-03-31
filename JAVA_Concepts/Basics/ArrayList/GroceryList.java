import java.util.Arrays;
import java.util.ArrayList;

record GroceryItem(String name, String type, int count) {

    // default value
    public GroceryItem(String name) {
        this(name, "DIARY", 1);
    }

    @Override
    public String toString() {
        return String.format("%d %s in %s", count,name.toUpperCase(), type);
    }
}

public class GroceryList {
    public static void main(String[] args) {
        // code.1
        Object[] groceryArray = new Object[3];
        groceryArray[0] = new GroceryItem("milk");
        groceryArray[1] = new GroceryItem("apples", "PRODUCE", 6);
        groceryArray[2] = "apple";
        System.out.println(Arrays.toString(groceryArray));

        // code.2 , change groceryArray2 Object to GroceryItem, and the compiler will
        // check the error element.
        Object[] groceryArray2 = new GroceryItem[3];
        groceryArray2[0] = new GroceryItem("milk");
        groceryArray2[1] = new GroceryItem("apples", "PRODUCE", 6);
//        groceryArray2[2] = "apple";
        System.out.println(Arrays.toString(groceryArray2));

        ArrayList objectList = new ArrayList();
        objectList.add(new GroceryItem("Buffer"));
        // This will run warning because with not directly declare the type,
        // but it still could run.
        objectList.add("Yogurt");

        // The diamond operator can let java infer the type.
        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Buffer"));
        groceryList.add(new GroceryItem("milk"));
        groceryList.add(0, new GroceryItem("apples", "PRODUCE", 6));
        groceryList.addFirst(new GroceryItem("pineapple", "PRODUCE", 6));
        groceryList.remove(1);
        // This line will return error
        // groceryList.add("Yogurt");
        System.out.println(groceryList);

    }
}
