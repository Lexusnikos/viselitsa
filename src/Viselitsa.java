import java.sql.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Viselitsa {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Начать новую игру - отправьте \"Поехали\"\nЗакончить игру - отправьте \"Стоп\".");
        String answer = in.nextLine();

        String[] words = new String[5];
        words[0] = "ЛОГИКА";
//            words[1] = "ЛОГАРИФМ";
//            words[2] = "КУЛЬТУРА";
//            words[3] = "СПОКОЙСТВИЕ";
//            words[4] = "НАСЫЩЕННСОСТЬ";

//            Random r = new Random();
//
//            int random_index_array_word = r.nextInt(words.length);
//            String hidden_word = words[random_index_array_word];
        String hidden_word = words[0];


        if (answer.equals("Поехали") || answer.equals("поехали") || answer.equals("1")) {


            System.out.println("Начинается игра...");
            String[] letter_arr = new String[hidden_word.length()];
            for (int i = 0; i < letter_arr.length; i++) {
                letter_arr[i] = "_";
                System.out.print(letter_arr[i] + " ");
            }
            int guessed_letters = 0;
            int mistakes = 0;
//                    String[] entered_letters = new String[] {};

            ArrayList<String> entered_letters = new ArrayList<String>();
            StringBuilder result = new StringBuilder();
            do {
                System.out.println("\nВведите букву: ");
                String suggest_letter = in.nextLine().toUpperCase();

                boolean alreadyEntered = false;
                for (int i = 0; i < entered_letters.size(); i++) {
                    if (suggest_letter.equals(entered_letters.get(i))) {
                        alreadyEntered = true;
                        break;
                    }
                }
                if (alreadyEntered) {
                    System.out.println("Данная буква уже была использована ранее, введите другую букву.");
                } else {
                    entered_letters.add(suggest_letter);
                    for (int i = 0; i < hidden_word.length(); i++) {
                        if (suggest_letter.equals(String.valueOf(hidden_word.charAt(i)))) {
                            guessed_letters++;
                            letter_arr[i] = suggest_letter.toUpperCase();
                            System.out.print(letter_arr[i] + " ");
                            result.append(letter_arr[i]);
                        } else if (!suggest_letter.equals(String.valueOf(hidden_word.charAt(i)))) {
                            System.out.print(letter_arr[i] + " ");
                        }
                    }
                    if (guessed_letters == 0) {
                        mistakes++;
                        Mistake(mistakes);
                        if (mistakes == 5) {
                            break;
                        }
                    }
                }
            }
            while (guessed_letters != letter_arr.length);

            if (result.toString().equals(hidden_word)) {
                System.out.println("\nВы отгадали слово. Конец игры.");
            } else {
                System.out.println("\nВы проиграли.");
            }


        } else if (answer.equals("Стоп") || answer.equals("стоп")) {
            System.out.print("Выход.");
        }

    }

    public static void Mistake(int number_of_errors) {
        if (number_of_errors == 1) {
            System.out.print("|     |\n|     |\n|     O\n|\n|\n|\n|\n");
            System.out.println("___________");
            System.out.println("Вы истратили 1/5 попыток.");
        } else if (number_of_errors == 2) {
            System.out.print("|     |\n|     |\n|     O\n|     |\n|     |\n|\n|\n|\n");
            System.out.println("___________");
            System.out.println("Вы истратили 2/5 попыток.");
        } else if (number_of_errors == 3) {
            System.out.print("|     |\n|     |\n|     O\n|    /|\n|     |\n|\n|\n|\n");
            System.out.println("___________");
            System.out.println("Вы истратили 3/5 попыток.");
        } else if (number_of_errors == 4) {
            System.out.print("|     |\n|     |\n|     O\n|    /|\\\n|     \n|\n|\n|\n");
            System.out.println("___________");
            System.out.println("Вы истратили 4/5 попыток.");
        } else if (number_of_errors == 5) {
            System.out.print("|     |\n|     |\n|     O\n|    /|\\\n|    / \\\n|\n|\n|\n");
            System.out.println("___________");
        }
    }
}