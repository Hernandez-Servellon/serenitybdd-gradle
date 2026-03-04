package starter.tasks.addtransaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;
import starter.questions.GetTransactionInfo;
import starter.ui.addtransaction.AddTransactionPage;

public class CheckNewTransactionWasAdded implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                //Esta assercion se hizo mediante una question que esta en el paquete questions
                Ensure.that(GetTransactionInfo.getDescriptions())
                        .contains("transaction testing description"),
                Ensure.that(AddTransactionPage.TRANSACTION_TABLE).text()
                        .contains("500")

        );
    }
}
