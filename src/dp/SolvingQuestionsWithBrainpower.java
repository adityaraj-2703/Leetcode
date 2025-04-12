package dp;

public class SolvingQuestionsWithBrainpower {
    public long mostPoints(int[][] questions) {
        int a = mostPointsUtil(questions, 1, questions[0][1], questions[0][0]);
        int b = mostPointsUtil(questions, 1, -1, 0);
        return Math.max(a, b);
    }

    public int mostPointsUtil(int[][] questions, int ind, int power, int sum) {
        if (ind >= questions.length) {
            return sum;
        }
        if (power > 0) {
            return mostPointsUtil(questions, ind + 1, power - 1, sum);
        }
        int maxPower = Math.max(power, questions[ind][1]);
        int a = mostPointsUtil(questions, ind + 1, maxPower, sum + questions[ind][0]);
        int b = mostPointsUtil(questions, ind + 1, maxPower, sum);
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        SolvingQuestionsWithBrainpower s = new SolvingQuestionsWithBrainpower();
        int[][] questions = { { 1, 2 }, { 2, 1 }, { 3, 2 }, { 4, 1 } };
        System.out.println(s.mostPoints(questions));
    }

}
