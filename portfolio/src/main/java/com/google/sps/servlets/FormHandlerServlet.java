package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;


@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    // String input = Jsoup.clean(request.getParameter("text-input"), Whitelist.none());
    String textValue = request.getParameter("text-input");
    long timestamp = System.currentTimeMillis();

    // Print the value so you can see it in the server logs.
    System.out.println("You submitted: " + textValue);
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Contact");
    FullEntity contactEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("text-input", textValue)
            .set("timestamp", timestamp)
            .build();
    datastore.put(contactEntity);
    // Write the value to the response so the user can see it.
    // response.getWriter().println("You submitted: " + textValue);
    response.sendRedirect("http://ipaine-sps-spring21.appspot.com/");
  }
}