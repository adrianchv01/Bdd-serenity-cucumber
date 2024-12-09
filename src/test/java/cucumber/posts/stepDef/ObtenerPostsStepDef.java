package cucumber.posts.stepDef;

import cucumber.PostsAPI;
import cucumber.utils.Constantes;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.*;

public class ObtenerPostsStepDef {

    @Steps
    PostsAPI postsAPI;

    @Given("El posts sin parametros")
    public void postsSinParametro(){
        SerenityRest.given();
    }

    @When("Se envia la solicitud de posts")
    public void enviarSolicitudDePosts(){
        SerenityRest.when().get(PostsAPI.GET_POSTS);
    }

    @And("validar el posts de la lista de esquemas json")
    public void validarPostsJsonEsquema() {
        File jsonSchema = new File("/Users/adrian/IdeaProjects/t2_AdrianChavez/src/test/resources/JSON/Schema/ResponsePostsSchemaValid.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("el post con user_id {int}")
    public void elPostConUserId(int usuario) {
        postsAPI.obtenerPosts(usuario,"","");
    }

    @And("validar el id del usuario el cual debe ser {int}")
    public void validarIdUsuario(int user_id) {
        SerenityRest.then()
                .assertThat()
                .body("user_id", everyItem(equalTo(user_id)));

    }

    @Given("el posts con titulo {string}")
    public void postsConTitulo(String titulo) {
        postsAPI.obtenerPosts(0, titulo, "");
    }

    @And("validar el email del usuario debe contener {string}")
    public void validarTitlePostsDebeContener(String title) {
        SerenityRest.then()
                .assertThat()
                .body("title", everyItem(containsString(title)));
    }

    @Given("el posts con body {string}")
    public void postsConCuerpo(String cuerpo) {
        postsAPI.obtenerPosts( 0, "", cuerpo);
    }

    @And("validar el body del post debe contener {string}")
    public void validarBodyPostsDebeContener(String body) {
        SerenityRest.then()
                .assertThat()
                .body("body", everyItem(containsString(body)));
    }

}
