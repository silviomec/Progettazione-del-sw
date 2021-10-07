package Util;

public class NewDate {
	public NewDate(int anno, int mese, int giorno) {
		this.anno = anno;
		this.mese = mese;
		this.giorno = giorno;
	}
	
	public java.sql.Date getSqlDate() {
		java.util.Date myDate = new java.util.Date(mese + "/" + giorno + "/" + anno);
		java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
		
		return sqlDate;
	}
	
	int anno, mese, giorno;
}