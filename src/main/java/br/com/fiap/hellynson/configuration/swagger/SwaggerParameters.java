package br.com.fiap.hellynson.configuration.swagger;

import springfox.documentation.service.Contact;

/**
 * Parameters used to configure Swagger 2.
 *
 * @author Gabriel Oliveira
 */
public class SwaggerParameters {

    protected static final String TITLE = "HELLYN-SON";

    protected static final String DESCRIPTION = "FIAP PS 2020 - DISRUPT21";

    protected static final String API_VERSION = "1.0.0-RELEASE";

    protected static final Contact CONTACT = new Contact("Gabriel Guarido",
            "https://www.linkedin.com/in/gabriel-guarido-oliveira/",
            "gabrielguarido.oliveira@gmail.com");

}
