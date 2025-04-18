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

/* Definiciones de expresiones regulares */

/*Literales*/
int_literal = -?( 0 | [1-9][0-9]*);
float_literal = -?( 0 | [1-9][0-9]*\.[0-9]*[1-9])
boolean_literal = "luna"|"sol"
string_literal = \"([^\"\\]|\\.)*\"
char_literal = \'([^\'\\]|\\.)\'
ID = [A-Za-z][_A-Za-z0-9]*
space  = [ \t\r\n]+

/* Arreglos */
left_bracket = "["
right_bracker = "]"
comma = ","

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
comment = "@"
block_comment = "{" (.)* "}"

%%

/* Reglas léxicas y acciones (acciones de Java) */

{space}                     { /* Ignorar espacios y saltos de línea */ }

{int_literal}               { return symbol(sym.INT_LITERAL, yytext()); }
{float_literal}             { return symbol(sym.FLOAT_LITERAL, yytext()); }
{boolean_literal}           { return symbol(sym.BOOLEAN_LITERAL, yytext()); }
{string_literal}            { return symbol(sym.STRING_LITERAL, yytext()); }
{char_literal}              { return symbol(sym.CHAR_LITERAL, yytext()); }

{if}                        { return symbol(sym.IF, yytext()); }
{elif}                      { return symbol(sym.ELIF, yytext()); }
{else}                      { return symbol(sym.ELSE, yytext()); }
{while}                     { return symbol(sym.WHILE, yytext()); }
{for}                       { return symbol(sym.FOR, yytext()); }
{case}                      { return symbol(sym.CASE, yytext()); }

{int}                       { return symbol(sym.INT, yytext()); }
{float}                     { return symbol(sym.FLOAT, yytext()); }
{boolean}                   { return symbol(sym.BOOLEAN, yytext()); }
{char}                      { return symbol(sym.CHAR, yytext()); }
{string}                    { return symbol(sym.STRING, yytext()); }

{int_matrix}                { return symbol(sym.INT_MATRIX, yytext()); }
{float_matrix}              { return symbol(sym.FLOAT_MATRIX, yytext()); }
{string_matrix}             { return symbol(sym.STRING_MATRIX, yytext()); }
{char_matrix}               { return symbol(sym.CHAR_MATRIX, yytext()); }
{boolean_matrix}            { return symbol(sym.BOOLEAN_MATRIX, yytext()); }

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

{left_bracket}              { return symbol(sym.LBRACKET, yytext()); }
{right_bracker}             { return symbol(sym.RBRACKET, yytext()); }
{comma}                     { return symbol(sym.COMMA, yytext()); }

{comment}                   { /* Ignorar espacios y saltos de línea */ }
{block_comment}             { /* Ignorar espacios y saltos de línea */ }

{ID}                        { return symbol(sym.ID, yytext()); }

.                           { System.err.println("Carácter inesperado: " + yytext() + " en línea " + (yyline+1)); }