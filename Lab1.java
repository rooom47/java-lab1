import java.util.Arrays;
import java.util.Scanner;

class Lab1 {
    private final Scanner sc = new Scanner(System.in);

    // Методы ввода, с проверкой
    private int readInt(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            try {
                int v = Integer.parseInt(sc.nextLine().trim());
                if (v >= min && v <= max) return v;
                System.out.println("Ошибка: число должно быть от " + min + " до " + max);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число");
            }
        }
    }

    private int readInt(String msg) {
        return readInt(msg, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private char readChar(String msg, boolean digitOnly) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();
            if (s.length() == 1 && (!digitOnly || (s.charAt(0) >= '0' && s.charAt(0) <= '9')))
                return s.charAt(0);
            System.out.println("Ошибка: введите " + (digitOnly ? "одну цифру" : "один символ"));
        }
    }

    private int[] readArray(String msg) {
        while (true) {
            System.out.print(msg + " (числа через пробел): ");
            String[] p = sc.nextLine().trim().split("\\s+");
            try {
                int[] a = new int[p.length];
                for (int i = 0; i < p.length; i++) a[i] = Integer.parseInt(p[i]);
                return a;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: вводите только целые числа");
            }
        }
    }

    // Задание 1 
    public int charToNum(char x) {
        return x - '0';
    }

    public boolean isPositive(int x) {
        return x > 0;
    }

    public boolean isUpperCase(char x) {
        return x >= 'A' && x <= 'Z';
    }

    public boolean isDivisor(int a, int b) {
        return (a != 0 && b % a == 0) || (b != 0 && a % b == 0);
    }

    public int lastNumSum(int a, int b) {
        return a % 10 + b % 10;
    }

    // Задание 2 
    public int abs(int x) {
        if (x < 0) return -x;
        return x;
    }

    public String makeDecision(int x, int y) {
        if (x < y) return x + "< " + y;
        if (x > y) return x + " >" + y;
        return x + "==" + y;
    }

    public int max3(int x, int y, int z) {
        int m = x;
        if (y > m) m = y;
        if (z > m) m = z;
        return m;
    }

    public int sum2(int x, int y) {
        int s = x + y;
        if (s >= 10 && s <= 19) return 20;
        return s;
    }

    public String day(int x) {
        switch (x) {
            case 1: return "понедельник";
            case 2: return "вторник";
            case 3: return "среда";
            case 4: return "четверг";
            case 5: return "пятница";
            case 6: return "суббота";
            case 7: return "воскресенье";
            default: return "это не день недели";
        }
    }

    //  Задание 3 
    public String reverseListNums(int x) {
        String s = "";
        for (int i = x; i >= 0; i--) s += i + " ";
        return s.trim();
    }

    public String chet(int x) {
        String s = "";
        for (int i = 0; i <= x; i += 2) s += i + " ";
        return s.trim();
    }

    public boolean equalNum(int x) {
        int d = x % 10;
        while (x > 0) {
            if (x % 10 != d) return false;
            x /= 10;
        }
        return true;
    }

    public void leftTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < i; j++) System.out.print("*");
            System.out.println();
        }
    }

    public void rightTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < x - i; j++) System.out.print(" ");
            for (int j = 0; j < i; j++) System.out.print("*");
            System.out.println();
        }
    }

    // Задание 4 
    public int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == x) return i;
        return -1;
    }

    public int findLast(int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--)
            if (arr[i] == x) return i;
        return -1;
    }

    public int[] add(int[] arr, int x, int pos) {
        int[] res = new int[arr.length + 1];
        for (int i = 0, j = 0; i < res.length; i++)
            res[i] = (i == pos) ? x : arr[j++];
        return res;
    }

    public int[] reverseBack(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            res[i] = arr[arr.length - 1 - i];
        return res;
    }

    public int[] deleteNegative(int[] arr) {
        int[] res = new int[arr.length];
        int n = 0;
        for (int v : arr)
            if (v >= 0) res[n++] = v;
        return Arrays.copyOf(res, n);
    }

    // Запускаем выбранную задачку
    private void run(int c) {
        switch (c) {
            case 1:
                System.out.println("Результат: " + charToNum(readChar("Введите цифру: ", true)));
                break;
            case 2:
                System.out.println("Результат: " + isPositive(readInt("Введите число: ")));
                break;
            case 3:
                System.out.println("Результат: " + isUpperCase(readChar("Введите символ: ", false)));
                break;
            case 4:
                System.out.println("Результат: " + isDivisor(readInt("Введите a: "), readInt("Введите b: ")));
                break;
            case 5:
                int r = readInt("Введите число 1 из 5: ", 0, Integer.MAX_VALUE);
                for (int i = 2; i <= 5; i++) {
                    int n = readInt("Введите число " + i + " из 5: ", 0, Integer.MAX_VALUE);
                    int s = lastNumSum(r, n);
                    System.out.println(r + "+" + n + " это " + s);
                    r = s;
                }
                System.out.println("Итого " + r);
                break;
            case 6:
                System.out.println("Результат: " + abs(readInt("Введите число: ", -Integer.MAX_VALUE, Integer.MAX_VALUE)));
                break;
            case 7:
                System.out.println("Результат: " + makeDecision(readInt("Введите x: "), readInt("Введите y: ")));
                break;
            case 8:
                System.out.println("Результат: " + max3(readInt("Введите x: "), readInt("Введите y: "), readInt("Введите z: ")));
                break;
            case 9:
                System.out.println("Результат: " + sum2(readInt("Введите x: ", -1000000, 1000000), readInt("Введите y: ", -1000000, 1000000)));
                break;
            case 10:
                System.out.println("Результат: " + day(readInt("Введите число: ")));
                break;
            case 11:
                System.out.println("Результат: " + reverseListNums(readInt("Введите x (0..10000): ", 0, 10000)));
                break;
            case 12:
                System.out.println("Результат: " + chet(readInt("Введите x (0..10000): ", 0, 10000)));
                break;
            case 13:
                System.out.println("Результат: " + equalNum(readInt("Введите неотрицательное число: ", 0, Integer.MAX_VALUE)));
                break;
            case 14:
                leftTriangle(readInt("Введите высоту (1..50): ", 1, 50));
                break;
            case 15:
                rightTriangle(readInt("Введите высоту (1..50): ", 1, 50));
                break;
            case 16:
                int[] a1 = readArray("Введите массив");
                System.out.println("Результат: " + findFirst(a1, readInt("Введите x: ")));
                break;
            case 17:
                int[] a2 = readArray("Введите массив");
                System.out.println("Результат: " + findLast(a2, readInt("Введите x: ")));
                break;
            case 18:
                int[] a3 = readArray("Введите массив");
                int x = readInt("Введите x: ");
                int pos = readInt("Введите позицию (0.." + a3.length + "): ", 0, a3.length);
                System.out.println("Результат: " + Arrays.toString(add(a3, x, pos)));
                break;
            case 19:
                System.out.println("Результат: " + Arrays.toString(reverseBack(readArray("Введите массив"))));
                break;
            case 20:
                System.out.println("Результат: " + Arrays.toString(deleteNegative(readArray("Введите массив"))));
                break;
        }
    }

    // MAIN
    public static void main(String[] args) {
        Lab1 l = new Lab1();
        String[] menu = {
            "1.3 Букву в число", "1.4 Есть ли позитив", "1.6 Большая буква", "1.8 Делитель",
            "1.10 Многократный вызов", "2.1 Модуль числа", "2.4 Строка сравнения", "2.5 Тройной максимум",
            "2.7 Двойная сумма", "2.9 День недели", "3.2 Числа наоборот", "3.3 Четные числа",
            "3.6 Одинаковость", "3.8 Левый треугольник", "3.9 Правый треугольник",
            "4.1 Поиск первого значения", "4.2 Поиск последнего значения", "4.4 Добавление в массив",
            "4.7 Возвратный реверс", "4.10 Удалить негатив"
        };
        while (true) {
            System.out.println("\nЛабораторная работа №1 (вариант 10)");
            for (int i = 0; i < menu.length; i++) System.out.println((i + 1) + ". " + menu[i]);
            System.out.println("0. Выход");
            int c = l.readInt("выберите пункт меню: ", 0, menu.length);
            if (c == 0) {
                System.out.println("пока-пока!");
                return;
            }
            System.out.println("--- " + menu[c - 1] + " ---");
            l.run(c);
        }
    }
}
