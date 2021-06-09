package pom.github;

import controls.WebButton;
import core.AbstractPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class IssuesPage extends AbstractPOM {
    public IssuesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Created']")
    public WebButton createdSection;

    @FindBy(xpath = "//a[text()='Assigned']")
    public WebButton assignedSection;

    @FindBy(xpath = "//a[text()='Mentioned']")
    public WebButton mentionedSection;
}