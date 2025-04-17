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

/*Literales*/
int_literal = -?( 0 | [1-9][0-9]*)
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

{int_literal}               { return symbol(sym.INT_LITERAL); }
{float_literal}             { return symbol(sym.FLOAT_LITERAL); }
{boolean_literal}           { return symbol(sym.BOOLEAN_LITERAL); }
{string_literal}            { return symbol(sym.STRING_LITERAL); }
{char_literal}              { return symbol(sym.CHAR_LITERAL); }
{ID}                        { return symbol(sym.ID); }

{if}                        { return symbol(sym.IF); }
{elif}                      { return symbol(sym.ELIF); }
{else}                      { return symbol(sym.ELSE); }
{while}                     { return symbol(sym.WHILE); }
{for}                       { return symbol(sym.FOR); }
{case}                      { return symbol(sym.CASE); }

{int}                       { return symbol(sym.INT); }
{float}                     { return symbol(sym.FLOAT); }
{boolean}                   { return symbol(sym.BOOLEAN); }
{char}                      { return symbol(sym.CHAR); }
{string}                    { return symbol(sym.STRING); }

{int_matrix}                { return symbol(sym.INT_MATRIX); }
{float_matrix}              { return symbol(sym.FLOAT_MATRIX); }
{string_matrix}             { return symbol(sym.STRING_MATRIX); }
{char_matrix}               { return symbol(sym.CHAR_MATRIX); }
{boolean_matrix}            { return symbol(sym.BOOLEAN_MATRIX); }

"++"                        { return symbol(sym.ADDITION_ONE); }
"--"                        { return symbol(sym.SUBTRACT_ONE); }
"**"                        { return symbol(sym.POWERS); }
"+"                         { return symbol(sym.ADDITION); }
"-"                         { return symbol(sym.SUBTRACT); }
"*"                         { return symbol(sym.MULTIPLICATION); }
"//"                        { return symbol(sym.DIVISION); }
"~"                         { return symbol(sym.MODULE); }

"^"                         { return symbol(sym.CONJUNCTION); }
"#"                         { return symbol(sym.DISJUNCTION); }
"!"                         { return symbol(sym.DENIAL); }

{equal}                     { return symbol(sym.EQ); }
{not_equal}                 { return symbol(sym.NEQ); }
{less_equal}                { return symbol(sym.LE); }
{less_than}                 { return symbol(sym.LT); }
{greater_equal}             { return symbol(sym.GE); }
{greater_than}              { return symbol(sym.GT); } 

{left_bracket}              { return symbol(sym.LBRACKET); }
{right_bracker}             { return symbol(sym.RBRACKET); }
{comma}                     { return symbol(sym.COMMA); }

comment                     { /* Ignorar espacios y saltos de línea */ }
block_comment               { /* Ignorar espacios y saltos de línea */ }

.                           { System.err.println("Carácter inesperado: " + yytext() + " en línea " + (yyline+1)); }

%%

