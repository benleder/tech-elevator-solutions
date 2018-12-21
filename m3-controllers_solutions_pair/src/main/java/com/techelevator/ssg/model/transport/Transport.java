package com.techelevator.ssg.model.transport;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Transport {

    WALKING("Walking", 3),
    CAR("Car", 100),
    BULLET_TRAIN("Bullet Train", 200),
    BOEING_747("Boeing 747", 570),
    CONCORDE("Concorde", 1350);

    private final String transportName;
    private final int mph;

    private Transport(String transportName, int mph) {
    		this.transportName = transportName;
    		this.mph = mph;
    	}

    public int getMPH() {
        return mph;
    }

    public String getTransportName() {
        return transportName;
    }

    public static List<Transport> getAllTransports() {
        return Collections.unmodifiableList(Arrays.asList(Transport.values()));
    }
}
