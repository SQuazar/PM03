package net.quazar.exam.util;

public interface DtoMapper<F, T> {
    F mapFrom(T t);
    T mapTo(F f);
}
