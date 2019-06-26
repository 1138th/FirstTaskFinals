package Task1B;

import java.util.HashMap;
import java.util.Map;

public class Task1B extends ListWork {

    public static void TaskB() {
        System.out.println("we will create list of strings and sort them by counts of vowels in strings\n" +
                "command \"exit\" will end strings-reading\n" +
                "now enter list:");
        Map<Integer, String> list = new HashMap<Integer, String>();
        list = CreateList();
        SortList(list);
        PrintList(list);
    }
}
