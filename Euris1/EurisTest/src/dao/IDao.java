package dao;

import java.util.List;

import entities.Articolo;

public interface IDao {
	
    List<Articolo> articoli();
    
    Articolo articolo (int id);
	
	boolean aggiungi(Articolo articolo);
	
	boolean elimina(int id);
	
	boolean modifica(Articolo articolo);

}
