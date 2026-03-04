package starter.ui.addtransaction;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AddTransactionPage {
    public static Target BUTTON_ADD_TRANSACTION = Target.the("Add transaction button").locatedBy("//button[contains(., 'Añadir transacción')]");
    public static Target INPUT_DATE = Target.the("Date transaction").locatedBy("//input[@type= 'date']");
    public static Target INPUT_AMOUNT = Target.the("Amount transaction").located(By.id("amount"));
    public static Target INPUT_DESCRIPTION = Target.the("Description transaction").located(By.id("description"));
    public static Target BUTTON_SAVE = Target.the("Save transaction").locatedBy("//button[contains(., 'Guardar')]");

    public static Target TRANSACTION_TABLE = Target.the("Transaction table").locatedBy("//tbody[@id='transactions-list']");

    public static String TRANSACTION_TABLE_XPATH = "//tbody[@id='transactions-list']";

}
