package edu.tul.ksr2.Parameters;

import edu.tul.ksr2.MembershipFunctions.MembershipFunction;
import edu.tul.ksr2.MembershipFunctions.trapmf;
import edu.tul.ksr2.MembershipFunctions.trimf;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

class QuantifierSerialized {
    @Element(name="Name")
    private String name;

    @Element(name="Membership")
    private String membership;

    @Element(name="isRelative")
    private boolean isRelative;

    @Element(name="A")
    private double a;
    @Element(name="B")
    private double b;
    @Element(name="C")
    private double c;
    @Element(name="D", required=false)
    private double d;

    public String getName() {
        return name;
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

    public boolean isRelative() {
        return isRelative;
    }

    public MembershipFunction getMembershipFunction(){
        switch (this.membership) {
            case "Trapezoidal":
                return new trapmf(this.a, this.b, this.c, this.d, this.isRelative);
            case "Triangular":
                return new trimf(this.a, this.b, this.c, this.isRelative);
            default:
                return null;
        }
    }
}
