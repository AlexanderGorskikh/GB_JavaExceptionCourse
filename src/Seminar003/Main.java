package Seminar003;

public class Main {
	// Alexander Dork Morkovich 12.04.1999 88005553535 m - строка для проверки
	public static void main(String[] args) {
		ParserData test = new ParserData();
		DataSaverInterface writer = new DataInFile();
		try {
			test.parseData();
			writer.write(test.getFirstName(), test.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
