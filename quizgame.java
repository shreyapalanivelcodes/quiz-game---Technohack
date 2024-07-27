import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class quizgame {

    static class Question {
        String questionText;
        List<String> options;
        int correctOptionIndex;

        public Question(String questionText, List<String> options, int correctOptionIndex) {
            this.questionText = questionText;
            this.options = options;
            this.correctOptionIndex = correctOptionIndex;
        }
    }

    private List<Question> questions;
    private Scanner scanner;

    public quizgame() {
        questions = new ArrayList<>();
        scanner = new Scanner(System.in);

        // Add questions to the quiz
        questions.add(new Question(
            "What is the capital of France?",
            List.of("1. Berlin", "2. Madrid", "3. Paris", "4. Rome"),
            2
        ));
        questions.add(new Question(
            "What is 2 + 2?",
            List.of("1. 3", "2. 4", "3. 5", "4. 6"),
            1
        ));
        questions.add(new Question(
            "What is the largest planet in our solar system?",
            List.of("1. Earth", "2. Mars", "3. Jupiter", "4. Saturn"),
            2
        ));
    }

    public void start() {
        int score = 0;

        for (Question question : questions) {
            System.out.println(question.questionText);
            for (String option : question.options) {
                System.out.println(option);
            }

            System.out.print("Select an option (1-4): ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == question.correctOptionIndex + 1) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + (question.correctOptionIndex + 1));
            }
            System.out.println();
        }

        System.out.println("Quiz finished! Your score: " + score + "/" + questions.size());
        scanner.close();
    }

    public static void main(String[] args) {
        quizgame quizGame = new quizgame();
        quizGame.start();
    }
}
