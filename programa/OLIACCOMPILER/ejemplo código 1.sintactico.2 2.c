
 float func1 ʃ float x22,char x23 ʅ  \ @semantico borrar parametro

	float r =-0.01? @error sintactico
	char _x22_='a'? {semantico x22}
	char _miChar_='!'?  @error sintactico
	char _miChar2_='!'? @sintactico-semantico
	int _x30_=-1?
	boolean _x40_= sol?
	char _x50_[1000][1000] = |4,5|?
	string _x50_="Hola a todos los que est[a] haciendo un compilador nuevo\n"?
	if ʃ ʃ_x30_<=45ʅ^ʃr>5.6ʅ ʅ  \  @semantico x22, var
		int y?
		y =10?
		char ch33='a'?
	 / 
	elif ʃ _x30_>5.6 ʅ  \  @sintactico
		int y?
		y =10?
		char ch33='a'?
	 / 
	else \ 
		int y?@no error duplicado en if-else
		string str2="sdff"?
	 / 
	for  ʃ int _i_=0?_i_<4+_x30_?++_i_ ʅ  \ writeString -> _x50_  ? /  @semantico i y j puede dar error sintactico
	writeString -> "Hola mundo" ?
	readInt <- _x30_ ?
	return -5.6?@cambio en retorno genera semantico
 /  

 boolean _func2_  ʃ boolean _b1_, int _i1_ ʅ   \ 
	int z? @sintactico
	return _b1_? @generar error con -5.6 y con i1
  /  

string _func3_  ʃ  ʅ   \  @semantico string
	string _b1_?
	return "hola"? 
  / 

void main ʃ  ʅ  \ 
{
Comentario 1
}
	char miChar='!'?
	char miChar2='!'? @sintactico
	string str1="Mi string 1"?
	float fl1=56.6? @semantico fl1
	int x = 1?
	int in1=++x- -14+ ++x~7*15? @semantico fl1, in1
	float fl2=3.7**fl1+ ʃ 45.6~76 ʅ ? @semantico literal 76
	
@comentario 2
	fl2 = 10 - func1  ʃ 5.5, 'a'ʅ ? @semantico func1, retorno func1
	fl1 = 4.5~fl1**-0.005? @semantico miChar
	func1 ʃ func1 ʃ 5.5, 'a'  ʅ ,'a' ʅ ? @semantico miFunc, hola
	boolean bl0 = 6.7 != 8.9? @ok
	bl0 = luna != sol? @ok
	boolean bl1 = ʃin1 >= fl1ʅ # sol ^ ! ʃ _func2_ ʃ luna,in1 ʅ  != luna ʅ ? @semantico in1 >= fl1, func2
	@return 1? @semantico
 / 


