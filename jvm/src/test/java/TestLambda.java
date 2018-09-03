import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.List;
import java.util.ArrayList;
//import java.util.stream.Collectors;

/**
 * java8的例子，使用lambda表达式
 * @author zhangchao
 *
 */
public class TestLambda {

    /**
     * 准备书的列表数据
     * @return
     */
    public static List<Book> prepareData() {
        // 准备书的列表，id是从1到10
        List<Book> bookList = new ArrayList<Book>();
        for (int i = 1; i < 11; i++) {
            bookList.add(new Book(String.valueOf(i), "book"+i));
        }
        return bookList;
    }

    public static void main(String[] args) {
        List<Book> bookList = prepareData();

        // 要被找出的书的ID
        ArrayList<String> ids = new ArrayList<String>();
        ids.add("3");
        ids.add("6");
        ids.add("8");
        ids.add("9");

        // 存放过滤结果的列表
        List<Book> result = null;

        // 使用lambda表达式过滤出结果并放到result列表里，written by zhangchao
//        result = bookList.stream()
//                .filter((Book b) -> ids.contains(b.getId()))
//                .collect(Collectors.toList());

        // 打印结果列表
        //        if (result != null && !result.isEmpty()) {
        //            result.forEach((Book b) -> System.out.println(b.getId() + "  " + b.getName()));
        //        }

//        bookList.removeIf(b -> ids.contains(b.getId()));
//        bookList.removeIf(book -> book.getId().equals("2") || book.getId().equals("2"));
//        bookList.forEach(book -> System.out.println(book.getId() + "    " + book.getName()));

        Multimap<Integer, Book> bookMultimap = ArrayListMultimap.create();
        bookMultimap.putAll(1, bookList);
        System.out.println(bookMultimap);

    }
}