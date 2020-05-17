package edu.tul.ksr2.MembershipFunctions;

public class trimf implements MembershipFunction {
    private double a, b, c;

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
    public String generateLatexEq(String name) {
//   \begin{equation}
//    \mu_A(x) = \begin{cases}
//        (x - a) / (b - a) & \mbox{dla  } x \in [a,\, b], \\
//        1                 & \mbox{dla  } x \in [b,\, c], \\
//        (d - x) / (d - c) & \mbox{dla  } x \in [c,\, d], \\
//        0                 & \mbox{dla  } x \in (-\infty, a] \cup  [d,\, +\infty)
//    \end{cases}
//  \end{equation}
        name.trim();
        name.replaceAll("\\\\s+", "\\_");

        String result = "\\begin{equation}\n";
        result += "\\mu_" + name + "(x) = \\begin{cases}\n";
        result += "\t" + "TRIANGULAR (x - " + String.valueOf(this.a) + ") / (" + String.valueOf(this.b) + " - " + String.valueOf(this.a) + ") & \\mbox{dla  } x \\in [" + String.valueOf(this.a) + ",\\, " + String.valueOf(this.b) + "], \\\\\n";
        result += "\t" + " 1                 & \\mbox{dla  } x \\in [" + String.valueOf(this.b) + ",\\, " + String.valueOf(this.c) + "], \\\\\n";
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
                '}';
    }
}
