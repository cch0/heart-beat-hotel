package com.test.websocket.model;

import org.joda.time.DateTime;

public class HeartBeat {
    DateTime current;

    public HeartBeat(DateTime current)
    {
        this.current = current;
    }

    public DateTime getCurrent() {
        return current;
    }

}
