package com.arek.library.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public final class ListUtils {
    private ListUtils() {
        throw new UnsupportedOperationException("Class can't be instantiated");
    }

    public static <T, R> List<R> transform(final Iterable<T> source, final Function<T, R> mapper) {
        Objects.requireNonNull(source, "source can't be null");
        Objects.requireNonNull(mapper, "mapper can't be null");
        final List<R> result = new ArrayList<>();
        source.forEach(element -> {
            if (Objects.nonNull(element)) {
                result.add(mapper.apply(element));
            }
        });
        return result;
    }
}
