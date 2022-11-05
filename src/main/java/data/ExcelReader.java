package data;

import com.poiji.bind.Poiji;
import models.Credentials;
import utilities.Logs;

import java.io.File;
import java.util.List;

public class ExcelReader {
    private Logs logs = new Logs();
    private final String excelPath = "src/test/resources/data/TareaPOM.xlsx";

    public List<Credentials> getCredentialsList() {
        logs.debug("leyendo Excel");
        return Poiji.fromExcel(new File(excelPath), Credentials.class);
    }
}
