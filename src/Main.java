import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		SlangWordManager swm = new SlangWordManager();
	
		swm.Init();
		
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
					ArrayList<SlangWord> slangWordSearchResults = swm.SearchBySlangWord(slangWordSearchKey);
					if(!slangWordSearchResults.isEmpty())
					{
						System.out.println("Result:");
						swm.PrintList(slangWordSearchResults);
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
					ArrayList<SlangWord> definitionSearchResults = swm.SearchByDefinition(definitionSearchKey);
					if(!definitionSearchResults.isEmpty())
					{
						swm.PrintList(definitionSearchResults);
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
					System.out.println("4. New slang word");
					
					String newSlangWord;
					System.out.println("Slang:");
					scanner = new Scanner(System.in);
					newSlangWord = scanner.nextLine();
					
					String definition;
					System.out.println("Definition:");
					scanner = new Scanner(System.in);
					definition = scanner.nextLine();
					
					swm.Add(newSlangWord, definition);
					break;
					
				case 5:
					System.out.println("5. Edit slang word");
					String editWord;
					System.out.println("Slang:");
					scanner = new Scanner(System.in);
					editWord = scanner.nextLine();
					swm.Edit(editWord);
					break;
					
				case 6:
					System.out.println("6. Delete slang word");
					String deleteWord;
					System.out.println("Slang:");
					scanner = new Scanner(System.in);
					deleteWord = scanner.nextLine();
					swm.Delete(deleteWord);
					break;
					
				case 7:
					System.out.println("7.Reset ");
					swm.Reset();
					break;
					
				case 8:
					System.out.println("8. Random slang word");
					SlangWord randomWord = swm.RandomSlangWord();
					System.out.println(randomWord.slang + " : " + randomWord.definition);
					break;
					
				case 9:
					System.out.println("9. Guess the definition game");
					swm.Quiz(true);
					break;
					
				case 10:
					System.out.println("10. Guess the slang word game");
					swm.Quiz(false);
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
