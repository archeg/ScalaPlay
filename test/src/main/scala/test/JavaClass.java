/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package test;

import java.io.InvalidClassException;
import java.util.List;

/**
 * Created by archeg on 11/11/2015.
 */
public interface JavaClass{
    <E> List<E[]> arrayArg(List<? super E> elemEncoder);
    <E> E test();
}

