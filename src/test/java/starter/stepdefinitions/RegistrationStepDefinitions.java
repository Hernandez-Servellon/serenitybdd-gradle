package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import starter.tasks.registration.CheckNewAccountCreated;
import starter.tasks.registration.DoNotSendAllRequiredInformation;
import starter.tasks.registration.RegisterUser;
import starter.tasks.registration.ShouldSeeAllFieldsAreRequired;
import starter.ui.registration.RegisterPage;
import starter.ui.registration.SummaryPage;

import java.net.URISyntaxException;
import java.util.List;

public class RegistrationStepDefinitions {
 //Estas variable se pusieron en un datatable en la feature de cucumber
    /*
    String expectedName ="Antonio";
    String expectedLastName="Hernandez";
    String expectedAge = "30";
    String expectedEmail="hilson@gmail.com";
    String expectedCountry="Colombia";

     */

    String expectedName ="";
    String expectedLastName="";
    String expectedAge = "";
    String expectedEmail="";
    String expectedCountry="";


    @Given("{actor} wants to sign up in the application")

    //camel case
    public void wantsToSignUpInTheApplication(Actor actor) {
        actor.attemptsTo(
               // Open.url(""));
                Open.browserOn(new RegisterPage()));
    }


    @When("{actor} send the required information to sign up")
    public void sendsRequiredInformationToSignUp(Actor actor, DataTable userInfo) throws URISyntaxException {

        List<List<String>> rows = userInfo.asLists(String.class);

        for(List<String> columns: rows){
            expectedName = columns.get(0);
            expectedLastName = columns.get(1);
            expectedAge = columns.get(2);
            expectedEmail = columns.get(3);
            expectedCountry = columns.get(4);
        }


        actor.attemptsTo(
                new RegisterUser(expectedName,expectedLastName,expectedAge,expectedEmail,expectedCountry)
          /*      Enter.theValue(expectedName).into("  //input[@id='name']"),
                Enter.theValue(expectedLastName).into("  //input[@id='last-name']"),
                Enter.theValue(expectedAge).into("  //input[@id='age']"),
                SelectFromOptions.byVisibleText(expectedCountry).from("//select[@id='country']"),
                Click.on("//input[@id='sex-m']"),
                Enter.theValue(expectedEmail).into("//input[@type='email']"),
                Click.on("//input[@id='monday']"),
                Upload.theClasspathResource("pictures/Hilson_IMG.jpeg")
                        .to(Target.the("picture field").locatedBy("//input[@id='picture']")),
                Click.on("//button[@id='save-btn']")
*/
        );
    }
    @Then("{actor} should have a new account created")
    public void shouldHaveaNewAccountCreated(Actor actor){
        actor.attemptsTo(
        new CheckNewAccountCreated(expectedName,expectedLastName)

  //lleve esto para la clase de Taks, clase CheckNewAccountCreated
       /*         Switch.toWindowTitled("Summary"),
                Ensure.that(Target.the("name")
                        .locatedBy("//strong[contains(text(),'Nombre')]/parent::p")).text()
                        .containsIgnoringCase(expectedName),
                Ensure.that(Target.the("last name")
                                .locatedBy("//strong[contains(text(),'Apellido')]/parent::p")).text()
                        .containsIgnoringCase(expectedLastName)
                        */

        );
    }

    @When("{actor} does not send the required information")
    public void doesNotSendTheRequiredInformation(Actor actor){
        actor.attemptsTo(
             new DoNotSendAllRequiredInformation(expectedName,expectedLastName)


                //Lleve esto para la clase do no send all required information
              /*  Enter.theValue(expectedName).into("  //input[@id='name']"),
                Enter.theValue(expectedLastName).into("  //input[@id='last-name']"),
                Click.on("//button[@id='save-btn']")


               */
        );
    }


    @Then("{actor} should be told all fields are required")
    public void shouldBeToldAllFieldsAreRequired (Actor actor){
        actor.attemptsTo(
             new ShouldSeeAllFieldsAreRequired()

                //Me lleve esto para la clase ShouldSeeAllFieldsAreRequired
              /* Ensure.that(Target.the("Required fields alert").
                       locatedBy("//div[@role='alert']")).text().
                       contains("Por favor diligencie todos los campos")

               */

        );

    }

}
