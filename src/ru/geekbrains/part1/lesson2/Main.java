package ru.geekbrains.part1.lesson2;

public class Main {

    public static void main(String[] args) {
        //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] task1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < task1.length; i++)
        {
            if (task1[i]==1)
            {
                task1[i]=0;
            }
            else {
                task1[i]=1;
            }
            System.out.print(task1[i] + " ");
        }
        //2. Задать пустой целочисленный массив размером 8.
        // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] task2 = new int[8];
        System.out.println();
        System.out.println();
        for (int i = 0; i<task2.length;i++)
        {
            task2[i] = i*3;
            System.out.print(task2[i] + " ");
        }
        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        // пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] task3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println();
        System.out.println();
        for (int i = 0; i < task3.length; i++)
        {
            if (task3[i]<6)
            {
                task3[i]=task3[i]*2;
            }
            System.out.print(task3[i] + " ");
        }
        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        System.out.println();
        System.out.println();
        int[][] task4 = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i==j)
                {
                    task4[i][j] = 1;
                }
                else
                {
                    task4[i][j] = 0;
                }
                System.out.print(task4[i][j] + " ");
            }
            System.out.println();
        }
        //5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        System.out.println();
        System.out.println();
        int[] task5 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int max = task5[0];
        int min = task5[0];
        for (int i=0; i<task5.length;i++)
        {
            if (task5[i] > max){
                max = task5[i];
            }
            if (task5[i]<min)
            {
                min = task5[i];
            }
        }
        System.out.println("Max "+ max);
        System.out.println("Min "+ min);
        //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
        // checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
        System.out.println();
        int[] task6 = {2, 2, 2, 1, 2, 2, 10, 1};
        boolean result = checkBalance(task6);
        System.out.println(result);
        //7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
        // или отрицательным), при этом метод должен сместить все элементымассива на n позиций.
        // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        System.out.println();
        int[] task7 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i<task7.length;i++)
        {
            System.out.print(task7[i] + " ");
        }
        System.out.println();
        int counter = -3;
        movePosition (task7, counter);
    }
    public static boolean checkBalance(int[] arr)
    {
        int k;
        int j;
        int summLeft = 0;
        int summRight = 0;
        for (k=0;k<arr.length;k++)
        {
            summLeft = summLeft + arr[k];
            if (k<arr.length)
            {
                for (j = (k+1); j<arr.length;j++)
                {
                    summRight = arr[j] + summRight;
                }
                if (summLeft == summRight)
                {
                    return true;
                }
                else
                {
                    summRight = 0;
                }
            }
        }
        return false;
    }
    public static void movePosition (int [] arr, int count)
    {
        int preparedCount;
        if(count != 0){
            if (Math.abs(count) > arr.length)
            {
                preparedCount = Math.abs(count % arr.length);
                if (count < 0)
                {
                    preparedCount = preparedCount * (-1);
                }
            }
            else {
                preparedCount = count;
            }
            if (preparedCount > 0) {
                for (int n = 0; n < preparedCount; n++) {
                    int buffer = arr[0];
                    arr[0] = arr[arr.length - 1];
                    for (int j = 1; j < arr.length - 1; j++) {
                        arr[arr.length - j] = arr[arr.length - j - 1];
                    }
                    arr[1] = buffer;
                }
            }
            else if (preparedCount < 0) {
                for (int i = 0; i > preparedCount; i--) {
                    int buffer = arr[arr.length - 1];
                    arr[arr.length - 1] = arr[0];
                    for (int j = 1; j < arr.length - 1; j++) {
                        arr[j - 1] = arr[j];
                    }
                    arr[arr.length - 2] = buffer;
                }
            }
        }
        for (int k = 0; k<arr.length;k++)
        {
            System.out.print(arr[k] + " ");
        }

    }
}
