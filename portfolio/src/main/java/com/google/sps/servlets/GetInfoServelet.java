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


@WebServlet("/get-info")
public class GetInfoServelet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
     // Sanitize user input to remove HTML tags and JavaScript.
    String Name = Jsoup.clean(request.getParameter("name"), Whitelist.none());
    String Reason = Jsoup.clean(request.getParameter("reason"), Whitelist.none());
    String Message = Jsoup.clean(request.getParameter("message"), Whitelist.none());
    String Email = Jsoup.clean(request.getParameter("email"), Whitelist.none());

    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Form");
    FullEntity taskEntity =
    Entity.newBuilder(keyFactory.newKey())
        .set("name", Name)
        .set("reason",Reason)
        .set("message",Message)
        .set("email",Email)
        .build();
    datastore.put(taskEntity);
    response.sendRedirect("/index.html");
  }
}