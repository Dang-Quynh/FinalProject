package constant;

import org.openqa.selenium.By;

public class CT_Common {
    public static String URL_rise_signin = "https://rise.fairsketch.com/signin";

    // filter
    public static By TASK_MENU = By.xpath("//ul[@id='sidebar-menu']//a//span[text()='Tasks']");
    public static By RELATED_TO_VALUE_COLUMNS = By.xpath("//table[@id='task-table']//tr//td[6]//a");

}
