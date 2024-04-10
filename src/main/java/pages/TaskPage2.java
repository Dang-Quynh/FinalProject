package pages;

import common.CommonBase;
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

public class TaskPage2 {
    private WebDriver driver;
    private int initWaitTime = 20;
    private CommonBase common = new CommonBase();

    //    Filter
    By showFilterButton = By.xpath("//div[@id='task-table_wrapper']//button[contains(@class,'show-filter-form-button')]");
    By dropdownRelatedToFilter = By.id("s2id_autogen5");
    By inputSearchRelatedToFilter = By.id("s2id_autogen6_search");
    By dropdownProjectFilter = By.id("s2id_autogen7");
    By inputSearchProjectFilter= By.id("s2id_autogen8_search");
    By dropdownMilestoneFilter= By.id("s2id_autogen9");
    By valueMilestoneFilter_release= By.xpath("//ul[@id='select2-results-10']//li[3]");
    By valueMilestoneFilter_beta_release= By.xpath("//ul[@id='select2-results-10']//li[2]");
    By dropdownTeamMemberFilter= By.id("s2id_autogen11");
    By inputSearchTeamMemberFilter= By.id("s2id_autogen12_search");
    By dropdownPriorityFilter= By.id("s2id_autogen13");
    By inputSearchPriorityFilter= By.id("s2id_autogen14_search");
    By dropdownLabelFilter= By.id("s2id_autogen15");
    By inputSearchLabelFilter= By.id("s2id_autogen16_search");
    By dropdownDeadlineFilter= By.xpath("//button[@name='deadline']");
    By dropdownStatusFilter= By.xpath("//span[contains(@class,'filter-multi-select')]//button");
    By addTaskBtn= By.xpath("//a[text()=' Add task']");
    By addTask_titleInput= By.xpath("//input[@placeholder='Title']");
    By addTask_RelateToDropdown= By.id("s2id_task-context");
    By addTask_SelectSearchInput = By.xpath("//div[@id='select2-drop']//input");
    By addTask_ProjectDropdown= By.id("s2id_project_id");
    By addTask_ClientDropdown= By.id("s2id_client_id");
    By addTask_ContractDropdown= By.id("s2id_contract_id");
    By addTask_EstimateDropdown= By.id("s2id_estimate_id");
    By addTask_ExpenseDropdown= By.xpath("s2id_expense_id");
    By addTask_InvoiceDropdown= By.id("s2id_invoice_id");
    By addTask_LeadDropdown= By.id("s2id_lead_id");
    By addTask_OrderDropdown= By.id("s2id_order_id");
    By addTask_ProposalDropdown= By.id("s2id_proposal_id");
    By addTask_SubscriptionDropdown= By.id("s2id_subscription_id");
    By addTask_TicketDropdown= By.id("s2id_ticket_id");
    By addTask_DeadlineInput= By.id("deadline");
    By addTask_SaveBtn = By.xpath("//button[@type='submit' and text()=' Save']");

    //add filter
    By addFilterButton= By.xpath("//button[contains(@class,'save-filter-button')]");
    By addFilter_title= By.xpath("//input[@name='title']");
    By addFilter_save_button= By.xpath("//button[text()=' Save']");
    By manageFilterDropdown= By.xpath("//button[contains(@class,'smart-filter-dropdown')]");
    By manageFilterButton= By.xpath("//a[contains(@class,'manage-filters-button')]");
    By manageFilterTableSearch= By.xpath("//div[@id='filters-table_filter']//input");
    By filterItem_delete= By.xpath("//table[@id='filters-table']//td[4]//a[@title='Delete']");
    By filterItem_edit= By.xpath("//table[@id='filters-table']//td[4]//a[@title='Edit']");

    public TaskPage2(WebDriver driver) {
        this.driver = driver;
        common.driver = driver;
        common.wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
    }

    private void clickElement(By locator){
        common.clickElement(locator);
    }

    private void sendKeysElement(By locator, String value){
        common.sendKeysElement(locator, value);
    }
    private void sendKeysElement(By locator, Keys value){
        common.sendKeysElement(locator, value);
    }

    // auth = quynh
    public void addTaskDataForRelatedToFilter(String RelatedTo) throws InterruptedException {
        clickElement(addTaskBtn);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Title']")));
        sendKeysElement(addTask_titleInput, "addRelateToData");
        clickElement(addTask_RelateToDropdown);
        sendKeysElement(addTask_SelectSearchInput,RelatedTo);
        sendKeysElement(addTask_SelectSearchInput, Keys.TAB);
        Thread.sleep(1000);

        switch (RelatedTo) {
            case "Client":
                clickElement(addTask_ClientDropdown);
                sendKeysElement(addTask_SelectSearchInput, "a");
                break;
            case "Contract":
                clickElement(addTask_ContractDropdown);
                sendKeysElement(addTask_SelectSearchInput, "a");
                break;
            case "Estimate":
                clickElement(addTask_EstimateDropdown);
                sendKeysElement(addTask_SelectSearchInput,"a");
                break;
            case "Expense":
                clickElement(addTask_ExpenseDropdown);
                sendKeysElement(addTask_SelectSearchInput, "a");
                break;
            case "Invoice":
                clickElement(addTask_InvoiceDropdown);
                sendKeysElement(addTask_SelectSearchInput, "inv");
                break;
            case "Lead":
                clickElement(addTask_LeadDropdown);
                sendKeysElement(addTask_SelectSearchInput, "a");
                break;
            case "Order":
                clickElement(addTask_OrderDropdown);
                sendKeysElement(addTask_SelectSearchInput, "order");
                break;
            case "Proposal":
                clickElement(addTask_ProposalDropdown);
                sendKeysElement(addTask_SelectSearchInput, "a");
                break;
            case "Subscription":
                clickElement(addTask_SubscriptionDropdown);
                sendKeysElement(addTask_SelectSearchInput, "a");
                break;
            case "Ticket":
                clickElement(addTask_TicketDropdown);
                sendKeysElement(addTask_SelectSearchInput, "a");
                break;
            default:
                clickElement(addTask_ProjectDropdown);
                sendKeysElement(addTask_SelectSearchInput, "a");
                break;
        }
        sendKeysElement(addTask_SelectSearchInput, Keys.TAB);
        clickElement(addTask_SaveBtn);
        waitTableLoadData();
    }

    private void waitTableLoadData() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("task-table")));
        Thread.sleep(1000);
    }

    public void filterByRelatedTo(String relatedTo) throws InterruptedException {
        // show filter list
        clickElement(showFilterButton);

        // senKey Related to
        clickElement(dropdownRelatedToFilter);
        sendKeysElement(inputSearchRelatedToFilter,relatedTo);
        sendKeysElement(inputSearchRelatedToFilter,Keys.TAB);
        waitTableLoadData();

        // set default value for TeamMember filter
        clickElement(dropdownTeamMemberFilter);
        sendKeysElement(inputSearchTeamMemberFilter,"Team member");
        sendKeysElement(inputSearchTeamMemberFilter,Keys.TAB);
        waitTableLoadData();
    }

    public void filterByProject(String projectName) throws InterruptedException {
        // show filter list
        clickElement(showFilterButton);

        // senKey Related to
        clickElement(dropdownProjectFilter);
        sendKeysElement(inputSearchProjectFilter,projectName);
        sendKeysElement(inputSearchProjectFilter,Keys.TAB);
        waitTableLoadData();

        // set default value for TeamMember filter
        clickElement(dropdownTeamMemberFilter);
        sendKeysElement(inputSearchTeamMemberFilter,"Team member");
        sendKeysElement(inputSearchTeamMemberFilter,Keys.TAB);
        waitTableLoadData();
    }

    public void filterByMilestone(String projectName, String milestone) throws InterruptedException {
        // show filter list
        clickElement(showFilterButton);

        // senKey Related to
        clickElement(dropdownProjectFilter);
        sendKeysElement(inputSearchTeamMemberFilter,projectName);
        sendKeysElement(inputSearchTeamMemberFilter,Keys.TAB);
        waitTableLoadData();
        Thread.sleep(1000);
        // senKey Milestone
        clickElement(dropdownMilestoneFilter);
        if (milestone == "Release") {
            clickElement(valueMilestoneFilter_release);
        } else {
            clickElement(valueMilestoneFilter_beta_release);
        }
        waitTableLoadData();

        // set default value for TeamMember filter
        clickElement(dropdownTeamMemberFilter);
        sendKeysElement(inputSearchTeamMemberFilter,"Team member");
        sendKeysElement(inputSearchTeamMemberFilter,Keys.TAB);
        waitTableLoadData();
    }

    public void filterByTeamMember(String teamMember) throws InterruptedException {
        // show filter list
        clickElement(showFilterButton);

        // set default value for TeamMember filter
        clickElement(dropdownTeamMemberFilter);
        sendKeysElement(inputSearchTeamMemberFilter,teamMember);
        sendKeysElement(inputSearchTeamMemberFilter,Keys.TAB);
        waitTableLoadData();
    }

    public void filterByPriority(String priority) throws InterruptedException {
        // show filter list
        clickElement(showFilterButton);

        // senKey Related to
        clickElement(dropdownPriorityFilter);
        sendKeysElement(inputSearchPriorityFilter,priority);
        sendKeysElement(inputSearchPriorityFilter,Keys.TAB);
        waitTableLoadData();

        // set default value for TeamMember filter
        clickElement(dropdownTeamMemberFilter);
        sendKeysElement(inputSearchTeamMemberFilter,"Team member");
        sendKeysElement(inputSearchTeamMemberFilter,Keys.TAB);
        waitTableLoadData();
    }

    public void filterByLabel(String label) throws InterruptedException {
        // show filter list
        clickElement(showFilterButton);

        // senKey Related to
        clickElement(dropdownLabelFilter);
        sendKeysElement(inputSearchLabelFilter,label);
        sendKeysElement(inputSearchLabelFilter,Keys.TAB);
        waitTableLoadData();

        // set default value for TeamMember filter
        clickElement(dropdownTeamMemberFilter);
        sendKeysElement(inputSearchTeamMemberFilter,"Team member");
        sendKeysElement(inputSearchTeamMemberFilter,Keys.TAB);
        waitTableLoadData();
    }

    public void addTaskDataForDeadlineFilter(String date) throws InterruptedException {
        clickElement(addTaskBtn);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Title']")));
        sendKeysElement(addTask_titleInput,"addRelateToData");
        clickElement(addTask_RelateToDropdown);
        sendKeysElement(addTask_SelectSearchInput, "Client");
        sendKeysElement(addTask_SelectSearchInput,Keys.TAB);

        Thread.sleep(1000);
        clickElement(addTask_ClientDropdown);
        sendKeysElement(addTask_SelectSearchInput, "a");
        sendKeysElement(addTask_SelectSearchInput,Keys.TAB);
        sendKeysElement(addTask_DeadlineInput, date);
        clickElement(addTask_SaveBtn);
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
        clickElement(showFilterButton);

        // senKey Related to
        clickElement(dropdownDeadlineFilter);
        String xpath = "//div[contains(@class,'datepicker-custom-list')]/div[text()='" + deadlineType + "']";
        WebElement element = driver.findElement(By.xpath(xpath));
        String elementData = element.getAttribute("data-value");
        element.click();
        waitTableLoadData();

        // set default value for TeamMember filter
        clickElement(dropdownTeamMemberFilter);
        sendKeysElement(inputSearchTeamMemberFilter,"Team member");
        sendKeysElement(inputSearchTeamMemberFilter,Keys.TAB);
        waitTableLoadData();
        return elementData;
    }


    public void filterByDeadline(String deadlineType, Date deadline) throws InterruptedException {
        // show filter list
        clickElement(showFilterButton);

        // senKey Related to
        clickElement(dropdownDeadlineFilter);
        String xpath = "//div[contains(@class,'datepicker-custom-list')]/div[text()='" + deadlineType + "']";
        WebElement element = common.getElement(By.xpath(xpath));
        element.click();
        selectDate(deadline);
        waitTableLoadData();

        // set default value for TeamMember filter
        clickElement(dropdownTeamMemberFilter);
        sendKeysElement(inputSearchTeamMemberFilter,"Team member");
        sendKeysElement(inputSearchTeamMemberFilter,Keys.TAB);
        waitTableLoadData();
    }

    public void filterByStatus(String status) throws InterruptedException {
        // show filter list
        clickElement(showFilterButton);

        // senKey Related to
        clickElement(dropdownStatusFilter);
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
        clickElement(dropdownTeamMemberFilter);
        sendKeysElement(inputSearchTeamMemberFilter,"Team member");
        sendKeysElement(inputSearchTeamMemberFilter,Keys.TAB);
        waitTableLoadData();
    }

    public void addNewFilter(String title) throws InterruptedException {
        // show filter list
        clickElement(showFilterButton);
        // open add filter popup
        clickElement(addFilterButton);
        Thread.sleep(1000);
        sendKeysElement(addFilter_title,title);
        clickElement(addFilter_save_button);
    }

    public void editFilter(String title, String newTitle) throws InterruptedException {
        clickElement(manageFilterDropdown);
        clickElement(manageFilterButton);
        Thread.sleep(1000);
        sendKeysElement(manageFilterTableSearch,title);
        clickElement(filterItem_edit);
        Thread.sleep(1000);
        common.getElement(addFilter_title).clear();
        sendKeysElement(addFilter_title, newTitle);
        clickElement(addFilter_save_button);
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
        clickElement(manageFilterDropdown);
        clickElement(manageFilterButton);
        Thread.sleep(1000);
        sendKeysElement(manageFilterTableSearch,title);
        int totalItem =this.getTotalItemFilter();
        clickElement(filterItem_delete);
        Thread.sleep(1000);
        return totalItem;
    }
}
