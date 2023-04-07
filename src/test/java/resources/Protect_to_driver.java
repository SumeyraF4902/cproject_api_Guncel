package resources;

import org.openqa.selenium.WebDriver;

public class Protect_to_driver {
    protected WebDriver driver;

    public Protect_to_driver(WebDriver driver) {
        this.driver = driver;
    }

}
