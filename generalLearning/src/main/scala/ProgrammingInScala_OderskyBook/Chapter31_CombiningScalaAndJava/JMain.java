/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter31_CombiningScalaAndJava;

import java.io.InvalidObjectException;
import java.util.Collection;
import java.util.Vector;

/**
 * Created by archeg on 10/10/2015.
 */
public class JMain implements SuperTrait {
    public void Run() throws InvalidObjectException {
        SuperTrait a = new SuperTrait() {
            @Override
            public void method() throws InvalidObjectException {

            }
        };

        a.method();
    }

    @Override
    public void method() {

    }

    Collection<?> contents() {
        Collection<String> stuff = new Vector<String>();
        stuff.add("a");
        stuff.add("b");
        stuff.add("see");
        return stuff;
    }
}
