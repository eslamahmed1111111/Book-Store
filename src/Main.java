import Model.User;
import View.*;

public class Main {

    public static void main(String[] args){
//        new registeration();
       // UserView homePage = new ManagerView("Home Page");
       // homePage.view();
        SignInView view = new SignInView();
        view.view();
    }
}
