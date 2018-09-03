package twoChapter;

/**
 * -Xss228k
 */
public class JavaStackSOF {

    private int stackLength = 1;

    public void stackLeak() {

        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {

        JavaStackSOF oom = new JavaStackSOF();

        try {
            oom.stackLeak();
        } catch (Throwable e) {

            System.out.println("stack length :" + oom.stackLength);

            throw e;
        }

    }
}
