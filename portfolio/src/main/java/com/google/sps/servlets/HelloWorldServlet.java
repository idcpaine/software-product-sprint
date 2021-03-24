package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import com.google.gson.Gson;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //response.setContentType("text/html;");
    //response.getWriter().println("Hello world!");
    ArrayList<String> quotes = new ArrayList<String>();
    quotes.add("Be comfortable with being uncomfortable");
    quotes.add("When you are confident, people become confident in you");
    quotes.add("Take the risk or lose the chance");
    Gson gson = new Gson();
    String convertedList = gson.toJson(quotes);

    response.setContentType("application/json;");
    response.getWriter().println(convertedList);
  }
}
