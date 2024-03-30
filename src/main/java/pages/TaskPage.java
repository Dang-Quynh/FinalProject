package pages;

import constant.CT_Common;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TaskPage {
    private WebDriver driver;
    private int initWaitTime = 10;

//    Filter
    @FindBy(xpath = "//div[@id='task-table_wrapper']//button[contains(@class,'show-filter-form-button')]")
    WebElement showFilterButton;
    @FindBy(id = "")
    WebElement dropdownQuickFilter;

    @FindBy(id = "s2id_autogen5")
    WebElement dropdownRelatedToFilter;
    @FindBy(id = "s2id_autogen6_search")
    WebElement inputSearchRelatedToFilter;

    @FindBy(id = "s2id_autogen7")
    WebElement dropdownProjectFilter;
    @FindBy(id = "s2id_autogen8_search")
    WebElement inputSearchProjectFilter;
    @FindBy(id = "s2id_autogen9")
    WebElement dropdownMilestoneFilter;
    @FindBy(xpath = "//ul[@id='select2-results-10']//li[3]")
    WebElement valueMilestoneFilter_release;
    @FindBy(xpath = "//ul[@id='select2-results-10']//li[2]")
    WebElement valueMilestoneFilter_beta_release;
    @FindBy(id = "s2id_autogen11")
    WebElement dropdownTeamMemberFilter;
    @FindBy(id = "s2id_autogen12_search")
    WebElement inputSearchTeamMemberFilter;
    @FindBy(id = "s2id_autogen13")
    WebElement dropdownPriorityFilter;
    @FindBy(id = "s2id_autogen14_search")
    WebElement inputSearchPriorityFilter;
    @FindBy(id = "s2id_autogen15")
    WebElement dropdownLabelFilter;
    @FindBy(id = "s2id_autogen16_search")
    WebElement inputSearchLabelFilter;
    @FindBy(xpath = "//button[@name='deadline']")
    WebElement dropdownDeadlineFilter;
    @FindBy(xpath = "//span[contains(@class,'filter-multi-select')]//button")
    WebElement dropdownStatusFilter;

    @FindBy(xpath = "//a[text()=' Add task']")
    WebElement addTaskBtn;
    @FindBy(xpath = "//input[@placeholder='Title']")
    WebElement addTask_titleInput;
    @FindBy(id = "s2id_task-context")
    WebElement addTask_RelateToDropdown;
    @FindBy(xpath = "//div[@id='select2-drop']//input")
    WebElement addTask_SelectSearchInput;
    @FindBy(id = "s2id_project_id")
    WebElement addTask_ProjectDropdown;
    @FindBy(id = "s2id_client_id")
    WebElement addTask_ClientDropdown;
    @FindBy(id = "s2id_contract_id")
    WebElement addTask_ContractDropdown;
    @FindBy(id = "s2id_estimate_id")
    WebElement addTask_EstimateDropdown;
    @FindBy(id = "s2id_expense_id")
    WebElement addTask_ExpenseDropdown;
    @FindBy(id = "s2id_invoice_id")
    WebElement addTask_InvoiceDropdown;
    @FindBy(id = "s2id_lead_id")
    WebElement addTask_LeadDropdown;
    @FindBy(id = "s2id_order_id")
    WebElement addTask_OrderDropdown;
    @FindBy(id = "s2id_proposal_id")
    WebElement addTask_ProposalDropdown;
    @FindBy(id = "s2id_subscription_id")
    WebElement addTask_SubscriptionDropdown;
    @FindBy(id = "s2id_ticket_id")
    WebElement addTask_TicketDropdown;
    @FindBy(id = "deadline")
    WebElement addTask_DeadlineInput;
    @FindBy(xpath = "//button[@type='submit' and text()=' Save']")
    WebElement addTask_SaveBtn;

    //add filter
    @FindBy(xpath = "//button[contains(@class,'save-filter-button')]")
    WebElement addFilterButton;
    @FindBy(xpath = "//input[@name='title']")
    WebElement addFilter_title;
    @FindBy(xpath = "//button[text()=' Save']")
    WebElement addFilter_save_button;

    @FindBy(xpath = "//button[contains(@class,'smart-filter-dropdown')]")
    WebElement manageFilterDropdown;
    @FindBy(xpath = "//a[contains(@class,'manage-filters-button')]")
    WebElement manageFilterButton;
    @FindBy(xpath = "//div[@id='filters-table_filter']//input")
    WebElement manageFilterTableSearch;
    @FindBy(xpath = "//table[@id='filters-table']//td[4]//a[@title='Delete']")
    WebElement filterItem_delete;
    @FindBy(xpath = "//table[@id='filters-table']//td[4]//a[@title='Edit']")
    WebElement filterItem_edit;

    public TaskPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // auth = quynh
    public void addTaskDataForRelatedToFilter(String RelatedTo) throws InterruptedException {
        addTaskBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Title']")));
        addTask_titleInput.sendKeys("addRelateToData");
        addTask_RelateToDropdown.click();
        addTask_SelectSearchInput.sendKeys(RelatedTo);
        addTask_SelectSearchInput.sendKeys(Keys.TAB);
        Thread.sleep(1000);

        switch (RelatedTo) {
            case "Client":
                addTask_ClientDropdown.click();
                addTask_SelectSearchInput.sendKeys("a");
                break;
            case "Contract":
                addTask_ContractDropdown.click();
                addTask_SelectSearchInput.sendKeys("a");
                break;
            case "Estimate":
                addTask_EstimateDropdown.click();
                addTask_SelectSearchInput.sendKeys("a");
                break;
            case "Expense":
                addTask_ExpenseDropdown.click();
                addTask_SelectSearchInput.sendKeys("a");
                break;
            case "Invoice":
                addTask_InvoiceDropdown.click();
                addTask_SelectSearchInput.sendKeys("inv");
                break;
            case "Lead":
                addTask_LeadDropdown.click();
                addTask_SelectSearchInput.sendKeys("a");
                break;
            case "Order":
                addTask_OrderDropdown.click();
                addTask_SelectSearchInput.sendKeys("order");
                break;
            case "Proposal":
                addTask_ProposalDropdown.click();
                addTask_SelectSearchInput.sendKeys("a");
                break;
            case "Subscription":
                addTask_SubscriptionDropdown.click();
                addTask_SelectSearchInput.sendKeys("a");
                break;
            case "Ticket":
                addTask_TicketDropdown.click();
                addTask_SelectSearchInput.sendKeys("a");
                break;
            default:
                addTask_ProjectDropdown.click();
                break;
        }

        addTask_SelectSearchInput.sendKeys(Keys.TAB);
        addTask_SaveBtn.click();
        waitTableLoadData();
    }

    private void waitTableLoadData() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("task-table")));
        Thread.sleep(1000);
    }

    public void filterByRelatedTo(String relatedTo) throws InterruptedException {
        // show filter list
        showFilterButton.click();

        // senKey Related to
        dropdownRelatedToFilter.click();
        inputSearchRelatedToFilter.sendKeys(relatedTo);
        inputSearchRelatedToFilter.sendKeys(Keys.TAB);
        waitTableLoadData();

        // set default value for TeamMember filter
        dropdownTeamMemberFilter.click();
        inputSearchTeamMemberFilter.sendKeys("Team member");
        inputSearchTeamMemberFilter.sendKeys(Keys.TAB);
        waitTableLoadData();
    }

    public void filterByProject(String projectName) throws InterruptedException {
        // show filter list
        showFilterButton.click();

        // senKey Related to
        dropdownProjectFilter.click();
        inputSearchProjectFilter.sendKeys(projectName);
        inputSearchProjectFilter.sendKeys(Keys.TAB);
        waitTableLoadData();

        // set default value for TeamMember filter
        dropdownTeamMemberFilter.click();
        inputSearchTeamMemberFilter.sendKeys("Team member");
        inputSearchTeamMemberFilter.sendKeys(Keys.TAB);
        waitTableLoadData();
    }

    public void filterByMilestone(String projectName, String milestone) throws InterruptedException {
        // show filter list
        showFilterButton.click();

        // senKey Related to
        dropdownProjectFilter.click();
        inputSearchProjectFilter.sendKeys(projectName);
        inputSearchProjectFilter.sendKeys(Keys.TAB);
        waitTableLoadData();
        Thread.sleep(1000);
        // senKey Milestone
        dropdownMilestoneFilter.click();
        if (milestone == "Release") {
            valueMilestoneFilter_release.click();
        } else {
            valueMilestoneFilter_beta_release.click();
        }
        waitTableLoadData();

        // set default value for TeamMember filter
        dropdownTeamMemberFilter.click();
        inputSearchTeamMemberFilter.sendKeys("Team member");
        inputSearchTeamMemberFilter.sendKeys(Keys.TAB);
        waitTableLoadData();
    }

    public void filterByTeamMember(String teamMember) throws InterruptedException {
        // show filter list
        showFilterButton.click();

        // set default value for TeamMember filter
        dropdownTeamMemberFilter.click();
        inputSearchTeamMemberFilter.sendKeys(teamMember);
        inputSearchTeamMemberFilter.sendKeys(Keys.TAB);
        waitTableLoadData();
    }

    public void filterByPriority(String priority) throws InterruptedException {
        // show filter list
        showFilterButton.click();

        // senKey Related to
        dropdownPriorityFilter.click();
        inputSearchPriorityFilter.sendKeys(priority);
        inputSearchPriorityFilter.sendKeys(Keys.TAB);
        waitTableLoadData();

        // set default value for TeamMember filter
        dropdownTeamMemberFilter.click();
        inputSearchTeamMemberFilter.sendKeys("Team member");
        inputSearchTeamMemberFilter.sendKeys(Keys.TAB);
        waitTableLoadData();
    }

    public void filterByLabel(String label) throws InterruptedException {
        // show filter list
        showFilterButton.click();

        // senKey Related to
        dropdownLabelFilter.click();
        inputSearchLabelFilter.sendKeys(label);
        inputSearchLabelFilter.sendKeys(Keys.TAB);
        waitTableLoadData();

        // set default value for TeamMember filter
        dropdownTeamMemberFilter.click();
        inputSearchTeamMemberFilter.sendKeys("Team member");
        inputSearchTeamMemberFilter.sendKeys(Keys.TAB);
        waitTableLoadData();
    }

    public void addTaskDataForDeadlineFilter(String date) throws InterruptedException {
        addTaskBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Title']")));
        addTask_titleInput.sendKeys("addRelateToData");
        addTask_RelateToDropdown.click();
        addTask_SelectSearchInput.sendKeys("Client");
        addTask_SelectSearchInput.sendKeys(Keys.TAB);
        Thread.sleep(1000);
        addTask_ClientDropdown.click();
        addTask_SelectSearchInput.sendKeys("a");
        addTask_SelectSearchInput.sendKeys(Keys.TAB);
        addTask_DeadlineInput.sendKeys(date);
        addTask_SaveBtn.click();
        waitTableLoadData();
    }

    public void clickDatePicker_Day(long day){
        WebElement dayElement = driver.findElement(By.xpath("//div[@class='datepicker-days']//td[(@class='day' or @class='today day') and text()='"+ day +"']"));
        dayElement.click();
    }

    public void clickDatePicker_Month(String monthText, long day){
        WebElement monthElement = driver.findElement(By.xpath("//div[@class='datepicker-months']//span[text()='"+ monthText + "']"));
        monthElement.click();
        this.clickDatePicker_Day(day);
    }

    public void clickDatePicker_Year(long year, String monthText, long day){
        WebElement yearElement = driver.findElement(By.xpath("//div[@class='datepicker-years']//span[text()='"+ year + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", yearElement);
        this.clickDatePicker_Month(monthText, day);
    }

    public void selectDate(Date date) throws InterruptedException {
        long day = Integer.parseInt(new SimpleDateFormat("dd").format(date));
        long month = Integer.parseInt(new SimpleDateFormat("MM").format(date));
        long currentMonth = Integer.parseInt(new SimpleDateFormat("MM").format(new Date()));

        if(currentMonth - month == 0 ){
            this.clickDatePicker_Day(day);
            return;
        }

        long year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
        long currentYear = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
        String monthText = new SimpleDateFormat("MMM", Locale.ENGLISH).format(date);
        if(currentYear - year == 0 ){
            WebElement daySwitch = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[contains(@class,'datepicker-switch')]"));
            daySwitch.click();
            this.clickDatePicker_Month(monthText, day);
            return;
        }
        if(Math.floor(currentYear/10) - Math.floor(year/10) == 0 ){
            WebElement daySwitch = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[contains(@class,'datepicker-switch')]"));
            daySwitch.click();
            WebElement monthSwitch = driver.findElement(By.xpath("//div[@class='datepicker-months']//th[contains(@class,'datepicker-switch')]"));
            monthSwitch.click();
            this.clickDatePicker_Year(year, monthText, day);
            return;
        }

        WebElement daySwitch = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[contains(@class,'datepicker-switch')]"));
        daySwitch.click();
        WebElement monthSwitch = driver.findElement(By.xpath("//div[@class='datepicker-months']//th[contains(@class,'datepicker-switch')]"));
        monthSwitch.click();
        WebElement yearSwitch = driver.findElement(By.xpath("//div[@class='datepicker-years']//th[contains(@class,'datepicker-switch')]"));
        yearSwitch.click();
        double yearDecades = Math.floor(year/10)*10;
        WebElement yearDecadesElement = driver.findElement(By.xpath("//div[@class='datepicker-decades']//span[text()='"+ yearDecades + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", yearDecadesElement);
        this.clickDatePicker_Year(year, monthText, day);
    }

    public String filterByDeadline(String deadlineType) throws InterruptedException {
        // show filter list
        showFilterButton.click();

        // senKey Related to
        dropdownDeadlineFilter.click();
        String xpath = "//div[contains(@class,'datepicker-custom-list')]/div[text()='" + deadlineType + "']";
        WebElement element = driver.findElement(By.xpath(xpath));
        String elementData = element.getAttribute("data-value");
        element.click();
        waitTableLoadData();

        // set default value for TeamMember filter
        dropdownTeamMemberFilter.click();
        inputSearchTeamMemberFilter.sendKeys("Team member");
        inputSearchTeamMemberFilter.sendKeys(Keys.TAB);
        waitTableLoadData();
        return elementData;
    }


    public void filterByDeadline(String deadlineType, Date deadline) throws InterruptedException {
        // show filter list
        showFilterButton.click();

        // senKey Related to
        dropdownDeadlineFilter.click();
        String xpath = "//div[contains(@class,'datepicker-custom-list')]/div[text()='" + deadlineType + "']";
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
        selectDate(deadline);
        waitTableLoadData();

        // set default value for TeamMember filter
        dropdownTeamMemberFilter.click();
        inputSearchTeamMemberFilter.sendKeys("Team member");
        inputSearchTeamMemberFilter.sendKeys(Keys.TAB);
        waitTableLoadData();
    }

    public void filterByStatus(String status) throws InterruptedException {
        // show filter list
        showFilterButton.click();

        // senKey Related to
        dropdownStatusFilter.click();
        String xpath = "//ul[@class='list-group']//li";
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        for(WebElement element:elements){
            if(element.getText().equals(status)){
                if(!element.getAttribute("class").contains("active")){
                    element.click();
                }
            }
            else if(element.getAttribute("class").contains("active")){
                element.click();
            }
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        waitTableLoadData();

        // set default value for TeamMember filter
        dropdownTeamMemberFilter.click();
        inputSearchTeamMemberFilter.sendKeys("Team member");
        inputSearchTeamMemberFilter.sendKeys(Keys.TAB);
        waitTableLoadData();
    }

    public void addNewFilter(String title) throws InterruptedException {
        // show filter list
        showFilterButton.click();
        // open add filter popup
        addFilterButton.click();
        Thread.sleep(1000);
        addFilter_title.sendKeys(title);
        addFilter_save_button.click();
    }

    public void editFilter(String title, String newTitle) throws InterruptedException {
        manageFilterDropdown.click();
        manageFilterButton.click();
        Thread.sleep(1000);
        manageFilterTableSearch.sendKeys(title);
        filterItem_edit.click();
        Thread.sleep(1000);
        addFilter_title.clear();
        addFilter_title.sendKeys(newTitle);
        addFilter_save_button.click();
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public int getTotalItemFilter() {
        String totalItemText = driver.findElement(CT_Common.MANAGE_FILTER_TABLE_TOTAL_ITEM).getText();
        int totalItem = 0;
        for(int i = totalItemText.length() -1; i>=0; i--){
            if(isInteger(String.valueOf(totalItemText.charAt(i)))){
                totalItem = Integer.parseInt(String.valueOf(totalItemText.charAt(i)));
                break;
            }
        }
        return totalItem;
    }

    public int deleteFilter(String title) throws InterruptedException {
        manageFilterDropdown.click();
        manageFilterButton.click();
        Thread.sleep(1000);
        manageFilterTableSearch.sendKeys(title);
        int totalItem =this.getTotalItemFilter();
        filterItem_delete.click();
        Thread.sleep(1000);
        return totalItem;
    }

    // auth = huy
    public void searchBy() {

    }


    // auth = chau
    public void addTask() {

    }
}
