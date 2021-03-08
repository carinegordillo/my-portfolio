package com.google.sps.servlets;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get-insta")
public class GetInstaServlet extends HttpServlet {
    

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    String textValue = request.getParameter("text-input");
    System.out.println("You submitted: " + textValue);
    response.getWriter().println("You submitted: " + textValue + ", hope to talk to you soon!");
    
  }
}