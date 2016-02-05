package test;

import java.util.Collection;

/**
 * Created by archeg on 2/1/2016.
 */
public interface IProperty<T extends Comparable<T>> {
    String getName();
    Collection<T> getAllowedValues();
    Class<T> getValueClass();
    String getName(T value);
}
