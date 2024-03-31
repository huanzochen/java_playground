import java.util.List;
import java.util.ArrayList;

public class MoreLists {

    public static void main(String[] args) {
        String[] items = {"apples", "bananas", "milk", "eggs"};

        List<String> list = List.of(items);
        System.out.println("list:" + list);

//        list.add("pineapple");
        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("yogurt");
        System.out.println("groceries:" + groceries);

        ArrayList<String> groceries2 = new ArrayList<>(List.of("pickles, mustard, pineapple"));
        groceries.addAll(1,groceries2);
        System.out.println("groceries + groceries2:" + groceries);
    }
}
