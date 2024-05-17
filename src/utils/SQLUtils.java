package utils;

public class SQLUtils {
    String url, driver, user, password, engineType;

    //Contstructors
    public SQLUtils() {
    }

    public SQLUtils(String url, String driver, String user, String password, String engineType) {
        setUrl(url);
        setDriver(driver);
        setUser(user);
        setPassword(password);
        setEngineType(engineType);
    }

    // Getter and setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}
