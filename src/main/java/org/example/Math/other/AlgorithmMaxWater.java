package org.example.Math.other;

/*Вам дан массив целых чисел heightдлиной n.
Нарисованы nвертикальные линии, конечные точки которых равны и .ith(i, 0)(i, height[i])
Найдите две прямые, которые вместе с осью x образуют контейнер,
так что в этом контейнере содержится наибольшее количество воды.
Верните максимальное количество воды, которое может вместить контейнер .
Обратите внимание , что контейнер нельзя наклонять.

Входные данные: высота = [1,8,6,2,5,4,8,3,7]
Выходные данные: 49
Пояснение: Вертикальные линии на изображении выше представлены массивом [1,8,6,2,5,4,8,3,7].
В этом случае максимальная площадь воды (синяя секция), которую может вместить контейнер, составляет 49.
Пример 2:

Входные данные: высота = [1,1]
Выходные данные: 1


Ограничения:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104*/

public class AlgorithmMaxWater {
    public int start(int[] heigths){
        if(heigths==null || heigths.length==0 || heigths.length==1){
            return 0;
        }
        int leftBorderIndex = 0;
        int rightBorderIndex = heigths.length - 1;
        int maxValue = -1;
        while (leftBorderIndex < rightBorderIndex){
            int maxHeight = Math.min(heigths[leftBorderIndex], heigths[rightBorderIndex]);
            int length = rightBorderIndex - leftBorderIndex;
            int newVolume = maxHeight * length;
            if (maxValue < newVolume) {
                maxValue = newVolume;
            }

            if (heigths[leftBorderIndex] > heigths[rightBorderIndex]) {
                rightBorderIndex--;
            }
            else{
                leftBorderIndex++;
            }

        }

        return maxValue;
    }
}
