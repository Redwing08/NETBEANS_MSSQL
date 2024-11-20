package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.save;
import model.user;
import java.io.*;
import java.util.List;

public class ExportHtmlAction extends ActionSupport {
    private InputStream fileInputStream;

    public InputStream getFileInputStream() {
        return fileInputStream;
    }

    @Override
    public String execute() {
        save dao = new save();
        List<user> users = dao.getAllUsers();

        try {
            // Use the absolute file path for template.html
            File templateFile = new File("C:/Users/barre/Documents/NetBeansProjects/HAHA_1/web/template.html");
            String template = new String(java.nio.file.Files.readAllBytes(templateFile.toPath()));

            // Generate dynamic rows from the user data
            StringBuilder tableRows = new StringBuilder();
            for (user u : users) {
                tableRows.append("<tr>")
                         .append("<td>").append(u.getId()).append("</td>")
                         .append("<td>").append(u.getFname()).append("</td>")
                         .append("<td>").append(u.getLname()).append("</td>")
                         .append("</tr>");
            }

            // Replace the placeholder with the actual data
            String populatedHtml = template.replace("<!-- DATA_PLACEHOLDER -->", tableRows.toString());

            // Convert the populated HTML to an InputStream for downloading
            fileInputStream = new ByteArrayInputStream(populatedHtml.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }

        return SUCCESS;
    }
}
