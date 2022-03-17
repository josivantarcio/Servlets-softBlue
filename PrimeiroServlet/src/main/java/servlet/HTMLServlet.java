package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HTMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = null;
		try {
			out = response.getWriter();
			response.setContentType("text/html");
			
			out.print("<HTML><BODY>");
			out.print("<H1>Titulo da Página</H1>");
			out.print("<STRONG>Texto em negrito</STRONG>");
			out.print("</HTML></BODY>");
			
		}finally {
			if(out != null) {
				out.close();
			}
		}
		
	}

}
