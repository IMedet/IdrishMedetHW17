package kz.medet;

import java.util.ArrayList;
import java.util.Collections;

public class Arrays {
    public static void main(String[] args) {
        Integer[] intArray = {1,2,3,4,5};
        swap(intArray,1,3);
        System.out.println(java.util.Arrays.toString(intArray));

        String[] stringArray = {"one","two","three","four","five"};
        swap(stringArray,1,2);
        System.out.println(java.util.Arrays.toString(stringArray));


        ArrayList<String> stringArrayList = toArrayList(stringArray);
        System.out.println(stringArrayList);
    }


    //1 задача
    public static <T> void swap (T[] arr, int index1, int index2) {
        if (arr == null || index1<0 || index2<0 || index1>=arr.length || index2>=arr.length){
            throw new IllegalArgumentException("Uncorrect array or index");
        }

        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    //2 задача
    public static <T> ArrayList<T> toArrayList(T[] array){
        if(array == null){
            throw new IllegalArgumentException("Null array");
        }
        ArrayList<T> list = new ArrayList<>();
        Collections.addAll(list,array);

        return list;
    }
}
