package com.mipstranslator;

import java_cup.runtime.Symbol;
import com.mipstranslator.sym;

%%

%class MiLexer
%unicode
%public
%cup
%line
%column

%{
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }

%}

/* ====== DEFINICIONES DE EXPRESIONES REGULARES ====== */

/* Espacios y saltos de línea */
space              = [ \t]+
line_ending        = \r\n|[\r\n]

/* Literales */
int_literal        = -?(0|[1-9][0-9]*)
float_literal      = -?([1-9][0-9]*|0)\.([0-9]*[1-9]|0)
boolean_literal    = "luna"|"sol"
string_literal     = \"([^\"\\]|\\.)*\"  // string entre comillas dobles
char_literal       = \'([^\'\\]|\\.)\'  // char entre comillas simples

/* Identificadores y temporales */
ID                 = [_A-Za-z][_A-Za-z0-9]*
temp               = t[0-9]+

/* Tipos de datos */
int_kw             = "int"
float_kw           = "float"
boolean_kw         = "boolean"
char_kw            = "char"
string_kw          = "string"
arrayint_kw        = "intArray"

/* Operadores aritméticos */
pow                = "**"
add                = "+"
sub                = "-"
mul                = "*"
div                = "/"
mod                = "~"

/* Operadores lógicos */
and                = "^"
or                 = "#"
not                = "!"

/* Comparadores */
eq                 = "=="
neq                = "!="
le                 = "<="
lt                 = "<"
ge                 = ">="
gt                 = ">"

/* Asignación */
assign             = "="

/* Arreglos */
lbrack             = "["
rbrack             = "]"
pipe               = "|"
comma              = ","

/* Instrucciones especiales */
function           = "funcion"
load_kw            = "load"
store_kw           = "store"
copy_kw            = "copy"
param_kw           = "param"
call_kw            = "call"
return_kw          = "return"
goto_kw            = "goto"
if_kw              = "if"
iffalse_kw         = "ifFalse"

/* Entrada/Salida */
read_int_kw        = "READ_INT"
read_float_kw      = "READ_FLOAT"
write_int_kw       = "WRITE_INT"
write_float_kw     = "WRITE_FLOAT"
write_string_kw    = "WRITE_STRING"
write_boolean_kw   = "WRITE_BOOLEAN"

/* Bloques */
colon              = ":"

%%

{line_ending}              { /* incrementa línea automáticamente con %line */ }
{space}                    { /* ignora espacios */ }

/* Literales */
{int_literal}              { return symbol(sym.INT_LITERAL, new Integer(yytext())); }
{float_literal}            { return symbol(sym.FLOAT_LITERAL, new Float(yytext())); }
{boolean_literal}          { return symbol(sym.BOOLEAN_LITERAL, yytext()); }
{string_literal}           { return symbol(sym.STRING_LITERAL, yytext()); }
{char_literal}             { return symbol(sym.CHAR_LITERAL, yytext()); }

/* Temporales */
{temp}                     { return symbol(sym.TEMP, yytext()); }

/* Identificadores */

/* Tipos */
{int_kw}                   { return symbol(sym.INT, yytext()); }
{float_kw}                 { return symbol(sym.FLOAT, yytext()); }
{boolean_kw}               { return symbol(sym.BOOLEAN, yytext()); }
{char_kw}                  { return symbol(sym.CHAR, yytext()); }
{string_kw}                { return symbol(sym.STRING, yytext()); }
{arrayint_kw}              { return symbol(sym.INTARRAY, yytext()); }

/* Operadores aritméticos */
{pow}                      { return symbol(sym.POW, yytext()); }
{add}                      { return symbol(sym.ADD, yytext()); }
{sub}                      { return symbol(sym.SUB, yytext()); }
{mul}                      { return symbol(sym.MUL, yytext()); }
{div}                      { return symbol(sym.DIV, yytext()); }
{mod}                      { return symbol(sym.MOD, yytext()); }

/* Operadores lógicos */
{and}                      { return symbol(sym.AND, yytext()); }
{or}                       { return symbol(sym.OR, yytext()); }
{not}                      { return symbol(sym.NOT, yytext()); }

/* Comparadores */
{eq}                       { return symbol(sym.EQ, yytext()); }
{neq}                      { return symbol(sym.NEQ, yytext()); }
{le}                       { return symbol(sym.LE, yytext()); }
{lt}                       { return symbol(sym.LT, yytext()); }
{ge}                       { return symbol(sym.GE, yytext()); }
{gt}                       { return symbol(sym.GT, yytext()); }

/* Asignación */
{assign}                   { return symbol(sym.ASSIGN, yytext()); }

/* Arreglos */
{lbrack}                   { return symbol(sym.LBRACK, yytext()); }
{rbrack}                   { return symbol(sym.RBRACK, yytext()); }
{pipe}                     { return symbol(sym.PIPE, yytext()); }
{comma}                    { return symbol(sym.COMMA, yytext()); }

/* Instrucciones */
{function}                 { return symbol(sym.FUNCION, yytext()); }
{load_kw}                  { return symbol(sym.LOAD, yytext()); }
{store_kw}                 { return symbol(sym.STORE, yytext()); }
{copy_kw}                  { return symbol(sym.COPY, yytext()); }
{param_kw}                 { return symbol(sym.PARAM, yytext()); }
{call_kw}                  { return symbol(sym.CALL, yytext()); }
{return_kw}                { return symbol(sym.RETURN, yytext()); }
{goto_kw}                  { return symbol(sym.GOTO, yytext()); }
{if_kw}                    { return symbol(sym.IF, yytext()); }
{iffalse_kw}               { return symbol(sym.IFFALSE, yytext()); }

/* Entrada/Salida */
{read_int_kw}              { return symbol(sym.READ_INT, yytext()); }
{read_float_kw}            { return symbol(sym.READ_FLOAT, yytext()); }
{write_int_kw}             { return symbol(sym.WRITE_INT, yytext()); }
{write_float_kw}           { return symbol(sym.WRITE_FLOAT, yytext()); }
{write_string_kw}          { return symbol(sym.WRITE_STRING, yytext()); }
{write_boolean_kw}         { return symbol(sym.WRITE_BOOLEAN, yytext()); }

/* Bloques */
{colon}                    { return symbol(sym.COLON, yytext()); }

{ID}                       { return symbol(sym.ID, yytext()); }

/* Caracteres no reconocidos */
.                          { System.err.println("Carácter ilegal: " + yytext() + " en línea " + yyline); }
