package constant;

import org.openqa.selenium.By;

public class CT_Common {
    public static String URL_rise_signin = "https://rise.fairsketch.com/signin";

    // filter
    public static By PAGINATION = By.xpath("//ul[@class='pagination']");
    public static By TASK_MENU = By.xpath("//ul[@id='sidebar-menu']//a//span[text()='Tasks']");
    public static By RELATED_TO_VALUE_COLUMNS = By.xpath("//table[@id='task-table']//tr//td[6]//a");
    public static By MILESTONE_VALUE_COLUMNS = By.xpath("//table[@id='task-table']//tr//td[5]");
    public static By ASSIGNED_TO_VALUE_COLUMNS = By.xpath("//table[@id='task-table']//tr//td[7]");
    public static By PRIORITY_VALUE_COLUMNS = By.xpath("//table[@id='task-table']//tr//td[2]//span[contains(@class,'priority-badge')]/..");
    public static By LABEL_VALUE_COLUMNS = By.xpath("//table[@id='task-table']//tr//td[2]//span[@title='Label']");
    public static By DEADLINE_VALUE_COLUMNS = By.xpath("//table[@id='task-table']//tr//td[4]//span");


}
