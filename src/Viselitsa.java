import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Viselitsa {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Начать новую игру - отправьте \"Поехали\"\nЗакончить игру - отправьте \"Стоп\".");
        String answer = in.nextLine();

        String[] words = {"ЛОГИКА", "ЛОГАРИФМ", "КУЛЬТУРА", "СПОКОЙСТВИЕ", "НАСЫЩЕННСОСТЬ"};

        Random r = new Random();
        int random_index_array_word = r.nextInt(words.length);
        String hidden_word = words[random_index_array_word];

        if (answer.equalsIgnoreCase("Поехали") || answer.equals("поехали") || answer.equals("1")) {

            System.out.println("Начинается игра...");
            String[] letter_arr = new String[hidden_word.length()];
            for (int i = 0; i < letter_arr.length; i++) {
                letter_arr[i] = "_";
                System.out.print(letter_arr[i] + " ");
            }

            int mistakes = 0;
            ArrayList<String> entered_letters = new ArrayList<>();

            do {
                System.out.println("\nВведите букву: ");
                String suggest_letter = in.nextLine().toUpperCase();

                boolean alreadyEntered = false;
                for (String letter : entered_letters) {
                    if (suggest_letter.equals(letter)) {
                        alreadyEntered = true;
                        break;
                    }
                }
                if (alreadyEntered) {
                    System.out.println("Данная буква уже была использована ранее, введите другую букву.");
                } else {
                    entered_letters.add(suggest_letter);
                    boolean guessed_correctly = false;
                    for (int i = 0; i < hidden_word.length(); i++) {
                        if (suggest_letter.equals(String.valueOf(hidden_word.charAt(i)))) {
                            letter_arr[i] = suggest_letter.toUpperCase();
                            guessed_correctly = true;
                        }
                    }
                    if (!guessed_correctly) {
                        mistakes++;
                        Mistake(mistakes);
                        if (mistakes == 5) {
                            break;
                        }
                    }
                    for (String letter : letter_arr) {
                        System.out.print(letter + " ");
                    }
                }
            } while (!isWordGuessed(letter_arr));

            if (isWordGuessed(letter_arr)) {
                System.out.println("\nВы отгадали слово. Конец игры.");
            } else {
                System.out.println("\nВы проиграли.");
            }
        } else if (answer.equalsIgnoreCase("Стоп")) {
            System.out.println("Выход.");
        }
    }

    public static void Mistake(int number_of_errors) {
        switch (number_of_errors) {
            case 1:
                System.out.println("|     |\n|     |\n|     O\n|\n|\n|\n|\n___________");
                System.out.println("Вы истратили 1/5 попыток.");
                break;
            case 2:
                System.out.println("|     |\n|     |\n|     O\n|     |\n|     |\n|\n|\n___________");
                System.out.println("Вы истратили 2/5 попыток.");
                break;
            case 3:
                System.out.println("|     |\n|     |\n|     O\n|    /|\n|     |\n|\n|\n___________");
                System.out.println("Вы истратили 3/5 попыток.");
                break;
            case 4:
                System.out.println("|     |\n|     |\n|     O\n|    /|\\\n|     \n|\n|\n___________");
                System.out.println("Вы истратили 4/5 попыток.");
                break;
            case 5:
                System.out.println("|     |\n|     |\n|     O\n|    /|\\\n|    / \\\n|\n|\n___________");
                System.out.println("Вы истратили 5/5 попыток. Конец игры.");
                break;
            default:
                System.out.println("Неизвестное количество ошибок.");
        }
    }

    public static boolean isWordGuessed(String[] letters) {
        for (String letter : letters) {
            if (letter.equals("_")) {
                return false;
            }
        }
        return true;
    }
}
