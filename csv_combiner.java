package pmg_challenge;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author smith
 *
 */
public class csv_combiner {

	public static void main(String[] args) throws IOException {
		// Input: creating String args that correlate with files only file name 
			/* File file = new File(); -> creates a file instance that the contents of the .csv are placed in
			 * try { } catch{} -> what to do if the file is not found or located
			 * inputStream.nextLine(); -> ignores the first line of headers & reads the rest of the .csv file
			 * String content = inputStream.nextLine() -> reads each line (includes spaces and/or the end of line then positions at next line to be read when done
			 * String [] data = content.split(""); -> sets the delimiter as a comma
			 * inputStream.close(); -> always close an input stream to prevent file leakage; holds handle for file
			 */
		String filename1 = "accessories.csv";
		File file = new File(filename1);
		
		try { 
			Scanner inputStream = new Scanner(file);
			inputStream.nextLine();
			while(inputStream.hasNext()) {
				String content = inputStream.nextLine(); 
			}
			inputStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		String filename2 = "clothing.csv";
		File file2 = new File(filename2);
		
		try {
			Scanner inputStream = new Scanner(file2);
			inputStream.nextLine();
			while(inputStream.hasNext()) {
				String content2 = inputStream.nextLine();
			}
			inputStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Next: Combine .csv files into one & add the filetype
		
		String line = "";
		String linesplit = ",";
		
		/* PrintWriter pw = new PrintWriter(file)-> creates the mergedFile to be used for inputting the accessories & clothing files
		 * BufferedWriter bw = new BufferedWriter(new FileWriter(file)) -> allows writing to the merged file
		 * */
		PrintWriter pw = new PrintWriter("mergedFile.csv");

		BufferedWriter bw = new BufferedWriter(new FileWriter("mergedFile.csv"));
		
		/*
		 * try statement takes the file and adds the filetype to each line as long as it is not equal to null
		 * once the line is read, the BufferedWriter finds the end of line and adds a new split where the filetype is placed
		 * */
		try (
				BufferedReader reader =  new BufferedReader(new FileReader(file))) {
				line = reader.readLine();
				String newHLine = line + linesplit + "filename";
				bw.write(newHLine);
				bw.newLine();
				
				while((line = reader.readLine()) != null) {
					newHLine = line + linesplit + "accessories.csv";
					bw.write(newHLine);
					bw.newLine();
				}
			} 
			
			BufferedReader reader =  new BufferedReader(new FileReader(file));
			//loop creates copy of accessories.csvines in combined.csv
			// As the loop is creating copies of what is in the original file, this is where I would want to check for duplicates 
				// perhaps a check to see if the line (current) is equal to the previous or next one
			while(line != null) {
				pw.println(line);
				line = reader.readLine();
			}
			
			
			try (BufferedReader reader1 = new BufferedReader(new FileReader(file2))) {
				line = reader1.readLine();
				String newHLine = line + linesplit + "filename";
				bw.write(newHLine);
				bw.newLine();
				
				while((line = reader1.readLine()) != null) {
					newHLine = line + linesplit + "clothing.csv";
					bw.write(newHLine);
					bw.newLine();
				}
			} 
			
			reader = new BufferedReader(new FileReader(file2));
			//loop creates copy of clothing.csv lines in combined.csv
			while(line != null) {
				pw.println(line);
				line = reader.readLine();
			}
			
			// ensures that the data written to writer before this point is actually written to the file
			// closing & flushing prevents content loss
			pw.flush();
			
			// always close! so data being written isn't waiting in a limbo or takes too much time
			bw.close();
			reader.close();
			pw.close();
	
		// Output: email_hash, category, filename
			// ** See input cimments above
			String cfile = "mergedFile.csv";
			File f = new File(cfile);
			
			try { 
				Scanner inputStream = new Scanner(f);
				inputStream.nextLine();
				while(inputStream.hasNext()) {
					String contents = inputStream.nextLine(); 
					System.out.println(contents);
				}
				inputStream.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		
	} 	
}
	
	




/*Consider: 
 * 	files > 2GB
 *	duplicates -> would want to check for duplicates as items are being added to the mergedFile
 *	empty email hashes and/or categories -> empty hashes and/or categories should be filled with Unknown or none 
 */