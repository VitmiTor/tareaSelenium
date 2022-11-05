package data;

import models.Credentials;
import utilities.Logs;

public class DataProvider {
    private Logs logs = new Logs();
    private MapParser mapParser = new MapParser();
    private ExcelReader excelReader = new ExcelReader();

    public Credentials getValidCredentials() {
        logs.debug("getting Key");
        return mapParser.getCredentialsMap().get("valid");
    }

    public Credentials getInvalidValidCredentials() {
        logs.debug("getting Key");
        return mapParser.getCredentialsMap().get("invalid");
    }
}
