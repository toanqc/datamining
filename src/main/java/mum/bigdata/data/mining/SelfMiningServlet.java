package mum.bigdata.data.mining;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.User;

public class SelfMiningServlet extends HttpServlet {

	private static final long serialVersionUID = -7530879024905712661L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		FacebookClient facebookClient = new DefaultFacebookClient(
				"CAACEdEose0cBAID3UtHKmnCDv8oYlhWlYIskyVZAUJdkIKQaSOYM5uXCs7iakDCpAbeG0WaKF8XFNr8NdQKWqAfRbRqNSkPutOIjYIIK7o1TrWnczD9cKMqKO1YRRRGYS2h2Cx2n8KLqplIR6r1VeKvWxT8P4RSmZBT5oQQ4iFIGXmAOjRDRV7SZCgLzHsyED33U54dfiGWHSqXZAMMs",
				Version.LATEST);
		User user = facebookClient.fetchObject("me", User.class,
				Parameter.with("fields", "id,name,bio,relationship_status,education,friendlists"));
		out.println("Id: " + user.getId());
		out.println("<br />");
		out.println("User name: " + user.getName());
		out.println("<br />");
		out.println("Bio: " + user.getBio());
		out.println("<br />");
		out.println("Relationship Status: " + user.getRelationshipStatus());
	}
}
