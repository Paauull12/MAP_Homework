package Lab1.expfactory;

import Lab1.complexop.*;
import Lab1.domain.ComplexNumber;
import Lab1.domain.Utils;

public class ExpressionFactory {

    private static ExpressionFactory instance;

    private ExpressionFactory(){}

    public static ExpressionFactory getInstance(){
        if(instance == null){
            instance = new ExpressionFactory();
        }
        return instance;
    }

    public ComplexExpression createExpression(Utils.Operation operation, ComplexNumber[] args){
        return new ComplexExpression(args, operation);
    }

}
