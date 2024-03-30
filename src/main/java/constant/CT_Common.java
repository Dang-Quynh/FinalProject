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
    public static By DEADLINE_VALUE_COLUMNS = By.xpath("//table[@id='task-table']//tr//td[4]");
    public static By STATUS_VALUE_COLUMNS = By.xpath("//table[@id='task-table']//tr//td[9]//a");

    public static By MANAGE_FILTER_DROPDOWN = By.xpath("//button[contains(@class,'smart-filter-dropdown')]");
    public static By MANAGE_FILTER_BUTTON = By.xpath("//a[contains(@class,'manage-filters-button')]");
    public static By MANAGE_FILTER_TABLE_SEARCH = By.xpath("//div[@id='filters-table_filter']//input");
    public static By MANAGE_FILTER_TABLE_TITLE = By.xpath("//table[@id='filters-table']//td[1]");
    public static By MANAGE_FILTER_TABLE_TOTAL_ITEM = By.id("filters-table_info");
    public static By ADD_FILTER_TITLE_ERROR = By.id("title-error");
    public static String ADD_FILTER_TITLE_ERROR_TEXT = "This field is required.";
}
