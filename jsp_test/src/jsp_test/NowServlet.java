package jsp_test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/now2")
public class NowServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET으로 요청");
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		
			writer.println("<head><title>NowServlet</title></head>");
			writer.println("<body>");
			writer.println("<h1>" + new Date() + "</h1>");
			
			writer.println("</body>");
		writer.println("</html>");
		
		writer.close();    // writer는 io객체이기 때문에 close로 닫아줘야함
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST로 요청");
	}

	
	
}