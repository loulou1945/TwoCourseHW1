package org.skypro.skyshop.search;

import java.io.IOException;

public class BestResultNotFound extends IOException {
    private BestResultNotFound () {
        super();
    }

    public BestResultNotFound(String message) {
        super(message);
    }

    private BestResultNotFound(String message, Throwable t) {
        super(message, t);
    }

    private BestResultNotFound(Throwable t) {
        super(t);
    }
}
