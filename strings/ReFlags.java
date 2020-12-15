// strings/ReFlags.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.regex.*;

public class ReFlags {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^java",
                Pattern.CASE_INSENSITIVE
                        | Pattern.MULTILINE
        );
        Matcher m = p.matcher(
                "java has regex\n" +
                        "Java has regex\n" +
                        "JAVA has pretty good regular expressions\n" +
                        "Regular expressions are in Java"); //这个不符合^, 开头java
        while (m.find()) {
            System.err.print(m.end() + "---");
            System.err.println(m.group());
        }

    }
}
/* Output:
java
Java
JAVA
*/
