import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		SlangWordManager swm = new SlangWordManager();
	
		swm.ReadFile();
		
		System.out.println(swm.SlangWords.size());
		
		Scanner scanner;
		int option;
		
		do
		{
			System.out.println("--------------------------------");
			System.out.println("Slang Word Dictionary");
			System.out.println("1. Search by slang word");
			System.out.println("2. Search by definition");
			System.out.println("3. Show search history");
			System.out.println("4. Add new slang word");
			System.out.println("5. Edit slang word");
			System.out.println("6. Delete slang word");
			System.out.println("7. Reset");
			System.out.println("8. Random slang word");
			System.out.println("9. Guess the definition game");
			System.out.println("10. Guess the slang word game");
			System.out.println("11. Quit");
			System.out.println("--------------------------------");
			System.out.print("Option: ");
			
			scanner = new Scanner(System.in);
			option = scanner.nextInt();
			
			switch(option)
			{
				case 1:
					String slangWordSearchKey;
					System.out.println("1. Enter slang to search:");
					scanner = new Scanner(System.in);
					slangWordSearchKey = scanner.nextLine();
					SlangWord slangWordSearchResult = swm.SearchBySlangWord(slangWordSearchKey);
					if(slangWordSearchResult != null)
					{
						System.out.println(slangWordSearchResult.slang + " : " + slangWordSearchResult.definition);
					}
					else
					{
						System.out.println("No result");
					}
					break;
					
				case 2:
					String definitionSearchKey;
					System.out.println("2. Enter definition to search:");
					scanner = new Scanner(System.in);
					definitionSearchKey = scanner.nextLine();
					SlangWord definitionSearchResult = swm.SearchByDefinition(definitionSearchKey);
					if(definitionSearchResult != null)
					{
						System.out.println(definitionSearchResult.slang + " : " + definitionSearchResult.definition);
					}
					else
					{
						System.out.println("No result");
					}
					break;
					
				case 3:
					System.out.println("3.");
					break;
					
				case 4:
					System.out.println("4.");
					break;
					
				case 5:
					System.out.println("5.");
					break;
					
				case 6:
					System.out.println("6.");
					break;
					
				case 7:
					System.out.println("7.");
					break;
					
				case 8:
					System.out.println("8.");
					break;
					
				case 9:
					System.out.println("9.");
					break;
					
				case 10:
					System.out.println("10.");
					break;
					
				case 11:
					System.out.println("Quit");
					break;
					
				default:
					System.out.println("No such option. Choose again.");
					break;
			}
		}
		while(option != 11);	
	}
	
}
