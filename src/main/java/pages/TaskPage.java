package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    @FindBy(xpath = "//button[@name='deadline']")
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
    @FindBy(xpath = "//button[@type='submit' and text()=' Save']")
    WebElement addTask_SaveBtn;

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

        switch (RelatedTo){
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
        if(milestone == "Release"){
            valueMilestoneFilter_release.click();
        }
        else {
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

    public String filterByDeadline(String deadline) throws InterruptedException {
        // show filter list
        showFilterButton.click();

        // senKey Related to
        dropdownDeadlineFilter.click();
        String xpath = "//div[contains(@class,'datepicker-custom-list')]/div[text()='"+ deadline + "']";
        WebElement element = driver.findElement(By.xpath(xpath));
        String elementData = "";
        if(deadline == "Custom"){
            element.click();
        }
        else {
            elementData = element.getAttribute("data-value");
            element.click();
        }
        waitTableLoadData();

        // set default value for TeamMember filter
        dropdownTeamMemberFilter.click();
        inputSearchTeamMemberFilter.sendKeys("Team member");
        inputSearchTeamMemberFilter.sendKeys(Keys.TAB);
        waitTableLoadData();
        return elementData;
    }

    public void filterByStatus(){

    }

    public void addNewFilter(){

    }

    public void editFilter(){

    }

    public void deleteFilter(){

    }

    // auth = huy
    public void searchBy(){

    }


    // auth = chau
    public void addTask(){

    }
}
