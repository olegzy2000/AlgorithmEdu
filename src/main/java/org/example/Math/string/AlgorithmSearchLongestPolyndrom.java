package org.example.Math.string;
/*
 задача найди наибольший полиндром в строке
 примеры:
 входи: aba = aba
 входи: ccc = ccc

Решение 1
Полиндром подразумевает что у строки есть определенный центр при нечетном количестве элементов
относительно которого символы слева и справа будут зеркалиться
или полностью зеркальный без центра
мы идем итеративно и проверяем каждый символ за центральный относительно
его идем влево и вправо проверяем на совпадение символов и запоминаем наибольший полиндром


Решение 2
Используем алгоритм Манакера: он хранит радиусы палиндромов в массиве P,
а также поддерживает C — центр палиндрома с максимальной правой границей и R — эту правую границу.
Для позиции i, если i < R, берём зеркальную позицию mir = 2*C - i.
Тогда начальный радиус P[i] можно сразу установить как min(R - i, P[mir])
без сравнений внутри [L..R]. После этого выполняем ручное расширение,
сравнивая символы за пределами известной области, чтобы попытаться увеличить P[i].
*/


import java.util.Arrays;

public class AlgorithmSearchLongestPolyndrom {

 public static String searchLongestPolyndrom(String input){
     String newInput = addSeparators(input);
     char[] currentCharArray = newInput.toCharArray();
     String result = "";
     for(int i=0; i<currentCharArray.length; i++){
         String resultFirstVariant = checkFirstVariant(currentCharArray,i);
         if(resultFirstVariant.length()>result.length()){
             result = resultFirstVariant;
         }
     }
     return result.replaceAll("#","");
 }
    public static String searchLongestPolyndromManaker(String input){
        String newInput = addSeparators(input);
        char[] currentCharArray = newInput.toCharArray();
        int[] radiusArray = new int[currentCharArray.length];
        Arrays.fill(radiusArray,0);
        int centerIndex = -1;
        int rightBorder = -1;
        String result = "";
        int startedOffset = 0;
        for(int i=0; i<currentCharArray.length; i++){
            String resultFirstVariant;
            int mirrorIndex = -1;
            if (centerIndex>-1
                    && rightBorder>-1
                    && i >= centerIndex
                    && i <= rightBorder) {
                mirrorIndex = 2*centerIndex - i ;
                if(mirrorIndex>=0 && mirrorIndex<currentCharArray.length) {
                    radiusArray[i] = Math.min(rightBorder - i, radiusArray[mirrorIndex]);
                    startedOffset = radiusArray[i];
                }
            }

            resultFirstVariant = checkManagerVariant(currentCharArray,i,startedOffset);
            radiusArray[i]=resultFirstVariant.length()/2;

            if(radiusArray[i]>2){
                centerIndex = i;
                rightBorder = centerIndex+radiusArray[i];
            }

            if (resultFirstVariant.length() > result.length()) {
                result = resultFirstVariant;
            }
        }
        return result.replaceAll("#","");
    }


    private static String checkFirstVariant(char[] currentCharArray, int i) {
       StringBuilder currentPolyndrom = new StringBuilder();
       currentPolyndrom.append(currentCharArray[i]);
       int leftStep = i-1;
       int rightStep = i+1;
       while (leftStep>=0 && rightStep<currentCharArray.length){
           if(currentCharArray[leftStep]==currentCharArray[rightStep]){
               currentPolyndrom.insert(0,currentCharArray[leftStep]);
               currentPolyndrom.append(currentCharArray[rightStep]);
           }
           else{
               return currentPolyndrom.toString();
           }


           leftStep--;
           rightStep++;
       }
       return currentPolyndrom.toString();
    }
    private static String checkManagerVariant(char[] currentCharArray, int center, int startedOffset) {
        StringBuilder currentPolyndrom = new StringBuilder();
        currentPolyndrom.append(currentCharArray[center]);
        int leftStep = center - startedOffset;
        int rightStep = center + startedOffset;
        if(leftStep!=rightStep) {
            if (leftStep >= 0) {
                int current = center-1;
                while (current >= leftStep){
                    currentPolyndrom.insert(0, currentCharArray[current]);
                    current--;
                }
            }
            if (rightStep < currentCharArray.length) {
                int current = center+1;
                while (current <= rightStep){
                    currentPolyndrom.append(currentCharArray[current]);
                    current++;
                }
            }
        }
        leftStep--;
        rightStep++;
        while (leftStep>=0 && rightStep<currentCharArray.length) {
            if(currentCharArray[leftStep]==currentCharArray[rightStep]){
                currentPolyndrom.insert(0,currentCharArray[leftStep]);
                currentPolyndrom.append(currentCharArray[rightStep]);
            }
            else{
                return currentPolyndrom.toString();
            }

            leftStep--;
            rightStep++;
        }
        return currentPolyndrom.toString();
    }
    public static String addSeparators(String s) {
        if (s == null || s.isEmpty()) return "#";
        StringBuilder sb = new StringBuilder(s.length() * 2 + 1);
        sb.append('#');
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append('#');
        }
        return sb.toString();
    }
}
