package edu.tul.ksr2.Parameters.TableView;

import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.MembershipFunctions.MembershipFunction;
import edu.tul.ksr2.MembershipFunctions.trapmf;
import edu.tul.ksr2.MembershipFunctions.trimf;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class QuantifierTableRow {

        private SimpleStringProperty name;
        private SimpleStringProperty membership;
        private SimpleBooleanProperty isRelative;
        private SimpleDoubleProperty a;
        private SimpleDoubleProperty b;
        private SimpleDoubleProperty c;
        private SimpleDoubleProperty d;

        public QuantifierTableRow(String name, String membership, boolean isRelative, double a, double b, double c, double d) {
            this.name = new SimpleStringProperty(name);
            this.membership = new SimpleStringProperty(membership);
            this.isRelative = new SimpleBooleanProperty(isRelative);
            this.a = new SimpleDoubleProperty(a);
            this.b = new SimpleDoubleProperty(b);
            this.c = new SimpleDoubleProperty(c);
            this.d = new SimpleDoubleProperty(d);
        }

        public QuantifierTableRow(SimpleStringProperty name, SimpleStringProperty membership, SimpleBooleanProperty isRelative, SimpleDoubleProperty a, SimpleDoubleProperty b, SimpleDoubleProperty c, SimpleDoubleProperty d) {
            this.name = name;
            this.membership = membership;
            this.isRelative = isRelative;
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

    public QuantifierTableRow(Quantifier q) {
        this.name = new SimpleStringProperty(q.getName());
        this.membership = new SimpleStringProperty(q.getMembershipFunction().getName());
        this.isRelative = new SimpleBooleanProperty(q.getMembershipFunction().isRelative());
        this.a = new SimpleDoubleProperty(q.getMembershipFunction().getA());
        this.b = new SimpleDoubleProperty(q.getMembershipFunction().getB());
        this.c = new SimpleDoubleProperty(q.getMembershipFunction().getC());
        this.d = new SimpleDoubleProperty(q.getMembershipFunction().getD());
    }

    public QuantifierTableRow() {

    }


    public String getName() {
            return name.get();
        }

        public StringProperty getMembership() {
            return membership;
        }

        public double getA() {
            return a.get();
        }

        public double getB() {
            return b.get();
        }

        public double getC() {
            return c.get();
        }

        public double getD() {
            return d.get();
        }

        public boolean getIsRelative() {
            return isRelative.get();
        }

        public MembershipFunction getMembershipFunction(){
            switch (this.membership.get()) {
                case "Trapezoidal":
                    return new trapmf(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.isRelative.get());
                case "Triangular":
                    return new trimf(this.a.get(), this.b.get(), this.c.get(), this.isRelative.get());
                default:
                    return null;
            }
        }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setMembership(String membership) {
        this.membership.set(membership);
    }

    public void setIsRelative(boolean isRelative) {
        this.isRelative.set(isRelative);
    }

    public void setA(double a) {
        this.a.set(a);
    }

    public void setB(double b) {
        this.b.set(b);
    }

    public void setC(double c) {
        this.c.set(c);
    }

    public void setD(double d) {
        this.d.set(d);
    }

    private final StringProperty option = new SimpleStringProperty();

    public String getOption() {
        return option.get();
    }

    public void setOption(String value) {
        option.set(value);
    }
    public StringProperty optionProperty() {
        return option;
    }

    public void setMembership(StringProperty newValue) {
        this.membership.set(newValue.get());
    }
}

