package Seminar003;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataInFile implements DataSaverInterface {
	@Override
	public void write(String fileName, String info) {
		try {
			FileWriter fileWriter = new FileWriter(new File("src/files/" + fileName), true);
			fileWriter.write(info);
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
