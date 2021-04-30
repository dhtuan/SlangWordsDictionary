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
			//System.out.println("Success on reading file");
		}
	}
	
	public void PrintList(ArrayList<SlangWord> l)
	{
		for(int i = 0; i < l.size(); i++)
		{
			SlangWord word = l.get(i);
			System.out.println(word.slang + " : " + word.definition);
		}
	}
	
	public ArrayList<SlangWord> SearchBySlangWord(String slang)
	{
		ArrayList<SlangWord> results = new ArrayList<SlangWord>();
		
		for(int i = 0; i < SlangWords.size(); i++)
		{
			SlangWord word = SlangWords.get(i);
			if(word.slang.contains(slang))
			{
				results.add(word);
			}
		}		
		return results;
	}
	
	public ArrayList<SlangWord> SearchByDefinition(String definition)
	{
		ArrayList<SlangWord> results = new ArrayList<SlangWord>();
		
		for(int i = 0; i < SlangWords.size(); i++)
		{
			SlangWord word = SlangWords.get(i);
			if(word.definition.contains(definition))
			{
				results.add(word);
			}
		}
		return results;
	}
}
