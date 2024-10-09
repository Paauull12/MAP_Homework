package Lab1.complexop;

import Lab1.domain.ComplexNumber;
import Lab1.domain.Utils;

import java.util.function.BiFunction;

public enum Operation {
    ADDITION(Operation::add),
    SUBTRACTION(Operation::sub),
    MULTIPLICATION(Operation::mul),
    DIVISION(Operation::div);

    private final BiFunction<ComplexNumber, ComplexNumber, ComplexNumber> operation;

    Operation(BiFunction<ComplexNumber, ComplexNumber, ComplexNumber> operation) {
        this.operation = operation;
    }

    private static ComplexNumber add(ComplexNumber nr1, ComplexNumber nr2) {
        Utils.Pair pair = nr1.getActNumbers(nr2);

        int actImg = pair.getFirst();
        int  actImgForNumber = pair.getSecond();

        return new ComplexNumber(nr1.getRe() + nr2.getRe(), actImg + actImgForNumber);
    }

    private static ComplexNumber sub(ComplexNumber nr1, ComplexNumber nr2) {
        Utils.Pair pair = nr1.getActNumbers(nr2);

        int actImg = pair.getFirst();
        int  actImgForNumber = pair.getSecond();

        return new ComplexNumber(nr1.getRe() - nr2.getRe(), actImg - actImgForNumber);
    }

    private static ComplexNumber mul(ComplexNumber nr1, ComplexNumber nr2) {
        Utils.Pair pair = nr1.getActNumbers(nr2);

        int actImg = pair.getFirst();
        int  actImgForNumber = pair.getSecond();

        return new ComplexNumber(nr1.getRe() * nr2.getRe() - actImg * actImgForNumber,
                nr1.getRe() * actImgForNumber + nr2.getRe() * actImg);
    }

    private static ComplexNumber div(ComplexNumber nr1, ComplexNumber nr2) {
        Utils.Pair pair = nr1.getActNumbers(nr2);

        int actImg = pair.getFirst();
        int  actImgForNumber = pair.getSecond();

        int denominator = nr2.getRe() * nr2.getRe() + actImgForNumber * actImgForNumber;

        nr2 = nr2.complement();

        ComplexNumber resultInmultire = mul(nr1, nr2);
        resultInmultire.setRe(resultInmultire.getRe() / denominator);
        resultInmultire.setImg(resultInmultire.getImg() / denominator);

        return resultInmultire;
    }

    public BiFunction<ComplexNumber, ComplexNumber, ComplexNumber> getOperationDefinition() {
        return operation;
    }
}
