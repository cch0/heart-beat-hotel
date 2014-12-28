package com.test.websocket.model;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class DateRolledMessage {
    LocalDate newDate;

    DateTime timestamp;

    public DateRolledMessage(LocalDate newDate, DateTime timestamp)
    {
        this.newDate = newDate;
        this.timestamp = timestamp;
    }

    public LocalDate getNewDate() {
        return newDate;
    }

    public DateTime getTimestamp() {
        return timestamp;
    }
}
