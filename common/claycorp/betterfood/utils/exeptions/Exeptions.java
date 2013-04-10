package claycorp.betterfood.utils.exeptions;

import claycorp.betterfood.utils.Archive;

public class Exeptions extends RuntimeException {

    /**
     * This Exception is not MY Fault
     */
    private static final long serialVersionUID = -6762134744912730876L;

    private String mError;

    public Exeptions(String var1) {
        this.mError = var1;
    }

    @Override
    public String toString() {
        return "The "
                + Archive.modName
                + " has a Problem.\nIT'S NOT MY FAULT! Below is how to fix it.\n"
                + this.mError
                + "\nDO NOT COME TO ME WITH THIS. YOU CAUSED IT YOURSELF, AND I TOLD YOU HOW TO FIX IT!";
    }
}