package models;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("Credenciales")
public class Credentials {
    @ExcelCellName("key")
    private String key;
    @ExcelCellName("username")
    private String username;
    @ExcelCellName("password")
    private String password;

    public String getKey() {
        return key;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}