package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ArquivoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		OutputStream out = null;
		FileInputStream file = null;
		
		try {
			out = response.getOutputStream();
			
			response.addHeader("Content-Disposition", "attachment; filename=CV Josevan Oliveira.zip");
			
			response.setContentType("application/zip");
			
			file = new FileInputStream("/home/josevan/Documentos/CV-Josevan_Oliveira_IT.zip");
			
			byte[] buffer = new byte[1024];
			int b;
			
			while((b = file.read(buffer)) > -1) {
				out.write(buffer, 0, b);
			}
			
		}finally {
			if(file != null) {
				file.close();
			}
			if(out != null) {
				out.close();
			}
		}
		
	}
}
