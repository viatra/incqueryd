package pkg;

import java.io.FileNotFoundException;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException {
		Parser parser1 = new Parser("file1.xml");
		parser1.parse();
		
		Parser parser2 = new Parser("file2.xml");
		parser2.parse();
	}
	
}
