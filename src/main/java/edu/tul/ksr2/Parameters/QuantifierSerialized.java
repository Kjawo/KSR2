package edu.tul.ksr2.Parameters;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

class QuantifierSerialized {
    @Element(name="Name")
    private String name;

    @Element(name="Membership")
    private String membership;

    @Element(name="A")
    private double a;
    @Element(name="B")
    private double b;
    @Element(name="C")
    private double c;
    @Element(name="D")
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
}
