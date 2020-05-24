package edu.tul.ksr2.Parameters;

import edu.tul.ksr2.MembershipFunctions.MembershipFunction;
import edu.tul.ksr2.MembershipFunctions.trapmf;
import edu.tul.ksr2.MembershipFunctions.trimf;
import edu.tul.ksr2.Parameters.TableView.QuantifierTableRow;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

public class QuantifierSerialized {
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

    public QuantifierSerialized(QuantifierTableRow q) {
        this.name = q.getName();
        this.membership = q.getMembership().get();
        this.isRelative = q.getIsRelative().get();
        this.a = q.getA();
        this.b = q.getB();
        this.c = q.getC();
        this.d = q.getD();
    }

    public QuantifierSerialized(String name, String membership, boolean isRelative, double a, double b, double c, double d) {
        this.name = name;
        this.membership = membership;
        this.isRelative = isRelative;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public QuantifierSerialized(String name, String membership, boolean isRelative, double a, double b, double c) {
        this.name = name;
        this.membership = membership;
        this.isRelative = isRelative;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public QuantifierSerialized() {
    }
}
