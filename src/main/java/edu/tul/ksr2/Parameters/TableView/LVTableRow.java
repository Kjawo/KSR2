package edu.tul.ksr2.Parameters.TableView;

import edu.tul.ksr2.LinguisticVariable.LinguisticVariable;
import edu.tul.ksr2.LinguisticVariable.Quantifier;
import edu.tul.ksr2.MembershipFunctions.MembershipFunction;
import edu.tul.ksr2.MembershipFunctions.trapmf;
import edu.tul.ksr2.MembershipFunctions.trimf;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LVTableRow {

        private SimpleStringProperty label;
        private SimpleStringProperty membership;
        private SimpleBooleanProperty isRelative;
        private SimpleDoubleProperty a;
        private SimpleDoubleProperty b;
        private SimpleDoubleProperty c;
        private SimpleDoubleProperty d;

        public LVTableRow(String label, String membership, boolean isRelative, double a, double b, double c, double d) {
            this.label = new SimpleStringProperty(label);
            this.membership = new SimpleStringProperty(membership);
            this.isRelative = new SimpleBooleanProperty(isRelative);
            this.a = new SimpleDoubleProperty(a);
            this.b = new SimpleDoubleProperty(b);
            this.c = new SimpleDoubleProperty(c);
            this.d = new SimpleDoubleProperty(d);
        }

        public LVTableRow(SimpleStringProperty label, SimpleStringProperty membership, SimpleBooleanProperty isRelative, SimpleDoubleProperty a, SimpleDoubleProperty b, SimpleDoubleProperty c, SimpleDoubleProperty d) {
            this.label = label;
            this.membership = membership;
            this.isRelative = isRelative;
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

    public LVTableRow() {

    }

    public LVTableRow(LinguisticVariable lv, int i) {
        this.label = new SimpleStringProperty(lv.getLabels().get(i));
        this.membership = new SimpleStringProperty(lv.getMembershipFunctions().get(i).getName());
        this.isRelative = new SimpleBooleanProperty(lv.getMembershipFunctions().get(i).isRelative());
        this.a = new SimpleDoubleProperty(lv.getMembershipFunctions().get(i).getA());
        this.b = new SimpleDoubleProperty(lv.getMembershipFunctions().get(i).getB());
        this.c = new SimpleDoubleProperty(lv.getMembershipFunctions().get(i).getC());
        this.d = new SimpleDoubleProperty(lv.getMembershipFunctions().get(i).getD());
    }


    public String getLabel() {
            return label.get();
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

        public SimpleBooleanProperty getIsRelative() {
            return isRelative;
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

    public void setLabel(String label) {
        this.label.set(label);
    }

    public void setMembership(String membership) {
        this.membership.set(membership);
    }

    public void setIsRelative(SimpleBooleanProperty isRelative) {
        this.isRelative = isRelative;
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

