package string;

public class ReverseWordsInaString {
    public String reverseWords(String s) {
        s.trim();
        char[] ch = s.toCharArray();
        int i=0;
        int j=0;
        while(j<ch.length){
            if(ch[j] != ' '){
                j++;
            }
            else{
                reverse(ch,i,j-1);
                while(ch[j]== ' '){
                    j++;
                }
                i=j;
            }
        }
        reverse(ch,0,ch.length-1);
        return ch.toString();
        
    }
    static void reverse(char[] c,int i,int j){
        while(i<j){
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
    }
}
