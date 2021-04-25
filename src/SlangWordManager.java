import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SlangWordManager {
	HashMap<String, String> 
	
	public void ReadCSV() throws IOException
	{
		File csvFile = new File("a.csv");
		if (csvFile.isFile()) {
			BufferedReader csvReader = new BufferedReader(new FileReader("a.csv"));
			String row;
			while ((row = csvReader.readLine()) != null) {
			    String[] data = row.split(",");
			    
			    Student newOne = new Student(data[0], data[1], Float.parseFloat(data[2]), data[3], data[4], data[5]);
			    studentList.add(newOne);
			}
			csvReader.close();
			System.out.println("Đọc file csv thành công");
		}
	}
}
