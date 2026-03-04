package starter.ui.login;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static Target INPUT_USERNAME = Target.the("username input").located(By.id("username"));
    public static Target INPUT_PASSWORD = Target.the("password input").located(By.id("password"));
    public static Target BUTTON_LOGIN = Target.the("login button").located(By.xpath("//button[contains(., 'Iniciar sesión')]"));

}
