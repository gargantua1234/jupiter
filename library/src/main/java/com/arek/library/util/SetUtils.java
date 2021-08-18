package com.arek.library.util;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class SetUtils {
    private SetUtils() {
        throw new UnsupportedOperationException("Class can't be instantiated");
    }

    public static <T, R> Set<R> transform(final Collection<T> collection,
            final Function<T, R> mapper) {
        Objects.requireNonNull(collection, "collection can't be null");
        Objects.requireNonNull(mapper, "mapper can't be null");

        return collection.stream()
                .filter(Objects::nonNull)
                .map(mapper)
                .collect(Collectors.toSet());
    }
}
