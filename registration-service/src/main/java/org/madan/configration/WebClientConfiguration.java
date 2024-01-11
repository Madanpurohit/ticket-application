package org.madan.configration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfiguration {
    @Bean
    public WebClient webClient(@Value("${ticket.event.baseUrl}") String baseUrl){
        System.out.println(baseUrl);
        return WebClient.builder().baseUrl(baseUrl).build();
    }

    @Bean
    public WebClientInterface webClientInterface(WebClient webClient){
        return HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(webClient))
                .build().createClient(WebClientInterface.class);
    }
}
