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
        p.setCantGenes(Integer.parseInt(request.getParameter("columnas")));
        //Obtener los genes de A
        for(int i=1;i<p.getCantGenes()+1;i++){
            p.genesA.add(request.getParameter("cb"+i));
        }
        //Obtener los genes de B
        for(int i=3;i<p.getCantGenes()+1;i++){
            p.genesB.add(request.getParameter("cb"+i));
        }
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
