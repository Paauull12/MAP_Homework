package Lab1.complexop;

import Lab1.domain.ComplexNumber;
import Lab1.domain.Utils;

public class ComplexExpression {

    protected ComplexNumber[] args;
    protected Operation operation;

    public ComplexExpression(ComplexNumber[] args, Utils.Operation op) {
        this.args = args;
        this.operation = switch (op){
            case Utils.Operation.ADDITION -> Operation.ADDITION;
            case Utils.Operation.SUBTRACTION -> Operation.SUBTRACTION;
            case Utils.Operation.MULTIPLICATION -> Operation.MULTIPLICATION;
            case Utils.Operation.DIVISION -> Operation.DIVISION;
        };
    }

    public ComplexNumber executeOneOperation(ComplexNumber nr1, ComplexNumber nr2){
        return operation.getOperationDefinition().apply(nr1, nr2);
    }

    public ComplexNumber execute() {
        if(args.length == 0)
            return new ComplexNumber(0, 0);

        ComplexNumber result = args[0];
        for(int i = 1; i < args.length; ++i){
            result = executeOneOperation(result, args[i]);
        }

        return result;
    }

}
