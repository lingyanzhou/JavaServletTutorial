package com.localtour;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5132936917759337060L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World!</h1>");

        out.println("<table>");
        while (request.getParameterNames().hasMoreElements()) {
        	String paraName = request.getParameterNames().nextElement();

            out.println("<tr>");
            out.println("<td>");
        	out.println(paraName);
        	out.println();
            out.println("</td>");
            out.println("<td>");
        	out.println(request.getParameter(paraName));
            out.println("</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}

