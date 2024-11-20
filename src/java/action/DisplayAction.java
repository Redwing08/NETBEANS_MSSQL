package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.save;
import model.user;
import java.util.List;

public class DisplayAction extends ActionSupport {
    private List<user> users;

    public List<user> getUsers() {
        return users;
    }

    @Override
    public String execute() {
        save dao = new save();
        users = dao.getAllUsers();
        return SUCCESS;
    }
}
