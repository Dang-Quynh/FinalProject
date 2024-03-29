package testsuite;

import common.CommonBase;
import constant.CT_Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.TaskPage;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FilterTaskTest extends CommonBase {
    @BeforeMethod
    @Parameters("browser")
    public void openDriver(@Optional("chrome") String browserName) throws InterruptedException {
        driver = setupDriver(browserName);
        driver.get(CT_Common.URL_rise_signin);
        this.navigateTaskScreen();
    }

    private void navigateTaskScreen(){
        // login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFunction("admin@demo.com","riseDemo");
        // navigate task screen
        clickElement(CT_Common.TASK_MENU);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("task-table")));
    }

    private boolean checkListTaskFilterByRelatedTo(String relatedTo){
        List<WebElement> elements = getElements(CT_Common.RELATED_TO_VALUE_COLUMNS);
        if(elements.size() > 0){
            for(WebElement element:elements){
                if(!element.getAttribute("href").contains("/"+relatedTo.toLowerCase())){
                    return false;
                }
            }

        }
        return true;
    }

    @Test
    public void filterByRelatedTo_Project() throws InterruptedException {
        String relatedTo = "Project";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByRelatedTo(relatedTo);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

    @Test
    public void filterByRelatedTo_Client() throws InterruptedException {
        String relatedTo = "Client";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.addTaskDataForRelatedToFilter(relatedTo);
        Thread.sleep(1000);
        taskPage.filterByRelatedTo(relatedTo);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

    @Test
    public void filterByRelatedTo_Contract() throws InterruptedException {
        String relatedTo = "Contract";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.addTaskDataForRelatedToFilter(relatedTo);
        Thread.sleep(1000);
        taskPage.filterByRelatedTo(relatedTo);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

    @Test
    public void filterByRelatedTo_Estimate() throws InterruptedException {
        String relatedTo = "Estimate";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.addTaskDataForRelatedToFilter(relatedTo);
        Thread.sleep(1000);
        taskPage.filterByRelatedTo(relatedTo);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

    @Test
    public void filterByRelatedTo_Expense() throws InterruptedException {
        String relatedTo = "Expense";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.addTaskDataForRelatedToFilter(relatedTo);
        Thread.sleep(1000);
        taskPage.filterByRelatedTo(relatedTo);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

    @Test
    public void filterByRelatedTo_Invoice() throws InterruptedException {
        String relatedTo = "Invoice";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.addTaskDataForRelatedToFilter(relatedTo);
        Thread.sleep(1000);
        taskPage.filterByRelatedTo(relatedTo);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

    @Test
    public void filterByRelatedTo_Lead() throws InterruptedException {
        String relatedTo = "Lead";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.addTaskDataForRelatedToFilter(relatedTo);
        Thread.sleep(1000);
        taskPage.filterByRelatedTo(relatedTo);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

    @Test
    public void filterByRelatedTo_Order() throws InterruptedException {
        String relatedTo = "Order";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.addTaskDataForRelatedToFilter(relatedTo);
        Thread.sleep(1000);
        taskPage.filterByRelatedTo(relatedTo);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

    @Test
    public void filterByRelatedTo_Proposal() throws InterruptedException {
        String relatedTo = "Proposal";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.addTaskDataForRelatedToFilter(relatedTo);
        Thread.sleep(1000);
        taskPage.filterByRelatedTo(relatedTo);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

    @Test
    public void filterByRelatedTo_Subscription() throws InterruptedException {
        String relatedTo = "Subscription";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.addTaskDataForRelatedToFilter(relatedTo);
        Thread.sleep(1000);
        taskPage.filterByRelatedTo(relatedTo);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

    @Test
    public void filterByRelatedTo_Ticket() throws InterruptedException {
        String relatedTo = "Ticket";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.addTaskDataForRelatedToFilter(relatedTo);
        Thread.sleep(1000);
        taskPage.filterByRelatedTo(relatedTo);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

    private boolean checkListTaskFilterByProjectName(String text){
        List<WebElement> elements = getElements(CT_Common.RELATED_TO_VALUE_COLUMNS);
        if(elements.size() > 0){
            for(WebElement element:elements){
                if(!element.getText().equals(text)){
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void filterByProject() throws InterruptedException {
        String projectName = "Mobile App Development";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByProject(projectName);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByProjectName(projectName));
    }

    private boolean checkListTaskFilterByMilestone(String text){
        List<WebElement> elements = getElements(CT_Common.MILESTONE_VALUE_COLUMNS);
        if(elements.size() > 0){
            for(WebElement element:elements){
                if(!element.getText().equals(text)){
                    return false;
                }
            }

        }
        return true;
    }

    @Test
    public void filterByMilestone_Release() throws InterruptedException {
        String milestone = "Release";
        String projectName = "Mobile App Development";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByMilestone(projectName, milestone);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByMilestone(milestone));
    }

    @Test
    public void filterByMilestone_BetaRelease() throws InterruptedException {
        String milestone = "Beta Release";
        String projectName = "Mobile App Development";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByMilestone(projectName, milestone);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByMilestone(milestone));
    }

    private boolean checkListTaskFilterByTeamMember(String text){
        List<WebElement> elements = getElements(CT_Common.ASSIGNED_TO_VALUE_COLUMNS);
        if(elements.size() > 0){
            for(WebElement element:elements){
                if(!element.getText().trim().equals(text)){
                    return false;
                }
            }

        }
        return true;
    }

    @Test
    public void filterByTeamMember() throws InterruptedException {
        String name = "Sara Ann";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByTeamMember(name);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByTeamMember(name));
    }

    private boolean checkListTaskFilterByPriority(String text){
        List<WebElement> elements = getElements(CT_Common.PRIORITY_VALUE_COLUMNS);
        if(elements.size() > 0){
            for(WebElement element:elements){
                if(!element.getAttribute("title").trim().contains(text)){
                    return false;
                }
            }

        }
        return true;
    }

    @Test
    public void filterByPriority_Minor() throws InterruptedException {
        String priority = "Minor";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByPriority(priority);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByPriority(priority));
    }

    @Test
    public void filterByPriority_Major() throws InterruptedException {
        String priority = "Major";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByPriority(priority);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByPriority(priority));
    }

    @Test
    public void filterByPriority_Critical() throws InterruptedException {
        String priority = "Critical";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByPriority(priority);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByPriority(priority));
    }

    @Test
    public void filterByPriority_Blocker() throws InterruptedException {
        String priority = "Blocker";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByPriority(priority);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByPriority(priority));
    }

    private boolean checkListTaskFilterByLabel(String text){
        List<WebElement> elements = getElements(CT_Common.LABEL_VALUE_COLUMNS);
        if(elements.size() > 0){
            for(WebElement element:elements){
                if(!element.getText().trim().equals(text)){
                    return false;
                }
            }

        }
        return true;
    }

    @Test
    public void filterByLabel() throws InterruptedException {
        String label = "Bug";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByLabel(label);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByLabel(label));
    }

    private Date transformDeadlineValue(String value){
        String times[] =  value.split("-");
        if(times.length > 2){
            int year = Integer.valueOf(times[2]);
            int month = Integer.valueOf(times[1]) - 1;
            int day = Integer.valueOf(times[0]);
            return new Date(year, month, day);
        }
        else {
            return new Date();
        }
    }

    private boolean checkListTaskFilterByDeadline(String text, String deadlineValue){
        System.out.println();
        List<WebElement> elements = getElements(CT_Common.DEADLINE_VALUE_COLUMNS);
        if(elements.size() > 0){
            for(WebElement element:elements){

                long elementDeadlineTime = transformDeadlineValue(element.getText()).getTime();
                long deadlineTime = transformDeadlineValue(deadlineValue).getTime();
                long currentTime = new Date().getTime();

                if(text == "Custom"){
                    if(!element.getText().trim().equals(text)){
                        return false;
                    }
                }
                else if(text == "Today"){
                    if(elementDeadlineTime == deadlineTime){
                        return false;
                    }
                }
                else if(text == "Expired"){
                    if(elementDeadlineTime >= currentTime){
                        return false;
                    }
                }
                else {
                    if( elementDeadlineTime > deadlineTime || elementDeadlineTime < deadlineTime){
                        return false;
                    }
                }
            }

        }
        return true;
    }

    @Test
    public void filterByDeadline_Expired() throws InterruptedException {
        String deadline = "Expired";
        TaskPage taskPage = new TaskPage(driver);
        String expiredDate = "";
        taskPage.filterByDeadline(deadline);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByDeadline(deadline, expiredDate));
    }

    @Test
    public void filterByDeadline_Today() throws InterruptedException {
        String deadline = "Today";
        TaskPage taskPage = new TaskPage(driver);
        String deadlineData = taskPage.filterByDeadline(deadline);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByDeadline(deadline, deadlineData));
    }

    @Test
    public void filterByDeadline_Tomorrow() throws InterruptedException {
        String deadline = "Tomorrow";
        TaskPage taskPage = new TaskPage(driver);
        String deadlineData = taskPage.filterByDeadline(deadline);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByDeadline(deadline, deadlineData));
    }

    @Test
    public void filterByDeadline_In7Days() throws InterruptedException {
        String deadline = "In 7 days";
        TaskPage taskPage = new TaskPage(driver);
        String deadlineData = taskPage.filterByDeadline(deadline);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByDeadline(deadline, deadlineData));
    }

    @Test
    public void filterByDeadline_In15Days() throws InterruptedException {
        String deadline = "In 15 days";
        TaskPage taskPage = new TaskPage(driver);
        String deadlineData = taskPage.filterByDeadline(deadline);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByDeadline(deadline, deadlineData));
    }

    @Test
    public void filterByDeadline_Custom() throws InterruptedException {
        String deadline = "Custom";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByDeadline(deadline);
        scrollToElement(CT_Common.PAGINATION);
        Assert.assertTrue(checkListTaskFilterByLabel(deadline));
    }

    @AfterMethod
    private void closeDriver(){
        quitDriver(driver);
    }
}
