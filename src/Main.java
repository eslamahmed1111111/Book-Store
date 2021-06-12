import Model.User;
import View.HomePage;
import View.ManagerView;
import View.UserView;

public class Main {

    public static void main(String[] args){
        UserView homePage = new ManagerView("Home Page");
        homePage.view();
    }


}
