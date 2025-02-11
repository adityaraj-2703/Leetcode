package string;

public class RemoveAllOccurenceOfSubstring {
    public String removeOccurrences(String s, String part) {
        if (part.length() > s.length()) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < part.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = part.length(); i < s.length(); i++) {

            String temp = sb.substring(Math.max(0, sb.length() - part.length()), sb.length());
            System.out.println(temp);
            if (temp.equals(part)) {
                for (int j = 0; j < part.length(); j++) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            sb.append(s.charAt(i));

        }
        String temp = sb.substring(Math.max(0, sb.length() - part.length()), sb.length());
        System.out.println(temp);
        if (temp.equals(part)) {
            for (int j = 0; j < part.length(); j++) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveAllOccurenceOfSubstring r = new RemoveAllOccurenceOfSubstring();
        System.out.println(r.removeOccurrences("daabcbaabcbc", "abc"));
    }

}
