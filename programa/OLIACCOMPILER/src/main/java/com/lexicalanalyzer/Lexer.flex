package com.lexicalanalyzer;

import java_cup.runtime.Symbol;
import com.lexicalanalyzer.sym.*;

%%

%class MiLexer            // Clase generada: MiLexer
%unicode                  // Soporte para Unicode
%public                   // La clase es pública
%cup                      // Se usará con Java CUP (opcional)
%line                     // Para el número de línea
%column                   // Para el número de columna

%{
  // Este es el código Java que se incluirá al principio de la clase generada.
  	private int contador = 0;  // Variable para contar identificadores
        private int line = 1;
	
	private TablaDeSimbolos tablaSimbolos;

	private Symbol symbol(int type, Object value) {
    		return new Symbol(type, yyline, yycolumn, value);
  	}

	private Symbol symbol(int type, int line, int column, Object value) {
            return new Symbol(type, line, column, value);
        }
        
        // Método público para que el parser pueda consultarlo
        public int getLine() {
          return line;
        }

        // Cada vez que veamos '\n' llamamos a este método
        private void newline() {
          line++;
        }

%}

/* Definiciones de expresiones regulares */
/*Asignacion*/
assign = "="

/*Literales*/
int_literal = -?(0|[1-9][0-9]*)
float_literal = -?([1-9][0-9]*|0)\.([0-9]*[1-9]|0)
boolean_literal = "luna"|"sol"
string_literal = \"([^\"\\]|\\.)*\"
char_literal = \'([^\'\\]|\\.)\'
ID = [_A-Za-z][_A-Za-z0-9]*
space  = [ \t]+
line = [\r\n]

/* Arreglos */
bracket = "|"
left_bracket = "["
right_bracker = "]"
comma = ","

/*Estructuras de control*/
if = "if"
elif = "elif"
else = "else"
while = "while"
for = "for"
do = "do"
break = "break"
return = "return"

/*Tipos de datos*/
int = "int"
float = "float"
boolean = "boolean"
char = "char"
string = "string"
int_matrix = "int"[ \t\r\n]*"[][]"
float_matrix = "float"[ \t\r\n]*"[][]"
char_matrix = "char"[ \t\r\n]*"[][]"
string_matrix = "string"[ \t\r\n]*"[][]"
boolean_matrix = "boolean"[ \t\r\n]*"[][]"

/*Operadores arimeticos*/
adition_one = "++"
substract_one = "--"
powers = "**"
addition  = "+"
subtract  = "-"
multiplication = "*"
division = "//"
module = "~"

/*Operadores lógicos*/
conjunction = "^"
disjunction = "#"
denial = "!"

/*Operadores de comparación*/
equal = "=="
not_equal = "!="
less_equal = "<="
less_than = "<"
greater_equal = ">="
greater_than = ">"

/*Comentarios*/
comment = "@" [^\n]*
block_comment = "{" [^{}\n]* (\n [^{}\n]*)* "}"

/*Otros*/
parenthesis_l = "ʃ"
parenthesis_r = "ʅ"
end_line = "\?"
open_block = "\\"
close_block = "/"
main = "main"
void = "void"

/*Lectura escritura*/
read_int = "readInt" [ \t\r\n]* "<-" [ \t\r\n]* 
read_float = "readFloat" [ \t\r\n]* "<-" [ \t\r\n]* 
write_int = "writeInt" [ \t\r\n]* "->" [ \t\r\n]*
write_float = "writeFloat" [ \t\r\n]* "->" [ \t\r\n]*
write_string = "writeString" [ \t\r\n]* "->" [ \t\r\n]*
write_boolean = "writeBoolean" [ \t\r\n]* "->" [ \t\r\n]* 

%%


/* Reglas léxicas y acciones (acciones de Java) */

{space}                     { /* Ignorar espacios y saltos de línea */ }
{line}                      { for (char c : yytext().toCharArray()) if (c == '\n') newline(); }

{int_literal}               { return symbol(sym.INT_LITERAL, yytext()); }

{if}                        { return symbol(sym.IF, yytext()); }
{elif}                      { return symbol(sym.ELIF, yytext()); }
{else}                      { return symbol(sym.ELSE, yytext()); }
{while}                     { return symbol(sym.WHILE, yytext()); }
{for}                       { return symbol(sym.FOR, yytext()); }
{do}                        { return symbol(sym.DO, yytext()); }
{break}                     { return symbol(sym.BREAK, yytext()); }
{return}                    { return symbol(sym.RETURN, yytext()); }

{int}                       { return symbol(sym.INT, yyline, yycolumn, "int"); }
{float}                     { return symbol(sym.FLOAT, yyline, yycolumn, "float"); }
{boolean}                   { return symbol(sym.BOOLEAN, yyline, yycolumn, "boolean"); }
{char}                      { return symbol(sym.CHAR, yyline, yycolumn, "char"); }
{string}                    { return symbol(sym.STRING, yyline, yycolumn, "string"); }
{void}                      { return symbol(sym.VOID, yyline, yycolumn, "void"); }

{int_matrix}                { return symbol(sym.INT_MATRIX, yyline, yycolumn, "int[][]"); }
{float_matrix}              { return symbol(sym.FLOAT_MATRIX, yyline, yycolumn, "float[][]"); }
{char_matrix}               { return symbol(sym.CHAR_MATRIX, yyline, yycolumn, "char[][]"); }
{string_matrix}             { return symbol(sym.STRING_MATRIX, yyline, yycolumn, "string[][]"); }
{boolean_matrix}            { return symbol(sym.BOOLEAN_MATRIX, yyline, yycolumn, "boolean[][]"); }

{adition_one}               { return symbol(sym.ADDITION_ONE, yytext()); }
{substract_one}             { return symbol(sym.SUBTRACT_ONE, yytext()); }
{powers}                    { return symbol(sym.POWERS, yytext()); }
{addition}                  { return symbol(sym.ADDITION, yytext()); }
{subtract}                  { return symbol(sym.SUBTRACT, yytext()); }
{multiplication}            { return symbol(sym.MULTIPLICATION, yytext()); }
{division}                  { return symbol(sym.DIVISION, yytext()); }
{module}                    { return symbol(sym.MODULE, yytext()); }

{conjunction}               { return symbol(sym.CONJUNCTION, yytext()); }
{disjunction}               { return symbol(sym.DISJUNCTION, yytext()); }
{denial}                    { return symbol(sym.DENIAL, yytext()); }

{equal}                     { return symbol(sym.EQ, yytext()); }
{not_equal}                 { return symbol(sym.NEQ, yytext()); }
{less_equal}                { return symbol(sym.LE, yytext()); }
{less_than}                 { return symbol(sym.LT, yytext()); }
{greater_equal}             { return symbol(sym.GE, yytext()); }
{greater_than}              { return symbol(sym.GT, yytext()); } 

{bracket}                   { return symbol(sym.BRACKET, yytext()); }
{left_bracket}              { return symbol(sym.LBRACKET, yytext()); }
{right_bracker}             { return symbol(sym.RBRACKET, yytext()); }
{comma}                     { return symbol(sym.COMMA, yytext()); }

{comment}                   { /* Ignorar espacios y saltos de línea */ }
{block_comment}             { /* Ignorar espacios y saltos de línea */ }

{parenthesis_l}             { return symbol(sym.PARENTHESIS_L, yytext()); }
{parenthesis_r}             { return symbol(sym.PARENTHESIS_R, yytext()); }
{end_line}                  { return symbol(sym.END_LINE, yytext()); }

{read_int}                  { return symbol(sym.READ_INT, yytext()); }
{read_float}                { return symbol(sym.READ_FLOAT, yytext()); }
{write_int}                 { return symbol(sym.WRITE_INT, yytext()); }
{write_float}               { return symbol(sym.WRITE_FLOAT, yytext()); }
{write_string}              { return symbol(sym.WRITE_STRING, yytext()); }
{write_boolean}             { return symbol(sym.WRITE_BOOLEAN, yytext()); }
{main}                      { return symbol(sym.MAIN, yytext()); }

{assign}                    { return symbol(sym.ASSIGN, yytext()); }

{boolean_literal}           { return symbol(sym.BOOLEAN_LITERAL, yytext()); }
{string_literal}            { return symbol(sym.STRING_LITERAL, yytext()); }
{char_literal}              { return symbol(sym.CHAR_LITERAL, yytext()); }
{float_literal}             { return symbol(sym.FLOAT_LITERAL, yytext()); }

{open_block}                { return symbol(sym.OPEN_BLOCK, yytext()); }
{close_block}               { return symbol(sym.CLOSE_BLOCK, yytext()); }

{ID}                        { return symbol(sym.ID, yytext()); }

.                           { System.err.println("Error léxico: carácter inesperado '" + yytext() + "' en línea " + (yyline + 1) + ", columna " + (yycolumn + 1) + ", posición " + yychar ); }
