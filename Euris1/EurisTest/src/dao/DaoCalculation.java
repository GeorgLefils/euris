package dao;

import util.BasicDao;

public class DaoCalculation extends BasicDao implements IDaoCalculation {

	public DaoCalculation(String dbAddress, String user, String password) {
		super(dbAddress, user, password);
		
	}

	@Override
	public String somma(String costo1, String costo2) {
		String out ="";
		        out += costo1 + " " + costo2;
		return out;
	}

	@Override
	public String sub(String costo1, String costo2) {
		String out = "";
		       
		return out ;
	}

	@Override
	public String mul(String costo, int numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String div(String costo, int numero) {
		// TODO Auto-generated method stub
		return null;
	}

}
