package edu.tul.ksr2.Sets;

import java.util.ArrayList;
import java.util.HashSet;

public class CrispSet<T> {
    public HashSet<T> values;

    public CrispSet(HashSet<T> values) {
        this.values = values;
    }

    public boolean Equals(CrispSet<T> set) {
        return set.values.containsAll(this.values);
    }

    public CrispSet<T> Union(CrispSet<T> set) {
        HashSet<T> result = this.values;

        for (var val : set.values) {
            if (!this.values.contains(val)) {
                result.add(val);
            }
        }
        return new CrispSet<T>(result);
    }

    public CrispSet<T> Intersection(CrispSet<T> set) {
        HashSet<T> result = new HashSet<T>();

        for (var val : set.values) {
            if (this.values.contains(val)) {
                result.add(val);
            }
        }
        return new CrispSet<T>(result);
    }

    public CrispSet<T> Complement(CrispSet<T> set) {
        HashSet<T> result = new HashSet<T>();

        for (var val : set.values) {
            if (!this.values.contains(val)) {
                result.add(val);
            }
        }
        return new CrispSet<T>(result);
    }


}
