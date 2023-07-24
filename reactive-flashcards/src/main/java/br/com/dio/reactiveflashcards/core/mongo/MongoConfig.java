package br.com.dio.reactiveflashcards.core.mongo;

import br.com.dio.reactiveflashcards.core.mongo.converter.DateToOffsetDateTimeConverter;
import br.com.dio.reactiveflashcards.core.mongo.converter.OffSetDateTimeToDateConverter;
import br.com.dio.reactiveflashcards.core.mongo.provider.OffSetDateTimeProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableMongoAuditing (dateTimeProviderRef = "dateTimeProvider")
public class MongoConfig {

    @Bean
    MongoCustomConversions mongoCustomConverters(){
        final List<Converter<?,?>> converters = new ArrayList<>();
        converters.add(new OffSetDateTimeToDateConverter());
        converters.add(new DateToOffsetDateTimeConverter());
        return new MongoCustomConversions(converters);
    }

}
