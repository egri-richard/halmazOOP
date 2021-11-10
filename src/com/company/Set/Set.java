package com.company.Set;

import java.util.ArrayList;
import java.util.List;

public class Set<T> {
    private List<T> elements;

    public Set() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        if (!this.elements.contains(element)) {
            this.elements.add(element);
        }
    }

    public boolean remove(T element) {
        //return this.elements.remove(element);

        boolean removed = false;
        if (this.elements.contains(element)) removed = this.elements.remove(element);
        return removed;
    }

    public int getSize() {
        return this.elements.size();
    }

    public void clear() {
        this.elements.clear();
    }

    public boolean isElement(T e) {
        return this.elements.contains(e);
    }

    public boolean isEmpty() {
        return this.elements.size() == 0;
    }

    public boolean isEqual(Set<T> list) {
        return this.getSize() == list.getSize() && this.isPartOf(list);
    }

    public boolean isPartOf(Set<T> list) {
        boolean isBigger = this.getSize() > list.getSize();
        boolean isPartOf = false;

        if (!isBigger) {
            int i = 0;
            while (i < this.getSize() && list.isElement(this.elements.get(i))) {
                i++;
            }

            isPartOf = i == this.getSize();
        }

        return isPartOf;
    }

    public Set<T> unio(Set<T> otherSet) {
        Set<T> unioSet = new Set<>();
        for (T e: this.elements) {
            unioSet.add(e);
        }
        for (T e: otherSet.elements) {
            if (!unioSet.elements.contains(e)) unioSet.add(e);
        }
        return unioSet;
    }

    public Set<T> intersection(Set<T> set) {
        Set<T> inter = new Set<>();

        for (T e: this.elements) {
            if (set.elements.contains(e)) inter.add(e);
        }

        return inter;
    }
}
