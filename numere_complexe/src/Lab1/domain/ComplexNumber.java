package Lab1.domain;

public class ComplexNumber{

    private int re;
    private int img;
    private Sign sign;

    private enum Sign {
        PLUS, MINUS;

        public static Sign fromChar(char c) {
            return c == '+' ? PLUS : MINUS;
        }

        @Override
        public String toString() {
            return this == PLUS ? "+" : "-";
        }
    }

    public void setRe(int re) {
        this.re = re;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getRe() {
        return re;
    }

    public int getImg() {
        return img;
    }

    private Sign getSign() {
        return sign;
    }

    public ComplexNumber(int re, int img, int withMinus) {
        this.re = re;
        this.img = img;
        if(withMinus != 0)
            this.sign = Sign.MINUS;
    }

    public ComplexNumber(ComplexNumber number){
        this.re = number.getRe();
        this.img = number.getImg();
        this.sign = number.getSign();
    }

    public ComplexNumber(int re, int img) {
        this.re = re;
        this.img = img;
        this.sign = Sign.PLUS;
    }

    public ComplexNumber(String compNr){
        int index = compNr.charAt(0) == '-' ? 1 : 0;

        compNr = compNr.strip();

        while(Character.isDigit(compNr.charAt(index))){
            index++;
        }

        this.sign =  Sign.fromChar(compNr.charAt(index));

        this.re = Integer.parseInt(compNr.substring(0, index));
        this.img = Integer.parseInt(compNr.substring(index + 1, compNr.length() - 2));
    }

    @Override
    public String toString(){
        return "The complex number is: " + this.re + ' ' + this.sign + ' ' + this.img + "i";
    }

    public ComplexNumber complement(){
        if(this.sign == Sign.PLUS)
            return new ComplexNumber(this.re, this.img, 1);
        return new ComplexNumber(this.re, this.img);
    }

    public Utils.Pair getActNumbers(ComplexNumber number) {
        int actImg = this.img;

        if(this.sign == Sign.MINUS)
            actImg *= -1;

        int actImgForNumber = number.getImg();

        if(number.getSign() == Sign.MINUS)
            actImgForNumber *= -1;

        return new Utils.Pair(actImg, actImgForNumber);
    }

}
