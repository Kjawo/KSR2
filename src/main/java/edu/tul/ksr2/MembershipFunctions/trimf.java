package edu.tul.ksr2.MembershipFunctions;

public class trimf implements MembershipFunction {
    private double a, b, c;
    private boolean isRelative = false;

    public trimf(double a, double b, double c, boolean isRelative) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.isRelative = isRelative;
    }

    public trimf(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double compute(double x) {
        if (x == b) {
            return 1;
        } else if ( x > a && x <= b) {
            return (1.0/(b-a)) * (x - a);
        } else if (x > b && x < c) {
            return (-1.0/(c-b))*(x-c);
        } else
            return 0;
    }

    @Override
    public double compute(double x, double totalAmount) {
        if(isRelative){
            return compute(x/totalAmount);
        } else {
            return compute(x);
        }
    }

    @Override
    public String generateLatexEq(String name) {
//   \begin{equation}
//    \mu_A(x) = \begin{cases}
//        (x - a) / (b - a) & \mbox{dla  } x \in [a,\, b], \\
//        1                 & \mbox{dla  } x \in [b,\, c], \\
//        (d - x) / (d - c) & \mbox{dla  } x \in [c,\, d], \\
//        0                 & \mbox{dla  } x \in (-\infty, a] \cup  [d,\, +\infty)
//    \end{cases}
//  \end{equation}
        String trimmedName = name.trim();
        trimmedName = trimmedName.replace(" ", "\\_");

        String result = "\\begin{equation}\n";
        result += "\\mu_{" + trimmedName + "}(x) = \\begin{cases}\n";
        result += "\t" + "\\frac{(x - " + String.valueOf(this.a) + ")} {(" + String.valueOf(this.b) + " - " + String.valueOf(this.a) + ")} & \\mbox{dla } x \\in (" + String.valueOf(this.a) + ",\\, " + String.valueOf(this.b) + "), \\\\";
        result += "\t" + "1                 & \\mbox{dla } x = " + String.valueOf(this.b) + ", \\\\";
        result += "\t" + "\\frac{(" + String.valueOf(this.c) + " - x)} {(" + String.valueOf(this.c) + " - " + String.valueOf(this.b) + ")} & \\mbox{dla } x \\in (" + String.valueOf(this.b) + ",\\, " + String.valueOf(this.c) + "), \\\\";
//        result += "\t" + "0                 & \\mbox{dla } x \\in (-\\infty, " + String.valueOf(this.a) + "] \\cup  [" + String.valueOf(this.c) + ",\\, +\\infty)";
        result += "\\end{cases}\n";
        result += "\\end{equation}\n";
        return result;
    }

    @Override
    public String toString() {
        return "trimf{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", isRelative=" + isRelative +
                '}';
    }

    @Override
    public double getA() {
        return a;
    }

    @Override
    public double getB() {
        return b;
    }

    @Override
    public double getC() {
        return c;
    }

    @Override
    public double getD() {
        return 0;
    }

    @Override
    public boolean isRelative() {
        return isRelative;
    }

    @Override
    public String getName() {
        return "Triangular";
    }


}
