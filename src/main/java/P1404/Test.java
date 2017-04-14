package P1404;

import org.eclipse.jetty.io.ssl.ALPNProcessor;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.Servlet;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        Server server = new Server(80);
        ServletContextHandler h = new ServletContextHandler();
        h.addServlet(TestServlet.class, "/");
        server.setHandler(h);
        server.start();
        ToDoList list = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1) Add");
            System.out.println("2) Delete");
            System.out.println("3) View");
            System.out.println("Enter key:");
            int destiny = Integer.parseInt(scanner.nextLine());
            switch (destiny) {
                case 1: {
                    System.out.println("Enter message:");
                    String mes = scanner.nextLine();
                    list.add(mes);
                    break;
                }
                case 2: {
                    System.out.println("Enter id:");
                    int id = Integer.parseInt(scanner.nextLine());
                    list.delete(id);
                    break;
                }
                case 3: {
                    System.out.println(list.view());
                    break;
                }
            }
            System.out.println("");
        }
    }
}
