package com.example.csv_form;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "questionarioServlet", value = "/questionario-servlet")
public class QuestionarioServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String nome = req.getParameter("nome");
        String cognome = req.getParameter("cognome");
        int valutazione = Integer.parseInt(req.getParameter("valutazione"));
        String commento = req.getParameter("commento");

        /*File file = new File("data.csv");
        try (FileWriter fileWriter = new FileWriter(file))
        {
            fileWriter.append("nome");
            fileWriter.append(";");
            fileWriter.append("cognome");
            fileWriter.append(";");
            fileWriter.append("valutazione");
            fileWriter.append(";");
            fileWriter.append("commento");
            fileWriter.append("\n");

            String[] values = {nome, cognome, String.valueOf(valutazione), commento};

            fileWriter.append(String.join(";",values));
            fileWriter.append("\n");

            fileWriter.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        */
        resp.setContentType("text/csv");
        PrintWriter out = resp.getWriter();
        out.println(nome + ";" + cognome + ";" + valutazione + ";" + commento);
    }

    public void destroy() {
    }


}