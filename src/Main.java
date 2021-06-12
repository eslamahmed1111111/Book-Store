import Model.User;
import View.CustomerView;
import View.HomePage;
import View.ManagerView;
import View.UserView;

public class Main {

    public static void main(String[] args){
        UserView homePage = new CustomerView("Home Page");
        homePage.view();
    }


}
