import java.time.LocalDateTime;
import java.util.ArrayList;

public class SearchHistory {
	public String keyword;
	public ArrayList<SlangWord> searchedWords = new ArrayList<SlangWord>();
	public LocalDateTime time;
	
	public SearchHistory() {}
	
	public SearchHistory(String keyword, ArrayList<SlangWord> searchResults, LocalDateTime time)
	{
		this.keyword = keyword;
		searchedWords = searchResults;
		this.time = time;
	}
	
	public void Show()
	{
		System.out.println(time + " - Keyword: " + keyword);
		for(int i = 0; i < searchedWords.size(); i++)
		{
			System.out.println(searchedWords.get(i).ToString());
		}
	}
}
