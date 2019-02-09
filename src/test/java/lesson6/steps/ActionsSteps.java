package lesson6.steps;

import base.lesson6.SelenideIndexPage;
import base.lesson6.User;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;

public class ActionsSteps {

    @When("^I login as user '([^\"]*)' with password '([^\"]*)'$")
    public void iLoginAsUserWithPassword(String username, String password) {
        new SelenideIndexPage().login(username,password);
    }

    @When("^I login as user '([^\"]*)'$")
    public void iLoginAsUser(User user) {
        new SelenideIndexPage().login(user);
    }
}
