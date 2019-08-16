package generic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * 证明Java类型的类型擦除
 */
public class GenericDemo01 {


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

//        example1();

        example2();

    }

    /**
     * 例1.原始类型相等
     */
    private static void example1() {

        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("abc");

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(123);

        System.out.println(list1.getClass() == list2.getClass());
    }

    /**
     * 例2.通过反射添加其它类型元素
     */
    private static void example2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);  //这样调用 add 方法只能存储整形，因为泛型类型的实例为 Integer

        list.getClass().getMethod("add", Object.class).invoke(list, "asd");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
