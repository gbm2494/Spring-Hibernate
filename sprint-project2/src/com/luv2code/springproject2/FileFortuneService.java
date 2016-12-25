package com.luv2code.springproject2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private String path;
	private ArrayList<String> data = new ArrayList<String>();
	
	public FileFortuneService()
	{
		System.out.println("Entré al constructor de la clase FileFortuneService");
		path = "C:\\Users\\Gaudy-PC\\myworkspaceEclipse\\sprint-project2\\src\\com\\luv2code\\springproject2\\valores.txt";
				
		BufferedReader br = null;
		FileReader fr = null;
		
		try {

			fr = new FileReader(path);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(path));
			
			while ((sCurrentLine = br.readLine()) != null) 
			{
				data.add(sCurrentLine);
				//System.out.println(sCurrentLine);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}
	
	@Override
	public String getFortune() {
		Random r = new Random();
		int n = r.nextInt(data.size());
		return data.get(n);
	}
	

}
