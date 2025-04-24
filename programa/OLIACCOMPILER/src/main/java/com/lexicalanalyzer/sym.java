/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lexicalanalyzer;

/**
 *
 * @author andre
 */
public class sym {
  // Literales
  public static final int INT_LITERAL = 0;
  public static final int FLOAT_LITERAL = 1;
  public static final int BOOLEAN_LITERAL = 2;
  public static final int STRING_LITERAL = 3;
  public static final int CHAR_LITERAL = 4;

  // Identificadores
  public static final int ID = 5;

  // Estructuras de control
  public static final int IF = 6;
  public static final int ELIF = 7;
  public static final int ELSE = 8;
  public static final int WHILE = 9;
  public static final int FOR = 10;
  public static final int CASE = 11;
  public static final int SWITCH = 12;
  public static final int DO = 13;

  // Tipos de datos
  public static final int INT = 14;
  public static final int FLOAT = 15;
  public static final int BOOLEAN = 16;
  public static final int CHAR = 17;
  public static final int STRING = 18;

  public static final int INT_MATRIX = 19;
  public static final int FLOAT_MATRIX = 20;
  public static final int STRING_MATRIX = 21;
  public static final int CHAR_MATRIX = 22;
  public static final int BOOLEAN_MATRIX = 23;

  // Operadores aritméticos
  public static final int ADDITION_ONE = 24;
  public static final int SUBTRACT_ONE = 25;
  public static final int POWERS = 26;
  public static final int ADDITION = 27;
  public static final int SUBTRACT = 28;
  public static final int MULTIPLICATION = 29;
  public static final int DIVISION = 30;
  public static final int MODULE = 31;

  // Operadores lógicos
  public static final int CONJUNCTION = 32;
  public static final int DISJUNCTION = 33;
  public static final int DENIAL = 34;

  // Operadores de comparación
  public static final int EQ = 35;
  public static final int NEQ = 36;
  public static final int LE = 37;
  public static final int LT = 38;
  public static final int GE = 39;
  public static final int GT = 40;

  // Símbolos y delimitadores
  public static final int LBRACKET = 41;
  public static final int RBRACKET = 42;
  public static final int COMMA = 43;
  public static final int PARENTHESIS_L = 44;
  public static final int PARENTHESIS_R = 45;
  public static final int END_LINE = 46;
  public static final int OPEN_BLOCK = 47;
  public static final int CLOSE_BLOCK = 48;
}

