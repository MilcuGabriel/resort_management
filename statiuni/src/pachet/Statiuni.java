package pachet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
class Statii{
	String denumire,tara,partii;
	public Statii(String denumire, String tara, String partii){
		this.denumire=denumire;
		this.tara=tara;
		this.partii=partii;
	}
	@Override
	public String toString() {
		 return "<tr><td>"+denumire+"</td><td>"+"<td>"+tara+"</td><td>"+"<td>"+partii+"</td><tr>";
		 
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public String getTara() {
		return tara;
	}

	public void setTara(String tara) {
		this.tara = tara;
	}

	public String getPartii() {
		return partii;
	}

	public void setPartii(String partii) {
		this.partii = partii;
	}
}
/**
 * Servlet implementation class Statiuni
 */
@WebServlet("/Statiuni")
public class Statiuni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	String denumire,tara,partii;
	ArrayList<Statii> statii=new ArrayList <Statii> ();
	
    public Statiuni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<html><head><title></title><body>");
		out.println("<form method ='post'>");
		out.println("<p>Denumire Statiune:<input type='text' name='denumire'></p>");
		out.println("<p>Tara:<input type='text' name='tara'></p>");
		out.println("<p>Numar Partii:<input type='text' name='partii'></p>");
		
		out.println("<p><input type='submit' value ='Adaugare' ></p>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
				
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		denumire=request.getParameter("denumire");
		tara=request.getParameter("tara");
		partii=request.getParameter("partii");
		Statii s=new Statii(denumire,tara,partii);
		statii.add(s);
		PrintWriter pw=response.getWriter();
		
		pw.println(     "<html><head><title>Primul servlet</title></head>");
        pw.println("<body><h1 align='center'>Persoanele introduse</h1>");
        pw.println("<center><table border='1'>");
        for(int i=0;i<statii.size();i++)
                pw.println(statii.get(i).toString());
	}

}
