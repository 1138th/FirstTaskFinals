package Task1B;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ListWork {

    private static Scanner scan = new Scanner(System.in);
    public static char[] vowelsPpool = {'A', 'E', 'I', 'O', 'U', 'Y', 'a', 'e', 'i', 'o', 'u', 'y',
            'А', 'Е', 'Ё', 'И', 'О', 'У', 'Ы', 'Э', 'Ю', 'Я', 'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я'};

    static Map<Integer, String> CreateList(){
        Map<Integer, String> list = new HashMap<Integer, String>();
        String string;
        int index = 0;
        do {
            string = scan.nextLine();
            if (!string.equals("exit"))
                list.put(index++, string);
        } while (!string.equals("exit"));
        return list;
    }

    private static int StringIntegers(String string){
        int count = 0;
        char[] stringArray = string.toCharArray();
        for (int i = 0; i < stringArray.length; i++){
            for (int j = 0; j < vowelsPpool.length; j++){
                if (stringArray[i] == vowelsPpool[j]){
                    count++;
                }
            }
        }
        return count;
    }

    static void SortList(Map<Integer, String> list){
        String reserveString;
        for (int i = 0; i < list.size(); i++){
            for (int j = i + 1; j < list.size(); j++){
                if (StringIntegers(list.get(i)) > StringIntegers(list.get(j))){
                    reserveString = list.get(i);
                    list.put(i, list.get(j));
                    list.put(j, reserveString);
                }
            }
        }
    }

    static void PrintList(Map<Integer, String> list){
        for (Map.Entry<Integer, String> item : list.entrySet()){
            System.out.println((item.getKey() + 1) + ": " + item.getValue());
        }
    }
}
