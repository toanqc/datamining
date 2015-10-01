package mum.bigdata.data.mining;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.Post;

public class GroupMiningServlet extends HttpServlet {

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
				"CAAOLxO0LNHABAHXJryh9bD5g6TmmptTcgPThR8NF9cPbkyB4RzBLmJSEvU8JWQMEKeBGBZBWzSddao7FyUtnns0h0ekAIHFSRNS4Aefv0eeXyLm3su3JZBU0fNxJL"
						+ "XBm66GNPr14t2dRsXqpZCxA0OyjGxFbpqIZC1ThbFL9ZAWSjuWzkake46VBVV2aCv4Mg4lczfqdNXGr9BghkDdik",
				Version.LATEST);
		// https://www.facebook.com/groups/homesharefairfield/
		Connection<Post> allFeed = facebookClient.fetchConnection("246223348779516/feed", Post.class);

		for (List<Post> myFeedConnectionPage : allFeed) {
			for (Post post : myFeedConnectionPage) {
				out.println("Post: " + post);
			}
		}
	}
}
