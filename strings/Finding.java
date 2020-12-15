// strings/Finding.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.regex.*;

public class Finding {
  public static void main(String[] args) {
    Matcher m = Pattern.compile("\\w+")
      .matcher(
        "Evening is full of the linnet's wings");
    while(m.find())
      System.err.print(m.group() + " ");
    System.err.println();

    int i = 0;
    while(m.find(i)) {
      System.err.print(m.group() + " ");
      i++;
    }


    test();
  }



  public static void test() {
    Pattern pattern = Pattern.compile("\\d{3,5}");
    String charSequence = "123-34345-234-00";
    Matcher matcher = pattern.matcher(charSequence);

    //虽然匹配失败，但由于charSequence里面的"123"和pattern是匹配的,所以下次的匹配从位置4开始
//    print(matcher.matches());
    //测试匹配位置
    matcher.find();
    matcher.find();

    print("orginal:"+matcher.start());

    //使用reset方法重置匹配位置
    matcher.reset();

    //第一次find匹配以及匹配的目标和匹配的起始位置
    print(matcher.find());
    print(matcher.group()+" - "+matcher.start());
    //第二次find匹配以及匹配的目标和匹配的起始位置
    print(matcher.find());
    print(matcher.group()+" - "+matcher.start());

    //第一次lookingAt匹配以及匹配的目标和匹配的起始位置
    print(matcher.lookingAt());
    print(matcher.group()+" - "+matcher.start());

    //第二次lookingAt匹配以及匹配的目标和匹配的起始位置
    print(matcher.lookingAt());
    print(matcher.group()+" - "+matcher.start());
  }


  public static void print(Object o){
    System.out.println(o);
  }
}
/* Output:
Evening is full of the linnet s wings
Evening vening ening ning ing ng g is is s full full
ull ll l of of f the the he e linnet linnet innet nnet
net et t s s wings wings ings ngs gs s
*/
