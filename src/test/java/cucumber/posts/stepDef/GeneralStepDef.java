package cucumber.posts.stepDef;

import cucumber.PostsAPI;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GeneralStepDef {
    @Steps
    PostsAPI postsAPI;
    @Then("debería devolver el codigo {int}")
    public void deberiaRetornarCodigo(int statusCode) {
        SerenityRest.then().assertThat().statusCode(statusCode);
    }

}
