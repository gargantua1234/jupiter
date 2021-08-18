package com.arek.application;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.ToString;

@ToString
public enum ActionType {
    UPLOAD(1, "Sending"),
    DOWNLOAD(2, "Downloading");

    private final int priority;
    @JsonValue
    private final String action;

    ActionType(final int priority, final String action) {
        this.priority = priority;
        this.action = action;
    }
}
