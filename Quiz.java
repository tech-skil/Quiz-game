import java.util.Arrays;
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {

        String[][] indiaBusinessQuestionsAndAnswers = {
            {"Which Indian city is known as the 'IT capital of India'?", "Mumbai", "Hyderabad", "Bangalore", "Chennai", "Bangalore"},
            {"Who is the current Prime Minister of India (as of 2023)?", "Narendra Modi", "Rahul Gandhi", "Arvind Kejriwal", "Amit Shah", "Narendra Modi"},
            {"Which industry is commonly associated with the city of Mumbai?", "Bollywood", "Information Technology", "Textiles", "Agriculture", "Bollywood"},
            {"What is the primary stock exchange in India?", "BSE (Bombay Stock Exchange)", "NSE (National Stock Exchange)", "NYSE (New York Stock Exchange)", "LSE (London Stock Exchange)", "BSE"},
            {"Which river is considered the holiest in Hinduism?", "Ganges", "Yamuna", "Brahmaputra", "Godavari", "Ganges"},
            {"Which is the largest city in India by population?", "Mumbai", "Delhi", "Kolkata", "Chennai", "Mumbai"},
            {"In which year did India gain independence?", "1942", "1947", "1950", "1962", "1947"},
            {"Which Indian festival is known as the Festival of Lights?", "Diwali", "Holi", "Navratri", "Eid", "Diwali"},
            {"Who is known as the 'Father of the Nation' in India?", "Jawaharlal Nehru", "Mahatma Gandhi", "Subhas Chandra Bose", "Sardar Patel", "Mahatma Gandhi"},
            {"Which Indian state is known as the 'Land of Five Rivers'?", "Punjab", "Haryana", "Uttar Pradesh", "Bihar", "Punjab"}
        };

        for (String[] question : indiaBusinessQuestionsAndAnswers) {
            Arrays.sort(question, 1, question.length - 1);
            for (int i = 1; i < question.length - 1; i++) {
                question[i] = (char) ('a' + i - 1) + ". " + question[i];
            }
        }

        try (Scanner scanner = new Scanner(System.in)) {
            int correctAnswers = 0;

            for (int i = 0; i < indiaBusinessQuestionsAndAnswers.length; i++) {
                System.out.println((i + 1) + ". " + indiaBusinessQuestionsAndAnswers[i][0]);

                for (int j = 1; j < indiaBusinessQuestionsAndAnswers[i].length - 1; j++) {
                    System.out.println(indiaBusinessQuestionsAndAnswers[i][j]);
                }

                System.out.print("\nEnter your answer: ");
                String userAnswer = scanner.nextLine().trim().toLowerCase();

                boolean isCorrect = false;
                for (int j = 1; j < indiaBusinessQuestionsAndAnswers[i].length - 1; j++) {
                    if (userAnswer.equals(Character.toString((char) ('a' + j - 1)).toLowerCase()) ||
                            userAnswer.equals(indiaBusinessQuestionsAndAnswers[i][j].substring(3).toLowerCase())) {
                        isCorrect = true;
                        break;
                    }
                }

                if (isCorrect) {
                    System.out.println("Correct!");
                    correctAnswers++;
                } else {
                    System.out.println("Incorrect. The correct answer is " + indiaBusinessQuestionsAndAnswers[i][indiaBusinessQuestionsAndAnswers[i].length - 1]);
                }

                System.out.println("---------------------------------------------------------");

                if (i + 1 == 10) {
                    break;
                }
            }

            System.out.println("Your final score is " + correctAnswers + "/" + Math.min(10, indiaBusinessQuestionsAndAnswers.length));
            if (indiaBusinessQuestionsAndAnswers.length==10) {
                System.out.println("|| CONGRATULATIONS ||");                
            }
        }
    }
}
