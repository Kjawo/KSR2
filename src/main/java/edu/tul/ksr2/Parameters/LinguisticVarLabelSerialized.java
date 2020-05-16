package edu.tul.ksr2.Parameters;

import edu.tul.ksr2.MembershipFunctions.MembershipFunction;
import edu.tul.ksr2.MembershipFunctions.trapmf;
import edu.tul.ksr2.MembershipFunctions.trimf;
import org.simpleframework.xml.Element;

class LinguisticVarLabelSerialized {
    @Element(name="Name")
    private String label;

    @Element(name="Membership")
    private String membership;

    @Element(name="A")
    private double a;
    @Element(name="B")
    private double b;
    @Element(name="C")
    private double c;
    @Element(name="D", required=false)
    private double d;

    public String getLabel() {
        return label;
    }

    public String getMembership() {
        return membership;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public MembershipFunction getMembershipFunction(){
        switch (this.membership) {
            case "Trapezoidal":
                return new trapmf(this.a, this.b, this.c, this.d);
            case "Triangular":
                return new trimf(this.a, this.b, this.c);
            default:
                return null;
        }
    }
}
