import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SlangWordManager {
	ArrayList<SlangWord> SlangWords = new ArrayList<SlangWord>();
	
	public void ReadCSV() throws IOException
	{
		File csvFile = new File("slang.txt");
		if (csvFile.isFile()) {
			BufferedReader csvReader = new BufferedReader(new FileReader("slang.txt"));
			String row;
			while ((row = csvReader.readLine()) != null) {
			    String[] data = row.split(",");
			    
			    SlangWord newOne = new SlangWord(data[0], data[1]);
			    SlangWords.add(newOne);
			}
			csvReader.close();
			System.out.println("Đọc file csv thành công");
		}
	}
}
