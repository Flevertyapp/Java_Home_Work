package lesson2;

import java.util.Arrays;
import java.util.Random;

public class MainHW2 {
    public static void main(String[] args) {

        //Задание 1
        System.out.println("Задание 1");
        int [] arr = {0, 1, 1, 0, 0, 1, 1, 0, 1, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0) {
                arr[i]++;
            } else {
                arr[i]--;
            }
        }

        //Задание 2
        System.out.println("Задание 2");
        int [] arr2 = new int [8];
        arr2[1] = 1;
        for (int i = 1; i < arr2.length; i++) {
            arr2[i] = i * 3;
        }

        //Задание 3
        System.out.println("Задание 3");
        int [] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] = arr3[i] * 2;
            }
        }

        //Задание 4
        System.out.println("Задание 4");
        int n = 10;   //наверное не совсем корректно объявлять n здесь? Надо выносить в начало main?
        int [] [] arr4 = new int [n] [n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || (i+j == n-1)){
                    arr4[i] [j] = 1;
                }
                System.out.printf("%3d", arr4[i][j]);
            }
            System.out.println();
        }

        randomArray(10);
        int newArr [] = randomArray(n);
        int max = 0;
        int min = 0;
        for (int i = 0; i < newArr.length; i++) {
                if (max < newArr[i]){
                    max = newArr[i];
            }
                if (min > newArr[i]){
                    min = newArr[i];
                }
        }
            System.out.println("Максимальное значение в массиве- " + max);
            System.out.println("Минимальное значение в массиве- " + min);

        //Заднаие 6 не осилил, запутался в методе, буду благодарен если укажете, где ошибка
        boolean resultFinal = true;
        resultFinal = checkBalance(n);
        System.out.println(resultFinal);
        }

        //Задание 7 сделаю после урока


    //генератор рандомного массива
    public static int [] randomArray (int n){
    Random random = new Random();
    int [] randomArr = new int [n];
        for (int i = 0; i < randomArr.length ; i++) {
        randomArr[i] = random.nextInt(20) -10;
    }
        System.out.println(Arrays.toString(randomArr));
        return randomArr;

    }

    //метод задание 6
    public static boolean checkBalance(int n) {
        boolean result = true;
        int sumLeft = 0;
        int sumRight = 0;
        randomArray(10);
        int checkArr[] = randomArray(n);
        for (int i = 0; i < checkArr.length; i++)
            for (int j = checkArr.length; j >= 0 ; j--) { //так и не смог прописать условие. Либо вылетаю за пределы, либо не захожу
                sumLeft = sumLeft + checkArr[i];
                sumRight = sumRight + checkArr[j];
                if (sumLeft == sumRight) {
                    result = true;
                } else {
                    result = false;
                }
            }
        System.out.println(Arrays.toString(checkArr));
        return result;
    }




}
