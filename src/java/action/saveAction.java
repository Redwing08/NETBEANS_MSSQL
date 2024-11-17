package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.save;
import dao.save;
import model.user;

public class saveAction extends ActionSupport {

    private String fname;
    private String lname;

    // Getters and Setters for fname and lname
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override

public String execute() {
    try {
        user user = new user();
        user.setFname(fname);
        user.setLname(lname);

        save daoSave = new save();
        String result = daoSave.saveUser(user);

        if ("SUCCESS".equals(result)) {
            System.out.println("Action: User saved successfully.");
        } else {
            System.err.println("Action: Failed to save user.");
        }
        return result;
    } catch (Exception e) {
        e.printStackTrace();
        return ERROR;
    }
}

}

 