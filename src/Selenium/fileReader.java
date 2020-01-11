package Selenium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class fileReader {

	public static void main(String[] args) {
		File file=new File("hello.txt");
		try {
			file.createNewFile();
			FileWriter writer=new FileWriter(file);
			writer.write("hello from new file");
			writer.flush();
			writer.close();
			
			BufferedReader reader=new BufferedReader(new java.io.FileReader(file));
			String line;
			while((line=reader.readLine())!=null)
			{
				System.out.println(line);
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
