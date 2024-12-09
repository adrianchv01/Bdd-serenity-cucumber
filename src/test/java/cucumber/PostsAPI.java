package cucumber;

import cucumber.utils.Constantes;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PostsAPI {

    public static String GET_POSTS = Constantes.BASE_URL + "/public/v2/posts";

    @Step("Get posts")
    public void obtenerPosts(int usuario, String titulo, String cuerpo) {
        SerenityRest.given()
                .queryParam("user_id", usuario)
                .queryParam("title", titulo)
                .queryParam("body", cuerpo);

        }

}
