public class Main {
    public static void main(String[] args) {
        int scoreResult = calculateScore("Tommy", 60);
        System.out.println("After the calculation, your final score is:" + scoreResult);

        int dummyScoreResult = calculateScore("Tommy");
        System.out.println("The dummy calculation is:" + dummyScoreResult);
    }

    public static int calculateScore(String playerName, int score) {

        System.out.println("Player " + playerName + " scored " + score + "points");
        return score * 1000;
    }

    public static int calculateScore(String playerName) {
        System.out.println("This is a lazy calculate fucntion, it won't disappoint you!");
        return 100;
    }
}