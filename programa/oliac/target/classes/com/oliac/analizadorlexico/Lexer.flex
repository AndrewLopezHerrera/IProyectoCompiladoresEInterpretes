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

  // Método auxiliar para generar un objeto Symbol
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }
%}

%%
/* Definiciones de expresiones regulares */

/*Declaraciones*/
int_literal = -?( 0 | [1-9][0-9]*)
float_literal = -?( 0 | [1-9][0-9]*\.[0-9]*[1-9])
boolean_literal = "luna"|"sol"
string_literal = \"([^\"\\]|\\.)*\"
char_literal = \'([^\'\\]|\\.)\'
ID = [A-Za-z][_A-Za-z0-9]*
space  = [ \t\r\n]+

/*Estructuras de control*/
if = "if"
elif = "elif"
else = "else"
while = "while"
for = "for"
case = "case"

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

%%

/* Reglas léxicas y acciones (acciones de Java) */

{space}                     { /* Ignorar espacios y saltos de línea */ }

{if}                        { return symbol(sym.IF); }
{elif}                      { return symbol(sym.ELIF); }
{else}                      { return symbol(sym.ELSE); }
{while}                     { return symbol(sym.WHILE); }
{for}                       { return symbol(sym.FOR); }
{case}                      { return symbol(sym.CASE); }

"int"                       { return symbol(sym.INT); }
"float"                     { return symbol(sym.FLOAT); }
"boolean"                   { return symbol(sym.BOOLEAN); }
"char"                      { return symbol(sym.CHAR); }
"string"                    { return symbol(sym.STRING); }

int_matrix                  { return symbol(sym.INT_MATRIX); }
float_matrix                { return symbol(sym.FLOAT_MATRIX); }
string_matrix               { return symbol(sym.STRING_MATRIX); }
char_matrix                 { return symbol(sym.CHAR_MATRIX); }
boolean_matrix              { return symbol(sym.BOOLEAN_MATRIX); }

.                           { System.err.println("Carácter inesperado: " + yytext() + " en línea " + (yyline+1)); }


%%

