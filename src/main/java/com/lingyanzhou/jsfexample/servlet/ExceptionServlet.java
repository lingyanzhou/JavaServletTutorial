package com.lingyanzhou.jsfexample.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Error Generating Servlet",
    urlPatterns = "/err-gen-servlet/*")
public class ExceptionServlet extends HttpServlet {
 

  public void init() throws ServletException
  {
      // Do required initialization
  }

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
    throw new ServletException();
  }
  
  public void destroy()
  {
  }
}
