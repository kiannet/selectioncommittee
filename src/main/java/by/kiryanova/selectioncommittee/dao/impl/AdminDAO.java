package by.kiryanova.selectioncommittee.dao.impl;

import java.util.concurrent.atomic.AtomicBoolean;

public class AdminDAO {
    private static final String INSERT_ENROLLEE = "user";

    private static final AdminDAO INSTANCE;
    private static AtomicBoolean instanceCreated = new AtomicBoolean(false);

    static {
        INSTANCE = new AdminDAO();
        instanceCreated.set(true);
    }

    private AdminDAO(){
        if (instanceCreated.get()) {
            //LOGGER.log(Level.FATAL, "Tried to create singleton object with reflection api");
            throw new RuntimeException("Tried to create singleton object with reflection api");
        }
    }

    public static AdminDAO getInstance() {
        return INSTANCE;
    }

    public void addEnrollee(String surname, String name, String secondName, String passportId, String phone, String certificate ){

    }
}
