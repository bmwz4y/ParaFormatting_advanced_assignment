
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ParagraphDriver {
	public static void main(String[] args) {
		System.out.println("Welcome to the Document Formatter!");

		Scanner stdIn = new Scanner(System.in);

		System.out.print("Enter style filename: ");
		String styleName = stdIn.nextLine();

		System.out.print("Enter document filename: ");
		String documentName = stdIn.nextLine();

		System.out.print("Enter output filename: ");
		String outName = stdIn.nextLine();

		try(Scanner stylScanner = new Scanner(new File("src/" + styleName));
				Scanner docScanner = new Scanner(new File("src/" + documentName));
				PrintWriter outPrintWriter = new PrintWriter(outName);){
			
			Map<String, ParaStyle> stylesMap = readStyles(stylScanner);
			formatDocument(docScanner, outPrintWriter, stylesMap);
		}
		catch(FileNotFoundException e){
			System.out.println("Couldn't open file: " + e.getMessage());
		}
		finally{
			System.out.println("Good bye!");
			stdIn.close();
		}
	}

	public static Map<String, ParaStyle> readStyles(Scanner styleScanner) {
		Map<String, ParaStyle> styles = new HashMap<String, ParaStyle>();
		String name;
		int leftI;
		int lineL;
		int firstLA;
		
		while(styleScanner.hasNextLine())
		{
			name = styleScanner.next();
			leftI = styleScanner.nextInt();
			lineL = styleScanner.nextInt();
			firstLA = styleScanner.nextInt();
			ParaStyle pS = new ParaStyle(name, leftI, lineL, firstLA);
			styles.put(name, pS);
		}
		return styles;
	}

	public static void formatDocument(Scanner documentScanner, PrintWriter outputFileWriter, Map<String, ParaStyle> styles){
		String line = "";
		String paraKey = "";
		Paragraph p = new Paragraph();
		while(documentScanner.hasNextLine())
		{
			line = documentScanner.nextLine();
			if(line.startsWith(".P ")){
				outputFileWriter.print(p.format(styles.get(paraKey)));//had to flush before changing paraKey
				paraKey = line.substring(3, line.length());
				p = new  Paragraph();
			}
			else{
				p.addWords(line);
			}
		}
		outputFileWriter.print(p.format(styles.get(paraKey)));
	}

}
