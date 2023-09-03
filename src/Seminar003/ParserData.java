package Seminar003;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ParserData {
	private final int argumentsCount = 6;
	private String firstName;
	private String lastName;
	private String patronumic;
	private long phoneNumber;
	private String birthDate;
	private char gender;

	private String[] checkArgumentsCount() throws LowArgumentsException {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Введите строку в формате: Ф И О, дату рождения (dd.mm.yyyy), номер телефона (8хххххххххх), пол (m/f)");
		String[] res = scanner.nextLine().split(" ");
		if (res.length != argumentsCount) {
			throw new LowArgumentsException(String.format("You input %d at %d arguments", res.length, argumentsCount));
		}
		return res;
	}

	public boolean parseData() throws LowArgumentsException, WrongInputException {
		String[] current = checkArgumentsCount();
		firstName = current[0];
		lastName = current[1];
		patronumic = current[2];
		try {
			birthDate = LocalDate.parse(current[3], DateTimeFormatter.ofPattern("dd.MM.yyyy")).toString();
		} catch (DateTimeParseException e) {
			throw new WrongInputException("Wrong data format (dd.mm.yyyy)" + current[3]);
		}
		try {
			phoneNumber = Long.parseLong(current[4]);
		} catch (NumberFormatException e) {
			throw new WrongInputException("Phone number is undefind " + current[4]);
		}
		if (current[5].equals("f") || current[5].equals("m")) {
			gender = current[5].charAt(0);
		} else {
			throw new WrongInputException("Wrong gender format choice m (male) or f (female)" + current[5]);
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(firstName).append(" ");
		sb.append(lastName).append(" ");
		sb.append(patronumic).append(" ");
		sb.append(birthDate).append(" ");
		sb.append(phoneNumber).append(" ");
		sb.append(gender);
		return sb.toString();
	}
	public String getFirstName() {
		return firstName;
	}
}

class WrongInputException extends Exception {
	public WrongInputException(String massage) {
		super(massage);
	}
}

class LowArgumentsException extends Exception {
	public LowArgumentsException(String massage) {
		super(massage);
	}
}