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

    @FindBy(id = "")
    WebElement dropdownProjectFilter;
    @FindBy(id = "")
    WebElement dropdownMilestoneFilter;
    @FindBy(id = "s2id_autogen11")
    WebElement dropdownTeamMemberFilter;
    @FindBy(id = "s2id_autogen12_search")
    WebElement inputSearchTeamMemberFilter;
    @FindBy(id = "")
    WebElement dropdownPriorityFilter;
    @FindBy(id = "")
    WebElement dropdownLabelFilter;
    @FindBy(id = "")
    WebElement dropdownDeadlineFilter;
    @FindBy(id = "")
    WebElement dropdownStatusFilter;


    public TaskPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // auth = quynh
    private void waitTableLoadData(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("task-table")));
    }

    public void filterByRelatedTo(String relatedTo){
        // show filter list
        showFilterButton.click();

        // senKey Related to
        dropdownRelatedToFilter.click();
        inputSearchRelatedToFilter.sendKeys(relatedTo);
        inputSearchRelatedToFilter.sendKeys(Keys.TAB);
        waitTableLoadData();

        // set default value for TeamMember filter
        dropdownTeamMemberFilter.click();
        inputSearchTeamMemberFilter.sendKeys(Keys.TAB);
        waitTableLoadData();
    }

    public void filterByProject(){

    }

    public void filterByMilestone(){

    }

    public void filterByTeamMember(){

    }

    public void filterByPriority(){

    }

    public void filterByLabel(){

    }

    public void filterByDeadline(){

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
