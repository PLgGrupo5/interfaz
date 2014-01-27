package traductor;

//import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import antlr.ANTLRException;
import antlr.CommonAST;
//import antlr.ParseTree;
//import antlr.Token;
//import antlr.TokenStream;
//import antlr.TokenStreamException;
//import antlr.collections.AST;


public class Principal {
//private static String fileName = "prueba1.txt";
private static FileInputStream fis = null;

	public static void main(String args[]) {
		try
		{
			System.out.println("Scanning file...");
			fis = new FileInputStream("Para revisar.txt");
			MiLexer scan = new MiLexer(fis);
			/* Solo AnaLexico
			Token token = scan.nextToken();
			while(token.getType() != Token.EOF_TYPE){
				System.out.println(token);
				token = scan.nextToken();
			}
			*/
			MiParser par = new MiParser(scan);
			par.sprog();
			System.out.println(scan.erroresLexicos);
			CommonAST a = (CommonAST)par.getAST();
			System.out.println("Resultado ASA: "+a.toStringList());
		}catch (ANTLRException ae){
			System.err.println(ae.getMessage() + "y aqui intervenimos");
		}catch (NullPointerException ae){
			System.err.println(ae.getMessage());
			System.err.println(ae.getMessage());
		}
		catch(FileNotFoundException fnfe){
			System.err.println("No se encontr� el fichero");
		}
	}
}