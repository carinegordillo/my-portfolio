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


@WebServlet("/get-insta")
public class GetInstaServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    String textValue = request.getParameter("text-input");
    System.out.println("You submitted: " + textValue);
    response.getWriter().println("You submitted: " + textValue + ", hope to talk to you soon!"); 
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("InstaHandle");
    FullEntity taskEntity =
    Entity.newBuilder(keyFactory.newKey())
        .set("text-input", textValue)
        .build();
    datastore.put(taskEntity);
    response.sendRedirect("/index.html");
  }
}