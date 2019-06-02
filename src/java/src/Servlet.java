package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
        out.println("</head>");
        out.println("<body>");
        out.println("Cantidad de genes "+p.getCantGenes());
        out.println("<br>");
        out.println("Genes de A: "+p.genesA.subList(0, p.getGenesA().size()));
        out.println("<br>");
        out.println("Genes de B: "+p.genesB.subList(0, p.getGenesB().size()));
        char a = 'a';
        char aux;
        for(int i=0;i<p.getCantGenes();i++){
            aux = (char) (a+i);
            out.println("<br><br>");
            out.println("Cuadro "+i+"<br>");
            ArrayList<String> c = p.generarCruce(i);
            for(int e=0;e<c.size();e++){
                out.print(c.get(e)+" ");
                if(e==1) out.println("<br>");
            }
            out.println("<br>");
            out.print("Probabilidad de "+aux +" es :"+p.probabilidadAlelo(aux, i)+"<br>");
            out.print("Probabilidad de "+Character.toUpperCase(aux) +" es :"+p.probabilidadAlelo(Character.toUpperCase(aux),i));
        }
        out.print("<br><br>");
        out.print("Lista de cruces :"+p.generarCruce().subList(0, p.generarCruce().size()));
        out.print("<br><br>");
        for(String s: p.generarCruce()){
            out.print("Probabilidad "+s+" :"+p.probabilidadGenotipo(s)+"<br>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
