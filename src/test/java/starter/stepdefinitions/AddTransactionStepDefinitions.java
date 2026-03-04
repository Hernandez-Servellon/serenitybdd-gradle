package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;
import starter.models.LoginModel;
import starter.models.TransactionModel;
import starter.tasks.addtransaction.AddTransaction;
import starter.tasks.addtransaction.CheckNewTransactionWasAdded;
import starter.tasks.login.Login;
import starter.tasks.navigation.NavigateTo;
import starter.util.GetInfoFromTable;

import java.util.List;

public class AddTransactionStepDefinitions {

    @Given("{actor} is logged into the application")
    public void isLoggedIntoTheApplication(Actor actor, DataTable userLogin) {

        //Esto lo envie para la clase GetInfoFromTable en el paquete util
      /*  List<List<String>> rows = userLogin.asLists(String.class);
        String username="";
        String password="";


        for(List<String>columns: rows){
            username=columns.get(0);
            password=columns.get(1);
        }

       */
        LoginModel loginModel = GetInfoFromTable.getLoginCredentials(userLogin);

         actor.attemptsTo(
                 NavigateTo.loginPage(),  //Me abre la url de login Open.url("http://127.0.0.1:5500/login.html")
                 new Login(loginModel.getUsername(), loginModel.getPassword())
                 //Lo lleve para la clase Login en paquete tasks REFACTORIZANDO
               //  Enter.theValue("user").into(By.id("username")),
               //  Enter.theValue("pass").into(By.id("password")),
               //  Click.on(By.xpath("//button[contains(., 'Iniciar sesión')]"))
         );

    }

    @When("{actor} enters the required information for the new transaction")
    public void entersTheRequiredInformationForTheNewTransaction(Actor actor, DataTable transactionInfo) {


        //Esto lo lleve a la clase GetInfoFromTable de paquete util al metodo get transactionData
        /*List<List<String>> rows = transactionInfo.asLists(String.class);
        String transactionDate="";
        String transactionAmaunt="";
        String transactionDescription="";

        for(List<String>columns: rows){
            transactionDate=columns.get(0);
            transactionAmaunt=columns.get(1);
            transactionDescription=columns.get(2);
        }

         */
        TransactionModel transactionModel = GetInfoFromTable.getTransactionData(transactionInfo);

        actor.attemptsTo(
                AddTransaction.withInfo(transactionModel.getTransactionDate(),
                        transactionModel.getTransactionAmaunt(),
                        transactionModel.getTransactionDescription())
                //Me lleve esto para la clase add Transaction
               /* Click.on(By.xpath("//button[contains(., 'Añadir transacción')]")),
                Enter.theValue("2026-02-03").into("//input[@type= 'date']"),
                Enter.theValue("500").into(By.id("amount")),
                Enter.theValue("descrption3").into(By.id("description")),
                Click.on(By.xpath("//button[contains(., 'Guardar')]"))

                */
        );

    }

    @Then("{actor} should see a new transaction in the transaction list with correct details")
    public void shouldSeeANewTransaction(Actor actor) {

        actor.attemptsTo(
             new CheckNewTransactionWasAdded()


        //me lleve esto para la clase ckeck New Transaction was added
        /*Ensure.that(By.xpath("//tbody[@id='transactions-list']")).text()
                .contains("descrption3"),
        Ensure.that(By.xpath("//tbody[@id='transactions-list']")).text()
                .contains("500")

         */
       );
    }
}

