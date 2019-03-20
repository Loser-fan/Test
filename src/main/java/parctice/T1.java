package parctice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public abstract class T1 {

	public static void main(String[] args) {
		String bible = "C:\\Users\\51459\\Desktop\\bible.txt";
		
		try {
			List<String> readFile = readFile(bible);
			System.out.println(readFile.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static List<String> readFile(String path) throws IOException {
		File file = new File(path);
		
		List<String> list = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		String buffer = null;
		
		while ((buffer = reader.readLine()) != null) {
			String[] strings = buffer.split(" ");
			for (int i = 0; i < strings.length; i++) {
					list.add(strings[i]);
			}
		}
		
		return list;
		
	}

}
