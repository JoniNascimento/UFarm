package br.com.unorte.ufarm.recursos;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class Function {


	public Function() {
		super();
	}
	
	public static double stringMonetarioToDouble(String str) {
		double retorno = 0;
		try {
			boolean hasMask = ((str.indexOf("R$") > -1 || str.indexOf("$") > -1) && (str
					.indexOf(".") > -1 || str.indexOf(",") > -1));
			// Verificamos se existe máscara
			if (hasMask) {
				// Retiramos a máscara.
				//str = str.replaceAll("R$", "").replaceAll(",", "").replaceAll(".", "");
				str = str.replaceAll("[R$]", "").replaceAll("[,]", "").replaceAll("[.]", "");
				//str = str.replaceAll("[R$]", "").replaceAll("[,]", ".");
			}

			// Transformamos o número que está escrito no EditText em
			// double.
			retorno = (Double.parseDouble(str)/ 10);
		} catch (NumberFormatException e) {
			//TRATAR EXCEÇÃO
		}
		return retorno;
	}

	public Date converteData(String DataText){
		Date Data = new Date();
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setLenient(false);

		try {

			Data = sdf.parse(DataText.toString().replace("/","-"));

		} catch (ParseException e) {
			Log.w("Erro Data", "Erro ao converter a data");
			e.printStackTrace();
		}

		return Data;
	}
	
	
	

}
