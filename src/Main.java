import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		System.out.println(floatScanner());
//		checkCode1();
//		checkCode2();
		try {
			printEmptyStringMassage();
		} catch (EmptyStringException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

	/**
	 * @apiNote Task 1, Реализуйте метод, который запрашивает у
	 *          пользователя ввод дробного числа (типа float), и возвращает
	 *          введенное значение. Ввод текста вместо числа не должно приводить к
	 *          падению приложения, вместо этого, необходимо повторно запросить у
	 *          пользователя ввод данных.
	 * 
	 * @return res - отсканированное дробное число
	 */
	private static float floatScanner() {
		Scanner scanner = new Scanner(System.in);
		float res = 0;
		boolean flag = false;
		do {
			flag = false;
			System.out.print("Введите дробное число: ");
			try {
				res = Float.parseFloat(scanner.nextLine());
			} catch (NumberFormatException e) {
				flag = true;
				continue;
			}
		} while (flag);
		scanner.close();
		return res;
	}

	/**
	 * @apiNote Task 2, Если необходимо, исправьте данный код
	 *          https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit
	 * 
	 */
	private static void checkCode1() {
//		(прим: в коде мы обращаемся к int массиву, 
//		хотя у нас его еще нет, мы не знаем его размерности так что 
//		тут может выскочить ошибка ArrayOutOfBounds)
		int[] intArray = new int[new Random().nextInt(0, 15)];
		try {
			int d = 0;
			double catchedRes1 = intArray[8] / d;
			System.out.println("catchedRes1 = " + catchedRes1);
		} catch (ArithmeticException e) {
			System.out.println("Catching exception: " + e);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Catching exception: " + e);
		}
	}

	/**
	 * @apiNote Task 3, Если необходимо, исправьте данный код
	 *          https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit
	 * 
	 */
	private static void checkCode2() {
		int a = 90;
		int b = 3;
		printSum(23, 234);
		int[] abc = { 1, 2 };
		try {
			System.out.println(a / b); // возможно деление на 0
			abc[3] = 9; // возможен выход за пределы массива
		} catch (ArithmeticException ex) {
			System.out.println("Ошибка " + ex);
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("Массив выходит за пределы своего размера! " + ex);
		}
	}

	private static void printSum(Integer a, Integer b) {
		System.out.println(a + b);
	}
	// прим.
	// Мы не пробрасываем исключения выше, если обработали их в блоках try catch
	// Ошибка FileNotFoundException
	// не имеет смысла так как мы не работаем с файлами)
	// в блок try следует поместить потенциально опасные на ошибки строчки кода,
	// лишнее убрать
	// Первый catch не имеет смысла так как неинформативен, второй catch ошибки не
	// вызывается

	/**
	 * @throws EmptyStringException 
	 * @apiNote Task4, Разработайте программу, которая выбросит Exception, когда
	 *          пользователь вводит пустую строку. Пользователю должно показаться
	 *          сообщение, что пустые строки вводить нельзя.
	 */
	private static void printEmptyStringMassage() throws EmptyStringException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите строку, она не должна быть пустой");
		if (scanner.nextLine().equals("")) {
			throw new EmptyStringException();
		}
	}
}

class EmptyStringException extends Exception{
		private static final long serialVersionUID = -1784634902596117273L; // Сгенерировано в эклипсе ¯\_(ツ)_/¯

		public EmptyStringException() {
			super("Вы ввели пустую строку");
		}
	}