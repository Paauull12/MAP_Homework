package Lab1.expparser;

import Lab1.complexop.ComplexExpression;
import Lab1.domain.ComplexNumber;
import Lab1.domain.Utils;
import Lab1.expfactory.ExpressionFactory;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParser {

    private final String expression;

    public ExpressionParser(String exp){
        this.expression = exp.strip();
    }

    public boolean validate() throws Exception {
        List<String> lista = List.of(expression.split("i"));

        Pattern patternFirst = Pattern.compile("^[+-]?[0-9]+[+-]{1,2}[0-9]+\\*$");
        Pattern patternSecondRest = Pattern.compile("^[ ]*[+*/-][ ]*[+-]?[0-9]+[+-]{1,2}[0-9]+\\*$");

        getOperation();

        for (int i = 0; i < lista.size(); i++) {
            String s = lista.get(i);
            Matcher match;

            if (i == 0) {
                match = patternFirst.matcher(s);
            } else {
                match = patternSecondRest.matcher(s);
            }

            if (!match.find()) {
                return false;
            }
        }

        return true;
    }

    private ComplexNumber[] parseExpression(){
        List<String> lista = List.of(expression.split(" "));

        int size = 0;
        for(var it : lista){
            if(it.length() > 1){
                size++;
            }
        }

        ComplexNumber[] args = new ComplexNumber[size];
        int index = 0;

        for(String it : lista){
            if(it.length() > 1){
                ComplexNumber toShow = new ComplexNumber(it);
                args[index++] = toShow;
            }
        }

        return args;
    }

    private Utils.Operation getOperation() throws Exception{
        List<String> lista = List.of(expression.split(" "));

        char op1 = '!';
        for(var it : lista){
            if(it.length() == 1 && "+-*/".indexOf(it.charAt(0)) != -1){
                if(op1 == '!')
                    op1 = it.charAt(0);
                else if(op1 != it.charAt(0))
                    throw new Exception("The expression is not valid.");
            }
        }

        return switch (op1) {
            case '+' -> Utils.Operation.ADDITION;
            case '-' -> Utils.Operation.SUBTRACTION;
            case '*' -> Utils.Operation.MULTIPLICATION;
            case '/' -> Utils.Operation.DIVISION;
            default -> throw new Exception("The expression is not valid.");
        };
    }

    public ComplexExpression getComplexExpression() throws Exception{
        if(!this.validate())
            throw new Exception("The expression is not valid.");

        Utils.Operation operation = getOperation();

        ComplexNumber[] args = parseExpression();

        ExpressionFactory expFactory = ExpressionFactory.getInstance();

        return expFactory.createExpression(operation, args);
    }

}
