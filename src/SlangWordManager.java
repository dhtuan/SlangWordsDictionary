import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SlangWordManager {
	ArrayList<SlangWord> SlangWords = new ArrayList<SlangWord>();
	
	public void ReadFile() throws IOException
	{
		File f = new File("slang.txt");
		if (f.isFile()) {
			BufferedReader reader = new BufferedReader(new FileReader("slang.txt"));
			String row;
			while ((row = reader.readLine()) != null) {
				//System.out.println(row);
			    String[] data = row.split("`");
			    
			    SlangWord newOne = new SlangWord(data[0], data[1]);
			    SlangWords.add(newOne);
			}
			reader.close();
			System.out.println("Success on reading file");
		}
	}
	
	public SlangWord SearchBySlangWord(String slang)
	{
		for(int i = 0; i < SlangWords.size(); i++)
		{
			if(SlangWords.get(i).slang.equals(slang))
			{
				return SlangWords.get(i);
			}
		}
		
		return null;
	}
}
