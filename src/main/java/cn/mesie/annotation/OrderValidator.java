package cn.mesie.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2019-03-17 20:31
 * 排序验证
 * @author: mesie
 */
public class OrderValidator implements ConstraintValidator<Order, String> {

    private List<String> valueList;

    @Override
    public void initialize(Order order) {
        valueList = new ArrayList<String>();
        for (String val : order.accepts()) {
            valueList.add(val.toUpperCase());
        }
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (!valueList.contains(s.toUpperCase())) {
            return false;
        }
        return true;
    }
}
