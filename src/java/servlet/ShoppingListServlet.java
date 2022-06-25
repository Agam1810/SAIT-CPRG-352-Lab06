
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ShoppingListServlet extends HttpServlet {

    
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession session = request.getSession();
         String act = request.getParameter("action");
         
         if (act != null) {
             
             
             if(act.equals("logout")){
                session.invalidate();
                String message = "Successfully logged out.";
                request.setAttribute("message", message);
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
       }
        if (session.getAttribute("username") != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        return;
    }
         
  

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
      HttpSession session = request.getSession();
        String act = request.getParameter("action");
        ArrayList<String> List = (ArrayList<String>) session.getAttribute("List");

        if (List == null) {
            List = new ArrayList<>();
        }

        if (act != null) {
            if (act.equals("register")) {
                String username = request.getParameter("username");
                
                if(username==null || username.equals("")){
                   String error= "Please input the appropriate username.";
                
                   request.setAttribute("error",error);
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
                }
                
                session.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
                
            } else if (act.equals("add")) {
                String item = request.getParameter("item");
                
                
                if(item==null || item.equals("")){
                    String error = "Please input the item.";
                    request.setAttribute("error",error);
                   getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                   return;
                }
                
                if (item != null) {
                    List.add(item);
                    String error = "";
                    request.setAttribute("error",error);
                }
                
                session.setAttribute("List", List);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
                
            } else if (act.equals("delete")) {
                String item = request.getParameter("item");
                
                
                if(item==null || item.equals("")){
                    String error = "Please select an item.";
                    request.setAttribute("errord",error);
                   getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                   return;
                }
                
                if (item != null) {
                    List.remove(item);
                    String error = "";
                    request.setAttribute("errord",error);
                }
                
                session.setAttribute("List", List);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            }
        }       
        
   
    
    }

 }
