package com.roman.java.template1.configs;

import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI template1Api() {
        return new OpenAPI()
                .components(getComponents())
                .info(getInfo())
//                .addServersItem(getHttpsServer())
                .addSecurityItem(getBearerSecurityRequirement())
                .addSecurityItem(getOAuthSecurityRequirement());
    }

    private Components getComponents() {
        Components components = new Components();
        components.addSecuritySchemes("Bearer", getBearerSecurityScheme());
//        components.addSecuritySchemes("OAuth2", getOAuthSecurityScheme());
        return components;
    }

    private SecurityScheme getBearerSecurityScheme() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");
    }

    private SecurityScheme getOAuthSecurityScheme() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.OAUTH2)
                .flows(getOAuthFlows());
    }

    // This flow currently doesn't work due to OAuthFlows not including the 'audience'
    // header, therefore returning an encrypted token. Login is ok but requests through Swagger
    // fail as the token is invalid
    private OAuthFlows getOAuthFlows() {
        OAuthFlows oauthFlows = new OAuthFlows();
        OAuthFlow authorizationCodeFlow = new OAuthFlow();
        authorizationCodeFlow.authorizationUrl("https://dev-rgzfpafckaqnsp78.us.auth0.com/authorize");
        authorizationCodeFlow.tokenUrl("https://dev-rgzfpafckaqnsp78.us.auth0.com/oauth/token");
        oauthFlows.setAuthorizationCode(authorizationCodeFlow);

        return oauthFlows;
    }

    private SecurityRequirement getBearerSecurityRequirement() {
        SecurityRequirement securityRequirement = new SecurityRequirement();
        securityRequirement.addList("Bearer");
        return securityRequirement;
    }

    private SecurityRequirement getOAuthSecurityRequirement() {
        SecurityRequirement securityRequirement = new SecurityRequirement();
        securityRequirement.addList("OAuth2");
        return securityRequirement;
    }

    private Info getInfo() {
        return new Info()
                .title("Template1")
                .version("0.0.1");
    }

    private Server getHttpsServer() {
        Server httpsServer = new Server();
        httpsServer.setUrl("https://fullstack-template1.api.romanpendrak.com");
        httpsServer.setDescription("SSL Environment");

        return httpsServer;
    }
}

