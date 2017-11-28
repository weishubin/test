/**
 * Created by weishubin on 2017/11/28.
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("We Are Happy");
        System.out.println(ReplaceSpace.replaceSpace(sb));
    }

    public static String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append('%');
                sb.append('2');
                sb.append('0');
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
