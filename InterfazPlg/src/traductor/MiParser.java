// $ANTLR : "Gramatica.g" -> "MiParser.java"$

	package traductor;

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;

public class MiParser extends antlr.LLkParser       implements MiParserTokenTypes
 {

protected MiParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public MiParser(TokenBuffer tokenBuf) {
  this(tokenBuf,2);
}

protected MiParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public MiParser(TokenStream lexer) {
  this(lexer,2);
}

public MiParser(ParserSharedInputState state) {
  super(state,2);
  tokenNames = _tokenNames;
}

	public final Traductor  sprog() throws RecognitionException, TokenStreamException {
		Traductor cod=null;;
		
		
		try {      // for error handling
			cod=prog();
			
									System.out.println(cod.getCod());
									System.out.println(cod.getErr());
								
			match(FIN);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		return cod;
	}
	
	public final Traductor  prog() throws RecognitionException, TokenStreamException {
		Traductor cod=null;;
		
		TablaSimbolos TBS;
		
		try {      // for error handling
			TBS=decs();
			cod=accs(TBS);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		return cod;
	}
	
	public final TablaSimbolos  decs() throws RecognitionException, TokenStreamException {
		TablaSimbolos TB = new TablaSimbolos();;
		
		Declaracion dec1; TablaSimbolos TBS;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TIPOREAL:
			case TIPOENT:
			{
				dec1=dec();
				TBS=rdecs();
				
										TBS.insertaDec(dec1);
										TB=TBS;
									
				break;
			}
			case ENTERO:
			case REAL:
			case ID:
			case DELIM_PAREN_A:
			case OP_MENOS:
			case OP_NOT:
			case OP_IN:
			case OP_OUT:
			{
					
					  						TB= new TablaSimbolos();
					  				
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
		return TB;
	}
	
	public final Traductor  accs(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		Traductor cod=null;
		
		Traductor cod1, cod2;
		
		try {      // for error handling
			cod1=acc(TBh);
			cod2=racs(TBh);
				
									cod=cod1.clone();
									cod.setCod(cod.getCod() + cod2.getCod() + "\n");
									cod.setErr(cod.getErr()+cod2.getErr());
														
								
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		return cod;
	}
	
	public final Declaracion  dec() throws RecognitionException, TokenStreamException {
		Declaracion deca = new Declaracion();;
		
		Token  ident = null;
		Traductor nombreTipo; String nombreVar;
		
		try {      // for error handling
			nombreTipo=tipo();
			ident = LT(1);
			match(ID);
			
									nombreVar = ident.getText();
									//System.out.println(nombreVar);
									Declaracion decla = new Declaracion (nombreTipo.getTipo(), nombreVar);
									deca=decla;
								
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
		return deca;
	}
	
	public final TablaSimbolos  rdecs() throws RecognitionException, TokenStreamException {
		TablaSimbolos TBS = new TablaSimbolos();;
		
		
		try {      // for error handling
			match(SEP);
			TBS=rrdecs();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
		return TBS;
	}
	
	public final TablaSimbolos  rrdecs() throws RecognitionException, TokenStreamException {
		TablaSimbolos TBS = new TablaSimbolos();;
		
		
		try {      // for error handling
			TBS=decs();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
		return TBS;
	}
	
	public final Traductor  tipo() throws RecognitionException, TokenStreamException {
		Traductor tipo=null;
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case TIPOREAL:
			{
				
										tipo=new Traductor();
										tipo.setTipo("real");
									
				match(TIPOREAL);
				break;
			}
			case TIPOENT:
			{
				
										tipo=new Traductor();
										tipo.setTipo("entero");
									
				match(TIPOENT);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
		return tipo;
	}
	
	public final Traductor  acc(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		Traductor cod=null;
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case OP_IN:
			{
				cod=in(TBh);
				break;
			}
			case OP_OUT:
			{
				cod=out(TBh);
				break;
			}
			case ENTERO:
			case REAL:
			case ID:
			case DELIM_PAREN_A:
			case OP_MENOS:
			case OP_NOT:
			{
				cod=exp(TBh);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		return cod;
	}
	
	public final Traductor  racs(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		Traductor cod = null;
		
		Traductor cod1; String desap;
		
		try {      // for error handling
			match(SEP);
			cod=rraccs(TBh);
				
									desap="desapila()\n";
									cod.setCod( desap + cod.getCod());
								
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		return cod;
	}
	
	public final Traductor  rraccs(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		Traductor cod=null;
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case ENTERO:
			case REAL:
			case ID:
			case DELIM_PAREN_A:
			case OP_MENOS:
			case OP_NOT:
			case OP_IN:
			case OP_OUT:
			{
				cod=accs(TBh);
				break;
			}
			case FIN:
			{
				cod=new Traductor();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		return cod;
	}
	
	public final Traductor  in(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		Traductor cod = null;
		
		Token  id = null;
		Linea linea;
		
		try {      // for error handling
			match(OP_IN);
			id = LT(1);
			match(ID);
			
												cod=new Traductor();
												if(!TBh.isID(id.getText()))
												{
													cod.setErr(cod.getErr()+"ERROR Lin: "+id.getLine()+", Col: "+id.getColumn()+"--Identificador desconocido\n");
													cod.setTipo("error");
												}
												else
												{
													linea = TBh.getLinea(id.getText().toLowerCase());
													cod.setCod("lectura("+linea.getDirMemoria()+")\n");
													cod.setCod(cod.getCod()+"desapilaDir("+linea.getDirMemoria()+")\n");
													cod.setCod(cod.getCod()+"apilaDir("+linea.getDirMemoria()+")\n");
												}	
											
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		return cod;
	}
	
	public final Traductor  out(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		Traductor cod = null;
		
		Traductor cod1;
		
		try {      // for error handling
			match(OP_OUT);
			cod=exp(TBh);
			
									//cod=cod1.clone();
									cod.setCod(cod.getCod() + "escritura\n");
								
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		return cod;
	}
	
	public final Traductor  exp(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		Traductor cod=null;
		
		Token  ident = null;
		Traductor cod1;Linea linea=null;String tipoLinea="";int direccion=0;
		
		try {      // for error handling
			if ((LA(1)==ID) && (LA(2)==OP_AS)) {
				ident = LT(1);
				match(ID);
				match(OP_AS);
				cod1=accasign(TBh);
				
										if (cod1 != null)
										{
												cod=cod1.clone();
											if(!TBh.isID(ident.getText()))
											{
												cod.setErr(cod.getErr()+"ERROR L:"+ident.getLine()+", C:"+ident.getColumn()+"--Identificador desconocido.\n");
												cod.setTipo("error");
																														
											}
											else
											{										
												linea=TBh.getLinea(ident.getText().toLowerCase());
				//										
											}	
												if(linea==null)
												{
													tipoLinea="error";
													direccion=0x0;
												}
												else
												{
													tipoLinea=linea.getTipo();
													direccion=linea.getDirMemoria();
													//System.out.println("dir:  ->  "+direccion);
													
												}
												//cod.setCod(cod1.getCod()+"desapilaDir("+direccion+")\n");//antigua
												cod.setCod(cod.getCod()+"desapilaDir("+direccion+")\n");//nueva
												cod.setCod(cod.getCod()+"apilaDir("+direccion+")\n");
												
				
												
												cod.setTipo(TBh.tipoResultante(tipoLinea,cod1.getTipo(),2,"="));
													
												if(cod.getTipo()=="error")
													cod.setErr(cod.getErr()+"ERROR L:"+ident.getLine()+", C:"+ident.getColumn()+"--Tipo incompatible para la asignacion.\n");
											
										}
										
									
			}
			else if ((_tokenSet_6.member(LA(1))) && (_tokenSet_7.member(LA(2)))) {
				cod=acccomp(TBh);
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		return cod;
	}
	
	public final Traductor  accasign(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		Traductor cod=null;
		
		
		try {      // for error handling
			cod=exp(TBh);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		return cod;
	}
	
	public final Traductor  acccomp(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		Traductor cod=null;;
		
		Traductor cod1;
		
		try {      // for error handling
			cod1=accadit(TBh);
			cod=racccomp(TBh,cod1);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		return cod;
	}
	
	public final Traductor  accadit(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		Traductor cod=null;;
		
		Traductor cod1;
		
		try {      // for error handling
			cod1=accmult(TBh);
			cod=raccadit(TBh,cod1);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_8);
		}
		return cod;
	}
	
	public final Traductor  racccomp(
		TablaSimbolos TBh, Traductor codh
	) throws RecognitionException, TokenStreamException {
		Traductor cod=null;;
		
		Token  opc = null;
		Token  opi = null;
		Token  opmayq = null;
		Token  opmenq = null;
		Token  opmayoi = null;
		Token  opmenoi = null;
		String op,oper=">";Traductor cod1;int linea=0,columna=0;
		
		try {      // for error handling
			switch ( LA(1)) {
			case OP_IGUAL:
			case OP_COMP:
			case OP_MAYQ:
			case OP_MENQ:
			case OP_MAYOI:
			case OP_MENOI:
			{
				{
				switch ( LA(1)) {
				case OP_COMP:
				{
					opc = LT(1);
					match(OP_COMP);
					break;
				}
				case OP_IGUAL:
				{
					opi = LT(1);
					match(OP_IGUAL);
					break;
				}
				case OP_MAYQ:
				{
					opmayq = LT(1);
					match(OP_MAYQ);
					break;
				}
				case OP_MENQ:
				{
					opmenq = LT(1);
					match(OP_MENQ);
					break;
				}
				case OP_MAYOI:
				{
					opmayoi = LT(1);
					match(OP_MAYOI);
					break;
				}
				case OP_MENOI:
				{
					opmenoi = LT(1);
					match(OP_MENOI);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				cod1=accadit(TBh);
				
										op="";
										if (opi!=null)
										{
											op="igual()\n";
											linea=opi.getLine();
											columna=opi.getColumn();
										}	
										if (opc!=null)
										{
											op="distinto()\n";
											linea=opc.getLine();
											columna=opc.getColumn();
										}
										if (opmayq!=null)
										{
											op="mayor_que()\n";
											linea=opmayq.getLine();
											columna=opmayq.getColumn();
										}
										if(opmenq!=null)
										{
											op="menor_que()\n";
											linea=opmenq.getLine();
											columna=opmenq.getColumn();
										}
										if(opmayoi!=null)
										{
											op="mayor_o_igual()\n";
											linea=opmayoi.getLine();
											columna=opmayoi.getColumn();
										}
										if(opmenoi!=null)
										{
											op="menor_o_igual()\n";
											linea=opmenoi.getLine();
											columna=opmenoi.getColumn();
										}
									
														
											
										cod=codh.clone();
										
									//	System.out.println("tipo: "+codh.getTipo());
									//	System.out.println("tipo: "+cod1.getTipo());
									//	System.out.println("oper: "+oper);
										
										
										
										cod.setTipo(TBh.tipoResultante(codh.getTipo(),cod1.getTipo(),2,oper));
										if(cod.getTipo()=="error")cod.setErr(cod.getErr()+"ERROR L:"+linea+", C:"+columna+"--Tipo incompatible para la expresion.\n");
										cod.setCod(cod.getCod()+cod1.getCod()+op);
										;
									
				break;
			}
			case DELIM_PAREN_C:
			case SEP:
			{
				cod=codh;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		return cod;
	}
	
	public final Traductor  accmult(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		Traductor cod=null;
		
		Traductor cod1;
		
		try {      // for error handling
			cod1=accun(TBh);
			cod=raccmult(TBh,cod1);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_9);
		}
		return cod;
	}
	
	public final Traductor  raccadit(
		TablaSimbolos TBh, Traductor codh
	) throws RecognitionException, TokenStreamException {
		Traductor cod=null;
		
		Token  opma = null;
		Token  opme = null;
		Token  opor = null;
		Traductor cod1,cod2;String op="", oper="+";int linea=0,columna=0;
		
		try {      // for error handling
			switch ( LA(1)) {
			case OP_MAS:
			case OP_MENOS:
			case OP_OR:
			{
				{
				switch ( LA(1)) {
				case OP_MAS:
				{
					opma = LT(1);
					match(OP_MAS);
					break;
				}
				case OP_MENOS:
				{
					opme = LT(1);
					match(OP_MENOS);
					break;
				}
				case OP_OR:
				{
					opor = LT(1);
					match(OP_OR);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				cod1=accmult(TBh);
				
										if (opma!=null)
										{
											linea=opma.getLine();
											columna=opma.getColumn();
											op="suma()\n";
										}
										if (opme!=null)
										{
											linea=opme.getLine();
											columna=opme.getColumn();
											op="resta()\n";
										}
										if (opor!=null)
										{
											linea=opor.getLine();
											columna=opor.getColumn();
											op="or()\n";
											oper="||";
										}
										cod2=codh.clone();	
										cod2.setTipo(TBh.tipoResultante(codh.getTipo(),cod1.getTipo(),2,oper));
										if(cod2.getTipo()=="error")cod2.setErr(cod2.getErr()+cod1.getErr()+"ERROR L:"+linea+", C:"+columna+"--Tipo incompatible para la operacion binaria.\n");
										cod2.setCod(cod2.getCod()+cod1.getCod()+op);
									
				cod=raccadit(TBh,cod2);
				break;
			}
			case DELIM_PAREN_C:
			case OP_IGUAL:
			case OP_COMP:
			case SEP:
			case OP_MAYQ:
			case OP_MENQ:
			case OP_MAYOI:
			case OP_MENOI:
			{
				cod=codh;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_8);
		}
		return cod;
	}
	
	public final Traductor  accun(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		Traductor cod=null;;
		
		Token  opme = null;
		Token  opno = null;
		String op,oper="";Traductor cod1,cod2;int linea=0,columna=0;
		
		try {      // for error handling
			if ((_tokenSet_10.member(LA(1))) && (_tokenSet_11.member(LA(2)))) {
				cod=factor(TBh);
			}
			else if ((LA(1)==OP_MENOS||LA(1)==OP_NOT)) {
				{
				switch ( LA(1)) {
				case OP_MENOS:
				{
					opme = LT(1);
					match(OP_MENOS);
					break;
				}
				case OP_NOT:
				{
					opno = LT(1);
					match(OP_NOT);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				cod1=factor(TBh);
				
							 			op="";
							 			if (opme!=null)
							 			{
							 				op="invierte()\n";
							 				linea=opme.getLine();
											columna=opme.getColumn();
											oper="-";
							 				
							 			}
							 			else if (opno!=null)
							 				{
							 					op="not()\n";
							 					linea=opno.getLine();
												columna=opno.getColumn();
												oper="!";
							 				}
							 			cod=cod1.clone();	
							 			cod.setCod(cod.getCod() + op);
							 			cod.setTipo(TBh.tipoResultante(cod1.getTipo(),"",1,oper));
										if(cod.getTipo()=="error")cod.setErr(cod.getErr()+"ERROR L:"+linea+", C:"+columna+"--Tipo incompatible para la operacion unaria.\n");
							 			
							 		
			}
			else if ((LA(1)==DELIM_PAREN_A) && (LA(2)==TIPOREAL||LA(2)==TIPOENT)) {
				match(DELIM_PAREN_A);
				cod1=tipo();
				match(DELIM_PAREN_C);
				cod2=factor(TBh);
				
										cod=cod2.clone();
										cod.setCod(cod2.getCod() + "convierte_"+cod1.getCod()+"()\n");
										cod.setTipo(cod1.getTipo());
									
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_12);
		}
		return cod;
	}
	
	public final Traductor  raccmult(
		TablaSimbolos TBh,Traductor codh
	) throws RecognitionException, TokenStreamException {
		Traductor cod=null;;
		
		Token  opmu = null;
		Token  opdiv = null;
		Token  opan = null;
		Token  opmo = null;
		Traductor cod1,cod2=new Traductor();String op,oper="";int linea=0,columna=0;
		
		try {      // for error handling
			switch ( LA(1)) {
			case OP_MOD:
			case OP_AND:
			case OP_MUL:
			case OP_DIV:
			{
				{
				switch ( LA(1)) {
				case OP_MUL:
				{
					opmu = LT(1);
					match(OP_MUL);
					break;
				}
				case OP_DIV:
				{
					opdiv = LT(1);
					match(OP_DIV);
					break;
				}
				case OP_AND:
				{
					opan = LT(1);
					match(OP_AND);
					break;
				}
				case OP_MOD:
				{
					opmo = LT(1);
					match(OP_MOD);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				cod1=accun(TBh);
				
													op="";
													if (opmu!=null)
													{
														linea=opmu.getLine();
														columna=opmu.getColumn();
														oper="*";
														op="multiplicacion()\n";
													}
													if (opdiv!=null)
													{
														linea=opdiv.getLine();
														columna=opdiv.getColumn();
														op="division()\n";
														oper="/";
													}
													if (opan!=null)
													{
														oper="&&";
														linea=opan.getLine();
														columna=opan.getColumn();
														op="and()\n";
													}
													if (opmo!=null)
													{
														oper="%";
														op="modulo()\n";
														linea=opmo.getLine();
														columna=opmo.getColumn();
													}
													cod2=codh.clone();
													cod2.setTipo(TBh.tipoResultante(codh.getTipo(),cod1.getTipo(),2,oper));
													if(cod2.getTipo()=="error")
														cod2.setErr(cod2.getErr()+cod1.getErr()+"ERROR L:"+linea+", C:"+columna+"--Tipo incompatible para la operacion binaria.\n");
													cod2.setCod(codh.getCod()+cod1.getCod()+op);
													
										
												
				cod=raccmult(TBh,cod2);
				break;
			}
			case DELIM_PAREN_C:
			case OP_IGUAL:
			case OP_MAS:
			case OP_MENOS:
			case OP_OR:
			case OP_COMP:
			case SEP:
			case OP_MAYQ:
			case OP_MENQ:
			case OP_MAYOI:
			case OP_MENOI:
			{
				cod=codh;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_9);
		}
		return cod;
	}
	
	public final Traductor  factor(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		Traductor cod=null;;
		
		Token  iden = null;
		Linea linea;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ENTERO:
			case REAL:
			{
				cod=num();
				break;
			}
			case ID:
			{
				iden = LT(1);
				match(ID);
					
										cod=new Traductor();
										if(!TBh.isID(iden.getText()))
										{
											cod.setErr(cod.getErr()+"ERROR L:"+iden.getLine()+", C:"+iden.getColumn()+"--Identificador desconocido.\n");
											cod.setTipo("error");
										}
										else
										{
											linea=TBh.getLinea(iden.getText().toLowerCase());
											cod.setCod("apilaDir("+linea.getDirMemoria()+")\n");
											cod.setTipo(TBh.getTipo(iden.getText()));
										}
				
									
				break;
			}
			case DELIM_PAREN_A:
			{
				match(DELIM_PAREN_A);
				cod=acc(TBh);
				match(DELIM_PAREN_C);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_12);
		}
		return cod;
	}
	
	public final Traductor  num() throws RecognitionException, TokenStreamException {
		Traductor cod=null;;
		
		Token  r = null;
		Token  e = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case REAL:
			{
				r = LT(1);
				match(REAL);
				
										cod=new Traductor();
										cod.setCod("apila("+r.getText()+")\n");
										cod.setTipo("real");
				
									
				break;
			}
			case ENTERO:
			{
				e = LT(1);
				match(ENTERO);
				
										cod=new Traductor();
										cod.setCod("apila("+e.getText()+")\n");
										cod.setTipo("entero");
									
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_12);
		}
		return cod;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"ENTERO",
		"REAL",
		"ID",
		"Whitespace",
		"DELIM_PUNTOCOMA",
		"DELIM_PAREN_A",
		"DELIM_PAREN_C",
		"OP_IGUAL",
		"OP_AS",
		"OP_MAS",
		"OP_MENOS",
		"OP_MOD",
		"OP_MUL_DIV",
		"OP_OR",
		"OP_AND",
		"OP_NOT",
		"OP_COMP",
		"OP_IN",
		"OP_OUT",
		"FIN",
		"ASIG_IGUAL",
		"INT_O_REAL",
		"COMP1_2",
		"NOT_COMP",
		"SEP",
		"OP_MAYQ",
		"OP_MENQ",
		"OP_MAYOI",
		"OP_MENOI",
		"OP_MUL",
		"OP_DIV",
		"TIPOREAL",
		"TIPOENT",
		"LETRA",
		"DIGITO",
		"DELIM_PUNTO",
		"SALTODELINEA",
		"COMP1",
		"COMP2",
		"ID_TIPO_OPIN_OPOUT",
		"COMENTARIO",
		"ERRORES"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 8388608L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 6832752L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 268435456L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 1088L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 268436480L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 541296L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 137178836592L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 8322550784L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 8322706432L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 624L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 34099621488L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = { 34092805120L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	
	}
