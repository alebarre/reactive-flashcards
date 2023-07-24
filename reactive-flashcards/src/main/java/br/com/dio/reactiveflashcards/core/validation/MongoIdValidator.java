package br.com.dio.reactiveflashcards.core.validation;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class MongoIdValidator implements ConstraintValidator<MongoId, String> {
    @Override
    public void initialize(MongoId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("===== Checking if {} is a valid mongoDB id");
        return StringUtils.isNotBlank(value) && ObjectId.isValid(value);
    }
}
