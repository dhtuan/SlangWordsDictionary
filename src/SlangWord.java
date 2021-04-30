
public class SlangWord {
	public String slang;
	public String definition;
	
	public SlangWord(){}
	
	public SlangWord(String s, String d)
	{
		slang = s;
		definition = d;
	}
	
	public String ToString()
	{
		return slang + "`" + definition + "\n";
	}
}
