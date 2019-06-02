package src;

import java.io.IOException;
import java.io.PrintWriter;
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
        System.out.println("Cantidad de genes "+p.getCantGenes());
        System.out.println("Genes de A: "+p.genesA.subList(0, p.getGenesA().size()));
        System.out.println("Genes de B: "+p.genesA.subList(0, p.getGenesB().size()));
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello, World!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
