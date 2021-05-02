import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class SlangWordManager {
	
	public static final String baseSlangPath = "baseSlang.txt";
	public static final String slangPath = "slang.txt";
	
	ArrayList<SlangWord> baseList = new ArrayList<SlangWord>();
	ArrayList<SlangWord> SlangWords = new ArrayList<SlangWord>();
	
	ArrayList<SearchHistory> searchHistory = new ArrayList<SearchHistory>();
	
	Scanner scanner;
	
	//dictionary iterator java
	
	public void Init() throws IOException
	{
		ReadFile(SlangWordManager.baseSlangPath, baseList);
		ReadFile(SlangWordManager.slangPath, SlangWords);
	}
	
	public void ReadFile(String path, ArrayList<SlangWord> listToAdd) throws IOException
	{
		listToAdd.clear();
		File f = new File(path);
		if (f.isFile()) {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String row;
			while ((row = reader.readLine()) != null) {
			    String[] data = row.split("`");
			    
			    SlangWord newOne = new SlangWord(data[0], data[1]);
			    listToAdd.add(newOne);
			}
			reader.close();
		}
	}
	
	public void WriteFile(String path, ArrayList<SlangWord> listToSave) throws IOException
	{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(path));
		
		for(int i = 0; i < listToSave.size(); i++)
		{
			dos.writeBytes(listToSave.get(i).ToStringEndLine());
		}	
		dos.close();
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
			if(word.slang.contains(slang.trim()))
			{
				results.add(word);
			}
		}
		searchHistory.add(new SearchHistory(slang, results, LocalDateTime.now()));
		return results;
	}
	
	public ArrayList<SlangWord> SearchByDefinition(String definition)
	{
		ArrayList<SlangWord> results = new ArrayList<SlangWord>();
		
		for(int i = 0; i < SlangWords.size(); i++)
		{
			SlangWord word = SlangWords.get(i);
			if(word.definition.toLowerCase().contains(definition.trim().toLowerCase()))
			{
				results.add(word);
			}
		}
		searchHistory.add(new SearchHistory(definition, results, LocalDateTime.now()));
		return results;
	}
	
	public void Add(String slang, String definition) throws IOException
	{		
		int existedIndex = IsExisted(slang);
		if(existedIndex != -1)
		{
			int option;
			
			System.out.println("This slang is existed, overwrite or duplicate it?");
			System.out.println("1. Overwrite");
			System.out.println("2. Duplicate");
			System.out.println("3. Cancel");
			System.out.println("--------------------------------");
			System.out.print("Option: ");
			
			scanner = new Scanner(System.in);
			option = scanner.nextInt();
			
			switch(option)
			{
				case 1:
					SlangWords.get(existedIndex).definition = definition;
					WriteFile(slangPath, SlangWords);
					ReadFile(slangPath, SlangWords);
					System.out.println("Overwrited successfully");
					return;
					
				case 2:
					
					break;
					
				default:
					return;
			}
			
		}
		
		SlangWord newWord = new SlangWord(slang, definition);
		SlangWords.add(newWord);
		WriteFile(slangPath, SlangWords);
		ReadFile(slangPath, SlangWords);
		System.out.println("Added successfully");
	}
	
	public int IsExisted(String slang)
	{
		for(int i = 0; i < SlangWords.size(); i++)
		{
			if(SlangWords.get(i).slang.equals(slang))
			{
				return i;
			}
		}
		return -1;
	}
	
	public void Edit(String slang) throws IOException
	{
		int existedIndex = IsExisted(slang);
		if(existedIndex == -1)
		{
			System.out.println("Slang word is not existed");
			return;
		}
		
		SlangWord word = SlangWords.get(existedIndex);
		
		System.out.println("Slang: " + word.slang);
		System.out.println("New definition: ");
		scanner = new Scanner(System.in);
		word.definition = scanner.nextLine();
		WriteFile(slangPath, SlangWords);
		ReadFile(slangPath, SlangWords);
		System.out.println("Edited successfully");		
	}
	
	public void Delete(String slang) throws IOException
	{
		int existedIndex = IsExisted(slang);
		if(existedIndex == -1)
		{
			System.out.println("Slang word is not existed");
			return;
		}
		
		int option;
		System.out.println("Are you sure to delete this slang?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		scanner = new Scanner(System.in);
		option = scanner.nextInt();
		
		switch(option)
		{
			case 1:
				SlangWords.remove(existedIndex);
				WriteFile(slangPath, SlangWords);
				ReadFile(slangPath, SlangWords);
				System.out.println("Deleted successfully");
				break;
				
			default:
				
				break;
		}			
	}
	
	public SlangWord RandomSlangWord()
	{
		Random r = new Random();
		return SlangWords.get(r.nextInt(SlangWords.size()));
	}
	
	public void Quiz(boolean guessDefinition)
	{
		int choose;
		SlangWord question = RandomSlangWord();
		ArrayList<SlangWord> answers = new ArrayList<SlangWord>();
		
		answers.add(question);
		
		for(int i = 0; i < 3; i++)
		{
			answers.add(RandomSlangWord());
		}
		
		Collections.shuffle(answers);
		
		String quiz = guessDefinition ? "Slang: " + question.slang + "?\n" : "Definition: " + question.definition + "?\n";
		System.out.println(quiz);
		
		for(int i = 0; i < answers.size(); i++)
		{
			if(guessDefinition)
			{
				System.out.println((i+1) + ". " + answers.get(i).definition);
			}
			else
			{
				System.out.println((i+1) + ". " + answers.get(i).slang);
			}
		}
		
		System.out.println("\nAnswer: ");
		scanner = new Scanner(System.in);
		choose = scanner.nextInt();
		
		if(choose < 1) choose = 1;
		if(choose > 4) choose = 4;
		
		if(answers.get(choose - 1).equals(question))
		{
			System.out.println("Correct!! " + question.slang + " : " + question.definition);
		}
		else
		{
			System.out.println("Wrong answer!! " + question.slang + " : " + question.definition);
		}
	}
	
	public void Reset()
	{
		SlangWords.clear();
		SlangWords = baseList;
	}
	
	public void ShowSearchHistories()
	{
		if(searchHistory.isEmpty())
		{
			System.out.println("Search history is empty!");
			return;
		}
		
		for(int i = searchHistory.size() - 1; i >= 0; i--)
		{
			searchHistory.get(i).Show();
			System.out.println();
		}
	}
}
