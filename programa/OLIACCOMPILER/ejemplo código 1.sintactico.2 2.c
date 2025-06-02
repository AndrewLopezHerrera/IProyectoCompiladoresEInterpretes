float calcularPromedioʃ int suma, int cantidad ʅ \
	float promedio = suma // cantidad?
	return promedio?
/

string clasificarNotaʃ float nota ʅ \
	ifʃnota >= 90ʅ \
		return "Excelente"?
	/
	elifʃnota >= 70ʅ \
		return "Aprobado"?
	/
	else \
		return "Reprobado"?
	/
/

string mostrarResultadosʃ int suma, int cantidad ʅ \
	float promedio = calcularPromedioʃsuma, cantidadʅ?
	string clasificacion = clasificarNotaʃpromedioʅ?
	writeString -> "Promedio:"?
	writeFloat -> promedio?
	writeString -> "Clasificación:"?
	writeString -> clasificacion?
/

void mainʃʅ \
	int suma = 0?
	int cantidad = 3?
	int i = 0?
	writeString -> "Ingrese 3 notas enteras:"?
	forʃi = 0? i < cantidad? ++iʅ \
		int nota = readIntʃʅ?
		suma = suma + nota?
	/
	mostrarResultadosʃsuma, cantidadʅ?

	do \
		writeString -> "Ingrese una nota decimal para clasificar:"?
		float notaDecimal = readFloatʃʅ?
		string clasificacion = clasificarNotaʃnotaDecimalʅ?
		writeString -> "Clasificación:"?
		writeString -> clasificacion?
		writeString -> "¿Desea ingresar otra nota? (1 para sí, 0 para no):"?
		int continuar = readIntʃʅ?
		ifʃcontinuar == 0ʅ \
			break?
		/
	/whileʃtrueʅ?
/
