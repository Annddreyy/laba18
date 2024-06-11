import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Введите размер массива: ");
        int size = input.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++){
            System.out.println("Введите элемент массива: ");
            arr[i] = input.nextInt();
        }

        System.out.println(Arrays.toString(arr));

        System.out.println("Введите вид сортировки (1 - по возрастанию, 2 - по убыванию): ");
        int operation = input.nextInt();
        Expression func;
        if (operation == 1) {
            func = (x, y) -> x > y;
            bubbleSort(arr, func);
            System.out.println(Arrays.toString(arr));
        }
        else if (operation == 2) {
            func = (x, y) -> x < y;
            bubbleSort(arr, func);
            System.out.println(Arrays.toString(arr));
        }
        else
            System.out.println("Неверная команда!");
    }
    private static void bubbleSort(int[] arr, Expression ex) {
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (ex.isEqual(arr[j], arr[j + 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

interface Expression{
    boolean isEqual(int a, int b);
}