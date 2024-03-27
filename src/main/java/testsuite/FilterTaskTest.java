package testsuite;

import common.CommonBase;
import constant.CT_Common;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TaskPage;

import java.util.List;

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
    public void filterByRelatedTo_Project() {
        String relatedTo = "Project";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByRelatedTo(relatedTo);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

    @Test
    public void filterByRelatedTo_Client() {
        String relatedTo = "Client";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByRelatedTo(relatedTo);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

    @Test
    public void filterByRelatedTo_Contract() {
        String relatedTo = "Contract";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByRelatedTo(relatedTo);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

    @Test
    public void filterByRelatedTo_Estimate() {
        String relatedTo = "Estimate";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByRelatedTo(relatedTo);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

    @Test
    public void filterByRelatedTo_Expense() {
        String relatedTo = "Expense";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByRelatedTo(relatedTo);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

    @Test
    public void filterByRelatedTo_Invoice() {
        String relatedTo = "Invoice";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByRelatedTo(relatedTo);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

    @Test
    public void filterByRelatedTo_Lead() {
        String relatedTo = "Lead";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByRelatedTo(relatedTo);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

    @Test
    public void filterByRelatedTo_Order() {
        String relatedTo = "Order";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByRelatedTo(relatedTo);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

    @Test
    public void filterByRelatedTo_Proposal() {
        String relatedTo = "Proposal";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByRelatedTo(relatedTo);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

    @Test
    public void filterByRelatedTo_Subscription() {
        String relatedTo = "Subscription";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByRelatedTo(relatedTo);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

    @Test
    public void filterByRelatedTo_Ticket() {
        String relatedTo = "Ticket";
        TaskPage taskPage = new TaskPage(driver);
        taskPage.filterByRelatedTo(relatedTo);
        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
    }

//    @Test
//    public void filterByProject() {
//        String relatedTo = "Subscription";
//        TaskPage taskPage = new TaskPage(driver);
//        taskPage.filterByRelatedTo(relatedTo);
//        Assert.assertTrue(checkListTaskFilterByRelatedTo(relatedTo));
//    }
}
