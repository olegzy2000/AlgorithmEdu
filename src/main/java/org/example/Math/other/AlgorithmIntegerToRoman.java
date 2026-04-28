package org.example.Math.other;
/*
Семь различных символов представляют римские цифры со следующими значениями:

Symbol	Value
I	1
V	5
X	10
L	50
C	100
D	500
M	1000

Римские цифры образуются путем преобразования десятичных знаков от старшего к младшему. Преобразование десятичного значения в римскую цифру осуществляется по следующим правилам:

Если значение не начинается с 4 или 9, выберите символ максимального значения, которое можно вычесть из входного значения, добавьте этот символ к результату, вычтите полученное значение и преобразуйте остаток в римскую цифру.
Если значение начинается с 4 или 9, используйте  вычитательную форму  , представляющую собой вычитание одного символа из следующего символа, например, 4 на 1 ( I) меньше 5 ( V): IV и 9 на 1 ( I) меньше 10 ( X): IX. Используются только следующие вычитательные формы: 4 ( IV), 9 ( IX), 40 ( XL), 90 ( XC), 400 ( CD) и 900 ( CM).
Только степени числа 10 ( I, X, C, M) можно добавлять последовательно не более 3 раз для представления кратных 10. Нельзя добавлять 5 ( V), 50 ( L) или 500 ( D) несколько раз. Если нужно добавить символ 4 раза, используйте вычитательную форму .
Дано целое число, преобразуйте его в римскую цифру.



Пример 1:

Входные данные: num = 3749

Вывод: "MMMDCCXLIX"

Объяснение:

3000 = MMM, так как 1000 (M) + 1000 (M) + 1000 (M)
 700 = DCC, так как 500 (D) + 100 (C) + 100 (C)
  40 = XL, поскольку 10 (X) меньше 50 (L)
   9 = IX как 1 (I) меньше 10 (X)
Примечание: 49 не на 1 (I) меньше, чем 50 (L), поскольку преобразование основано на десятичных знаках.

 */



import java.util.*;

public class AlgorithmIntegerToRoman {

    private Map<String, Integer> mapCharacters = new LinkedHashMap<>() {{
        put("M", 1000);
        put("CM", 900);
        put("D", 500);
        put("CD", 400);
        put("C", 100);
        put("XC", 90);
        put("L", 50);
        put("XL", 40);
        put("X", 10);
        put("IX", 9);
        put("V", 5);
        put("IV", 4);
        put("I", 1);
    }};

    public String intToRoman(int num) {
        if(num <= 0)
            return "";

        Set<String> keySet = mapCharacters.keySet();
        StringBuilder result = new StringBuilder();
        int currentSum = 0;
        for (String currentSymbol : keySet) {
           int number = mapCharacters.get(currentSymbol);
           while (currentSum + number <= num) {
               currentSum+=number;
               result.append(currentSymbol);
           }
        }
        return result.toString();
    }
    private Map<Character, Integer> romanMap4 = Map.ofEntries(
            Map.entry('I', 1),
            Map.entry('V', 5),
            Map.entry('X', 10),
            Map.entry('L', 50),
            Map.entry('C', 100),
            Map.entry('D', 500),
            Map.entry('M', 1000)
    );
    public int romanToInt(String roman){
        if(roman==null || roman.isEmpty()){
            return 0;
        }
        char romanCharArray[] = roman.toCharArray();
        int result = 0;
        int latestNumber = romanMap4.get(romanCharArray[romanCharArray.length-1]);
        int currentNumber = 0;
        for(int i = romanCharArray.length - 1; i >=0 ; i--){
             currentNumber = romanMap4.get(romanCharArray[i]);
            if(currentNumber < latestNumber){
                result -= currentNumber;
            }
            else{
                result += currentNumber;
            }
            latestNumber = currentNumber;
        }
        return result;
    }
}
