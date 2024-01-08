package com.example.seckillwly.vo;

import com.example.seckillwly.utils.ValidatorUtil;
import com.example.seckillwly.validator.IsMobile;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.thymeleaf.util.StringUtils;

public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {
    private boolean required = false;
    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (required){
            return ValidatorUtil.isMoible(value);
        }
        else {
            if (StringUtils.isEmpty(value)) {
                return true;
            }
            else {
                return ValidatorUtil.isMoible(value);
            }
        }
    }
}
