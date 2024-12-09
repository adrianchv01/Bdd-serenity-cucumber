@Test
Feature: Obtener posts

  Scenario: Obtener posts sin parametro
    Given El posts sin parametros
    When Se envia la solicitud de posts
    Then debería devolver el codigo 200
    And validar el posts de la lista de esquemas json

  Scenario: Obtener el user_id del posts
    Given el post con user_id "<usuario>"
    When Se envia la solicitud de posts
    Then debería devolver el codigo 200
    And Se envia la solicitud de posts

  Scenario: Obtener el titulo del posts
    Given el posts con titulo "<titulo>"
    When Se envia la solicitud de posts
    Then debería devolver el codigo 200
    And validar el email del usuario debe contener "<titulo>"

  Scenario: Obtener el cuerpo del posts
    Given el posts con body "<cuerpo>"
    When Se envia la solicitud de posts
    Then debería devolver el codigo 200
    And validar el body del post debe contener "<cuerpo>"