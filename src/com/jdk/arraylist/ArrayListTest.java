/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/28/19 3:41 PM
 */

package com.jdk.arraylist;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListTest {
    static final <T> List<T> arrayToList(final T[] array)
    {
        final List<T> l = new ArrayList<>(array.length);
        for(final T s:array)
            l.add(s);

        return (l);
    }

    public static void main(String[] args) {
        Integer[] myArray={1,2,3};
        List<Integer> result = arrayToList(myArray);
//        result.add(1);
        System.out.println(result);

        List list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        System.out.println("abc test");
    }



    // java8 stream
    @Test
    public void JDKJava8()
    {
        Integer[] myArray = {1,2,3};
        List myList = Arrays.stream(myArray).collect(Collectors.toList());

        int [] myArray2 = { 1, 2, 3 };
        List myList1 = Arrays.stream(myArray2).boxed().collect(Collectors.toList());
    }

    // 不可变集合
    @Test
    public void testGuavaImmutableList()
    {
        List<String> il = ImmutableList.of("string", "elements");  // from varargs
        String[] aStringArray = {"string1", "string2"};
        List<String> il1 = ImmutableList.copyOf(aStringArray);      // from array
//        il1.add("testAddedString"); // UnsupportedOperationException
    }

    // 可变集合

    @Test
    public void testGuavaChangeableList()
    {
        List<String> anotherListOrCollection = new ArrayList<>();
        anotherListOrCollection.add("test");
        List<String> l1 = Lists.newArrayList(anotherListOrCollection);    // from collection
        String[] aStringArray = {"String1", "String1"};
        List<String> l2 = Lists.newArrayList(aStringArray);               // from array
        l2.add("addforl2");
        List<String> l3 = Lists.newArrayList("or", "string", "elements"); // from varargs
        l3.add("addforl3");
    }


}
