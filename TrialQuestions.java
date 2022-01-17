import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;


public class TrialQuestions {
    public void method1(int num1, float num2) {
        System.out.println("int-float method");
    }

    public void method1(float num1, int num2) {
        System.out.println("float-int method");
    }

    int fun(int n) {
        int result;
        result = fun(n - 1);
        return result;
    }

    int calculate(int a, int b) {
        try {
            return a - b;
        } catch (Exception e) {
            System.out.println("Result catch: ");
            return a + b;
        } finally {
            System.out.println("Result fianlly : ");
            return a * b;
        }
    }

    public static void main(String[] args) {
        TrialQuestions interviewBit = new TrialQuestions();
        //interviewBit.method1(40,20);
        //compile errror

        TrialQuestions ib = new TrialQuestions();
        //System.out.print(ib.fun(12));
        //run time stack overflow

        String obj = "Hello";
        String obj1 = "TrialQuestions";
        String obj2 = "Hello";
        System.out.println(obj.equals(obj1) + " " + obj.equals(obj2));


        TrialQuestions obj11 = new TrialQuestions();
        int result = obj11.calculate(2, 3);
        System.out.println("Result: " + result);//6

        Integer[] arr = new Integer[]{100, 100, 9, 8, 200};
        List<Integer> list = Arrays.asList(arr);

        OptionalDouble avg = list.stream().mapToInt(n -> n * n).filter(n -> n > 100).average();
        if (avg.isPresent()) {
            System.out.println(avg.getAsDouble());
        }

        Double d1 = 0.0;
        Double d2 = 0.0;
        System.out.println(d1 == d2);
        //The most accurate way to tell whether two double values are
        //equal to one another is to use Double.compare() and test against 0, as in:
        System.out.println(Double.compare(d1, d2) == 0);

        final List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.remove(2);//index
        list1.remove(Integer.valueOf(2));//value
        System.out.println(list1);

        //int a = 1L; won’t compile and int b = 0; b += 1L; compiles fine. Why ?
        //int a = 1L;
        int b = 0;
        b += 1L;

        //There is no need for an instance while invoking a static member or method, since static members belongs to a class rather than an instance.
        //A null reference may be used to access a class (static) variable without causing an exception.

        TrialQuestions t = null;
        t.someMethod();

        /*The second output is true as we are comparing the references,
        because the JVM tries to save memory when the Integer falls within a range (from -128 to 127).
        At point 2, no new reference of type Integer is created for ‘d’. Instead of creating a new object
        for the Integer type reference variable ‘d’, it is only assigned
        with a previously created object referenced by ‘c’. All of these are done by JVM.
*/
        Integer a = 1000, b1 = 1000;
        System.out.println(a == b1);//false
        Integer c = 100, d = 100;
        System.out.println(c == d);//true

    }

    private static void someMethod() {
    }
}
