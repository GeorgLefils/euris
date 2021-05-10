package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entities.Articolo;
import util.BasicDao;


public class DaoMySQL extends BasicDao implements IDao{

	public DaoMySQL(String dbAddress, String user, String password) {
		super(dbAddress, user, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Articolo> articoli() {
		List<Articolo> out = new ArrayList<>();
		
		List<Map<String, String>>maps = getAll("SELECT * FROM articoli");
		
		for(Map<String, String>map : maps){
			Articolo a = new Articolo();
			a.fromMap(map);
			out.add(a);
			
		}
		
		return out;
	}
	
	@Override
	public Articolo articolo(int id) {
		Articolo out = null;
		
		Map<String, String>map = getOne("SELECT * FROM articoli WHERE id =?", id);
		if(map != null){
			out = new Articolo();
			out.fromMap(map);
		}
		return out;
	}

	@Override
	public boolean aggiungi(Articolo articolo) {
		if(articolo != null){
			execute("INSERT INTO articoli (nome, prezzo) VALUES (?, ?)",
					articolo.getNome(),
					         articolo.getPrezzo());
			return true;
		}
		return false;
		
	}

	@Override
	public boolean elimina(int id) {
		Articolo daEliminare = articolo(id);
		
		if(daEliminare != null){
			execute("DELETE FROM  articoli WHERE id =?", id);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean modifica(Articolo articolo) {
		Articolo daModificare = articolo(articolo.getId());
		
		if(daModificare != null){
			execute("UPDATE articoli SET nome =?, prezzo =? WHERE id =?",
					articolo.getNome(),
					        articolo.getPrezzo(),
					                articolo.getId());
			
			return true;
		}
		return false;
	}

}
