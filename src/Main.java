import presentation.LoginView;
import presentation.MainMenu;

public class Main {
    public static void main(String[] args) {

        new LoginView().login();

        new MainMenu().menu();
    }
}