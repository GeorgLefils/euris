package controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.IDao;
import entities.Articolo;
import factories.DaoFactory;

/**
 * Servlet implementation class IndexArticolo
 */
@WebServlet({"/articoli", "/articoli/*"})
public class IndexArticolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IDao dao;
	private Gson gson;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexArticolo() {
        super();
        dao = DaoFactory.make();
        gson = new Gson();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		     String path = request.getPathInfo();
		     
		     String out ="";
		     
		     if(path == null || path.equals("/")){
		    	 out = gson.toJson(dao.articoli());
		     }else{
		    	 int id = Integer.parseInt(path.substring(1));
		    	 out = gson.toJson(dao.articolo(id));
		     }
		     
		
		response.setContentType("application/json");
		response.getWriter().append(out);
	}
	
	private Articolo articoloFromRequest(HttpServletRequest request) throws IOException {
		BufferedReader br = request.getReader();
		String body ="";
		String riga = null;
		
		while((riga = br.readLine()) != null){
			body += riga;
			
		}
		Articolo articolo = gson.fromJson(body, Articolo.class);
		
		return articolo;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Articolo articolo = articoloFromRequest(request);
		
		String out ="";
		
		if(dao.aggiungi(articolo)){
			out = "{\"messaggio\" : \"Ok aggiungi\"}";
		}else{
			out ="{\"messaggio\" : \"Ko in fase di aggiungi\"}";
		}
		
		response.setContentType("application/json");
		response.getWriter().append(out);
	}
	
	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Articolo daModificare = articoloFromRequest(request);
		
		String out ="";
		
		if(dao.modifica(daModificare)){
			out= "{\"messaggio\" : \"OK in modifica\"}";
		}else{
			out ="{\"messaggio\" : \"Ko in fase di modifica\"}";
		}
		
        response.setContentType("application/json");
		response.getWriter().append(out);
		
	}
	
	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String path = request.getPathInfo();
		
		String out ="";
		
		if(path == null || path == "/"){
			     out = "{\"messaggio\" : \"NON posso cancellare tutti gli articoli\"}";
		}else{
			int id = Integer.parseInt(path.substring(1));
			
			if(dao.elimina(id)){
				out ="{\"messaggio\" : \"Ok in delete\"}";
			}else{
				out ="{\"messaggio\" : \"Ko in fase di delete\"}";
			}
		}
		
		response.setContentType("application/json");
		response.getWriter().append(out);
	}

}



























































