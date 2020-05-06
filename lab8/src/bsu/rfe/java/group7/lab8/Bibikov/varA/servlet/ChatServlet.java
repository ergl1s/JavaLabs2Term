package bsu.rfe.java.group7.lab8.Bibikov.varA.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import bsu.rfe.java.group7.lab8.Bibikov.varA.entity.ChatMessage;
import bsu.rfe.java.group7.lab8.Bibikov.varA.entity.ChatUser;

@WebServlet(name = "ChatServlet")
public class ChatServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    protected HashMap<String, ChatUser> activeUsers;
    protected ArrayList<ChatMessage> messages;

    @SuppressWarnings("unchecked")
    public void init() throws ServletException {
        super.init();

        activeUsers = (HashMap<String, ChatUser>) getServletContext().getAttribute("activeUsers");
        messages = (ArrayList<ChatMessage>) getServletContext().getAttribute("messages");

        if (activeUsers==null) {
            activeUsers = new HashMap<String, ChatUser>();
            getServletContext().setAttribute("activeUsers", activeUsers);
        }

        if (messages==null) {
            messages = new ArrayList<ChatMessage>(100);
            getServletContext().setAttribute("messages", messages);
        }
    }
}