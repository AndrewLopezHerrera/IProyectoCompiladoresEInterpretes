package com.lexicalanalyzer;

public class sym {
  public static final int EOF = 0;
  public static final int ASSIGN = 1;

  public static final int INT_LITERAL = 2;
  public static final int FLOAT_LITERAL = 3;
  public static final int BOOLEAN_LITERAL = 4;
  public static final int STRING_LITERAL = 5;
  public static final int CHAR_LITERAL = 6;

  public static final int ID = 7;

  public static final int IF = 8;
  public static final int ELIF = 9;
  public static final int ELSE = 10;
  public static final int WHILE = 11;
  public static final int FOR = 12;
  public static final int CASE = 13;
  public static final int SWITCH = 14;
  public static final int DO = 15;
  public static final int BREAK = 16;

  public static final int INT = 17;
  public static final int FLOAT = 18;
  public static final int BOOLEAN = 19;
  public static final int CHAR = 20;
  public static final int STRING = 21;

  public static final int INT_MATRIX = 22;
  public static final int FLOAT_MATRIX = 23;
  public static final int STRING_MATRIX = 24;
  public static final int CHAR_MATRIX = 25;
  public static final int BOOLEAN_MATRIX = 26;

  public static final int ADDITION_ONE = 27;
  public static final int SUBTRACT_ONE = 28;
  public static final int POWERS = 29;
  public static final int ADDITION = 30;
  public static final int SUBTRACT = 31;
  public static final int MULTIPLICATION = 32;
  public static final int DIVISION = 33;
  public static final int MODULE = 34;

  public static final int CONJUNCTION = 35;
  public static final int DISJUNCTION = 36;
  public static final int DENIAL = 37;

  public static final int EQ = 38;
  public static final int NEQ = 39;
  public static final int LE = 40;
  public static final int LT = 41;
  public static final int GE = 42;
  public static final int GT = 43;

  public static final int LBRACKET = 44;
  public static final int RBRACKET = 45;
  public static final int COMMA = 46;

  public static final int PARENTHESIS_L = 47;
  public static final int PARENTHESIS_R = 48;
  public static final int END_LINE = 49;
  public static final int OPEN_BLOCK = 50;
  public static final int CLOSE_BLOCK = 51;

  public static final int READ_INT = 52;
  public static final int READ_FLOAT = 53;
  public static final int WRITE_INT = 54;
  public static final int WRITE_FLOAT = 55;
  public static final int WRITE_STRING = 56;
  public static final int WRITE_BOOLEAN = 57;

  public static final int RETURN = 58;
  public static final int VOID = 59;
  public static final int COMMENT_BLOCK = 60;
  public static final int COMMENT_LINE = 61;

  public static final int MAIN = 62;
}