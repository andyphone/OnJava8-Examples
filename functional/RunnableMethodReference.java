// functional/RunnableMethodReference.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Method references with interface Runnable

class Go {
    static void go() {
        System.err.println("Go::go()");
    }
}
class MyThread implements Runnable{
    private String name;
    public MyThread(String name){
        this.name=name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.err.print(this.name+"==>"+i);
        }
        System.err.println();
    }
}
public class RunnableMethodReference {

    public static void main(String[] args) {
        new Thread(new MyThread("a")).start();



        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.err.println("Anonymous");
                    }
                }
        ).start();

        new Thread(
                //self-note: 上面的简写
                () -> System.err.println("lambda")
        ).start();

        new Thread(Go::go).start();
    }
}
/* Output:
Anonymous
lambda
Go::go()
*/
