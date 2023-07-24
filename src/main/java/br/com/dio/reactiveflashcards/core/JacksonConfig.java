package br.com.dio.reactiveflashcards.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

public class JacksonConfig {

    @Bean
    ObjectMapper objectMapper (){
        return new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .setSerializationInclusion(NON_NULL)
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Bean
    Jackson2JsonEncoder jackson2JsonEncoder(final ObjectMapper objectMapper){
        return new Jackson2JsonEncoder(objectMapper);
    }

    @Bean
    Jackson2JsonDecoder jackson2JsonDecoder(final ObjectMapper objectMapper){
        return new Jackson2JsonDecoder(objectMapper);
    }
}
