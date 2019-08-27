import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import javax.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class DeleteServlet extends HttpServlet{

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Integer id=(Integer)session.getAttribute("id");
		System.out.println(id);
		Connection con=GetCon.getCon();
		try {
			
			PreparedStatement ps=con.prepareStatement("delete  from inbox6 where id = '"+id+"' ");
			
			//ps.setString(1,email);
			//ps.setString(2,password);
			int s =ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("delete","Mail has been Succefully deleted");
		RequestDispatcher rd=request.getRequestDispatcher("inbox.jsp");
		rd.include(request, response); 
}
}