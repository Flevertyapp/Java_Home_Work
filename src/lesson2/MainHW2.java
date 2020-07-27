package lesson2;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Random;
import java.util.Scanner;

public class MainHW2 {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        //Задание 2
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String guessWord;
        int randomIndex = random.nextInt(words.length);
        guessWord = words[randomIndex];
        System.out.println(guessWord);
        String userWord;
        userWord = scanner.nextLine();
        String str = "";
        for (int i = 0; i < guessWord.length(); i++) {
            char char1 = guessWord.charAt(i);
            char char2 = userWord.charAt(i);
            if (char1 == char2) {
                str += char1;
            } else {
                str += '#';
            }
        }
        for (int i = 0; i < 15; i++) {
            str += '#';
        }
        System.out.println(str);

        //Задание 1
        System.out.println("Настало время сыграть в игру! Твоя задача угадать число.");
        playGuess();
        System.out.println("Хочешь сыграть еще раз? Введи 1 для повторения, 0 чтобы закончить");
        int game = scanner.nextInt();
        for (; ; ) {
            if (game == 1) {
                playGuess();
            } else {
                break;
            }


        }


        scanner.close();


    }


    public static void playGuess() {
        int number = random.nextInt(10);
        for (int i = 0; i <= 2; i++) {
            System.out.println("Учадайте число от 0 до 10, самое время его ввести");
            int input_number = scanner.nextInt(); //читываем введенное число
            if (input_number == number) {
                System.out.println("Ай кросаучег! Угадаль!!!");
                break;
            } else if (input_number > number) {
                System.out.println("Число-то загаданное поменьше будет!!!");
            } else {
                System.out.println("Число-то загаданное побольше будет!!!");
            }
        }
    }
}
