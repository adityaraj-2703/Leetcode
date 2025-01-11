package design.guesstheword;

public class GuessTheWord {
    public void findSecretWord(String[] words, Master master) {
        for(int i=0;i<words.length;i++){
            master.guess(words[i]);
        }
    }
}
class Solve implements Master{
    String secret;
    Solve(String secret){
        this.secret = secret;
    }
    @Override
    public int guess(String word) {
        int count=0;
       for(int i=0;i<word.length();i++){
            if(word.charAt(i) == secret.charAt(i)){
                count++;
            }
       }
       return count;
    }

}
