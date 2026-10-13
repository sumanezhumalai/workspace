package zProjects.Quiz;

import java.util.Scanner;

public class QuestionService {
    Question[] questions = new Question[5];
    final Scanner sc = new Scanner(System.in);

    QuestionService() {
        questions[0] = new Question(
                1,
                "Which keyword is used to inherit a class in Java?",
                new String[] { "extends", "implements", "inherits", "import" },
                1);

        questions[1] = new Question(
                2,
                "What is the chemical symbol for Gold?",
                new String[] { "Gd", "Au", "Ag", "Fe" },
                2);

        questions[2] = new Question(
                3,
                "Which is the largest ocean on Earth?",
                new String[] { "Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean" },
                4);

        questions[3] = new Question(
                4,
                "What is the value of Pi rounded to two decimal places?",
                new String[] { "3.12", "3.16", "3.14", "3.18" },
                3);

        questions[4] = new Question(
                5,
                "In which year did the Titanic sink?",
                new String[] { "1912", "1905", "1920", "1914" },
                1);
    }

    public void displayQuestions() {
        for (Question question : questions) {
            System.out.println(question.toString());
        }
    }

    public void playQuiz() {
        boolean play = true; // Use primitive boolean
        Scanner sc = new Scanner(System.in); // Assuming sc is initialized

        do {
            int score = 0;

            for (Question question : questions) {
                System.out.println(question.getQuestion() + "\n");
                for (String option : question.getOptions()) {
                    System.out.println(option + "\n");
                }

                System.out.print("Enter your choice [1-4] : ");
                int choice = sc.nextInt();

                // FIX 1: Clear the newline character from the buffer after nextInt()
                sc.nextLine();

                if (choice == question.getAnswer()) {
                    System.out.println("\nYour answer is Correct!");
                    score += 1;
                } else {
                    System.out.println("\nYour answer is Wrong! Correct Answer: "
                            + question.getOptions()[question.getAnswer() - 1]);
                }
            }

            System.out.println("Your Total score out of 5: " + score + "!\n");

            System.out.print("Press Enter to play again! (q to quit): ");
            String input = sc.nextLine(); // Read the actual user input string

            if (input.equalsIgnoreCase("q")) {
                play = false;
            }
        } while (play);
        sc.close();
    }
}