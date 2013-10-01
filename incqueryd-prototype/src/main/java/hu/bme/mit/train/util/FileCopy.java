package hu.bme.mit.train.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
	public static void copy(String from, String to) {
		File inputFile = new File(from);
		File outputFile = new File(to);

		try {
			FileReader in = new FileReader(inputFile);
			FileWriter out;
			out = new FileWriter(outputFile);
			int c;

			while ((c = in.read()) != -1)
				out.write(c);

			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void delete(String fileStr) {
		File file = new File(fileStr);
		file.delete();
	}

	public static void move(String from, String to) {
		copy(from, to);
		delete(from);
	}
}
