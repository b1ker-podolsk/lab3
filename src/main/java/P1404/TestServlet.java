package P1404;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class TestServlet extends HttpServlet {
    private ToDoList list = new ToDoList();
    private Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
    {list.add("Пример");
        try {
            cfg.setTemplateLoader(new FileTemplateLoader(new File(".")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String waht = req.getParameter("message");
        list.add(waht);
        resp.sendRedirect("/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Template t = cfg.getTemplate("todo.html");
        StringBuilder buf = new StringBuilder();
        List<Message> message = list.view();
        for (Message i : message) {
            buf.append("<li>"+i.message +"</li>\n");
        }
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("<html>\n" +
                "<head>\n" +
                " <meta charset = \"UTF-8\">\n" +
                "    <title>Список дел</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form method=\"post\" action=\"add\">\n" +
                "    Задача:<input name = \"message\">\n" +
                "    <input type =\"submit\" value=\"добавить\">\n" +
                "<ol>\n" +
                buf +
                "</ol>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }
}
