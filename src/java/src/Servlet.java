package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Muestra la información calculada a partir de la entrada en get y calculada en la clase Pounnett.
 * @author Riscolso
 */
public class Servlet extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)    
    throws ServletException, IOException {
        Pounnett p = new Pounnett();
        //Establecer la cantidad de genes 
        p.setCantGenes(Integer.parseInt(request.getParameter("n")));
        //Obtener los genes de A
        for(int i=0;i<p.getCantGenes();i++){
            p.getGenesA().add(request.getParameter("cb"+i));
        }
        //Obtener los genes de B
        for(int i=p.getCantGenes();i<p.getCantGenes()*2;i++){
            p.getGenesB().add(request.getParameter("cb"+i));
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet</title>");            
        out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" crossorigin=\"anonymous\">");            
        out.println("<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" crossorigin=\"anonymous\"></script>");
        out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" crossorigin=\"anonymous\"></script>");
        out.println("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" crossorigin=\"anonymous\"></script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"alert alert-primary\" class = 'rounded'>");
        out.println("Cantidad de genes "+p.getCantGenes());
        out.println("<br>");
        out.println("Genes de A: "+p.genesA.subList(0, p.getGenesA().size()));
        out.println("<br>");
        out.println("Genes de B: "+p.genesB.subList(0, p.getGenesB().size()));
        out.println("</div>");
        char a = 'a';
        char aux;
        
        for(int i=0;i<p.getCantGenes();i++){
            aux = (char) (a+i);
            out.println("<div class=\"alert alert-dark\" class = 'rounded'>");
            out.println("Cuadro "+i+"<br>");
            out.println("</div>");
            out.println("<table class='table table-sm'>");
            ArrayList<String> c = p.generarCruce(i);
            out.println("<tr>");
            for(int e=0;e<c.size();e++){
                out.print("<td>"+c.get(e)+"</td>");
                if(e==1) out.println("</tr>");
            }
            out.println("</table>");
            out.println("<br>");
            out.print("Probabilidad de "+aux +" es :"+p.probabilidadAlelo(aux, i)+"<br>");
            out.print("Probabilidad de "+Character.toUpperCase(aux) +" es :"+p.probabilidadAlelo(Character.toUpperCase(aux),i)+"<br><br>");
        }
        
        out.print("<br><br>");
        out.print("<div class='alert alert-primary'> Lista de cruces :"+p.generarCruce().subList(0, p.generarCruce().size())+"</div>");
        out.print("<br><br>");
        out.print("<table class='table table-sm'>");
        for(String s: p.generarCruce()){
            out.print("<tr><td>Probabilidad "+s+" :"+p.probabilidadGenotipo(s)+"</tr></td>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}