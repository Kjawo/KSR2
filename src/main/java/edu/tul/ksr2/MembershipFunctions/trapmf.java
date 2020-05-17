package edu.tul.ksr2.MembershipFunctions;

public class trapmf implements MembershipFunction {
    private double a, b, c, d;
    private boolean isRelative = false;

    public trapmf(double a, double b, double c, double d, boolean isRelative) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.isRelative = isRelative;
    }

    public trapmf(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double compute(double x) {
        if (x >= a && b > x) {
            return (x - a) / (b - a);
        }
        else if (x >= b && x <= c) {
            return 1.0;
        }
        else if (x > c && x <= d) {
            return (d - x) / (d - c);
        }
        else {
            return 0.0;
        }
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
        result += "\t" + "(x - " + String.valueOf(this.a) + ") / (" + String.valueOf(this.b) + " - " + String.valueOf(this.a) + ") & \\mbox{dla  } x \\in [" + String.valueOf(this.a) + ",\\, " + String.valueOf(this.b) + "], \\\\\n";
        result += "\t" + " 1                 & \\mbox{dla  } x \\in [" + String.valueOf(this.b) + ",\\, " + String.valueOf(this.c) + "], \\\\\n";
        result += "\t" + "(" + String.valueOf(this.d) + " - x) / (" + String.valueOf(this.d) + " - " + String.valueOf(this.c) + ") & \\mbox{dla  } x \\in [" + String.valueOf(this.c) + ",\\, " + String.valueOf(this.d) + "], \\\\\n";
        result += "\t" + "0                 & \\mbox{dla  } x \\in (-\\infty, " + String.valueOf(this.a) + "] \\cup  [" + String.valueOf(this.d) + ",\\, +\\infty)\n";
        result += "\\end{cases}\n";
        result += "\\end{equation}\n";
        return result;
    }

    @Override
    public String toString() {
        return "trapmf{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", isRelative=" + isRelative +
                '}';
    }
}
