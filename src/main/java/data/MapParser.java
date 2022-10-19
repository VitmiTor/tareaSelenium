package data;

import models.Credentials;
import utilities.Logs;

import java.util.HashMap;

public class MapParser {
    private Logs logs = new Logs();
    private ExcelReader excelReader = new ExcelReader();

    public HashMap<String, Credentials> getCredentialsMap() {
        var map = new HashMap<String, Credentials>();
        var credentialList = excelReader.getCredentialsList();
        for (var credential : credentialList) {
            map.put(credential.getKey(), credential);

        }
        return map;
    }
}
