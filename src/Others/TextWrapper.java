package Others;

/*


Write a text wrapper function which takes a width in pixels  and a String and returns a String with new lines inserted.
(You are also given a function which takes a string and gives you a pixel width).
 */
public class TextWrapper {
    TextWrapper(){}
    public String insertBreak(String content, int pixel){
        if (pixel <= 0) {
            return content;
        }
        StringBuilder sb = new StringBuilder(content);
        if (sb.length() < pixel) {
            sb.append("\n");
        } else {
            sb.insert(pixel, "\n");
        }

        return sb.toString();
    }


    public static void main (String[] args) {
        TextWrapper tw = new TextWrapper();
        String answer = tw.insertBreak("abcd", 4);
        System.out.println(answer);
    }
}
