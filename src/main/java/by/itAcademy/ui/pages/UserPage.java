package by.itAcademy.ui.pages;

import by.itAcademy.utils.Waiter;
import by.itAcademy.utils.chromeDriver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserPage extends BaseMethodPages {

    private WebDriver driver = Driver.getChromeDriver();

    Waiter waiter = new Waiter();

    private final By userNameFromPage = By.cssSelector("h1[class=\"header-title\"]");
    private final By headerAvatar = By.cssSelector("div[class=\"header-avatar\"]");
    private final By playListButton =
            By.cssSelector("ul[class=\"navlist-items js-navlist-items\"] a[href=\"/user/IliaTokmurzin/playlists\"]");
    private final By newPlayListButton =
            By.cssSelector("a[href=\"/user/IliaTokmurzin/playlists/create\"]");
    private final By addTrackButtonInNewPlayList
            = By.xpath("//button[@class=\"btn-primary buffer-4\"][contains( text(), \"Add Track\")]");
    private final By addTrackButton
            = By.xpath("//button[@class=\"btn-primary btn-add-tracks\"][contains( text(), \"Add Track\")]");
    private final By startFromScratchButton =
            By.xpath("//button[text()=\"Start from scratch\"]");
    private final By similarTracksTemplate =
            By.cssSelector("a[href=\"/user/IliaTokmurzin/playlists/create/from-track\"]");
    private final By searchTrackField =
            By.cssSelector("input[id=\"track-search\"]");
    private final By firstResultSearch =
            By.xpath("//tr[1]//button[@class=\"chartlist-action-button\"]");
    private final By songsFromPlayList =
            By.cssSelector("td[tabindex=\"0\"]");
    private final By moreButtonFromFirstPlayList =
            By.xpath("//div[@class=\"buffer-4\"]//li[1]//button[@data-disclose-select]");
    private final By playLists =
            By.cssSelector("div[class=\"buffer-4\"]>ol>li");
    private final By deleteFirstPlayList =
            By.xpath("//div[@class=\"buffer-4\"]//li[1]//button[@data-analytics-action=\"delete\"]");
    private final By moreButtonFromThisPlayListPage =
            By.xpath("//button[text()=\"More actions\"]");
    private final By deleteButtonFromThisPlayListPage =
            By.xpath("//button[text()=\"Delete\"]");
    private final By deleteButtonFromDataModalAction =
            By.xpath("//button[@data-modal-action=\"ok\"]");


    public By getPlayListButton() {return playListButton;}
    public By getNewPlayListButton() {return newPlayListButton;}
    public By getStartFromScratchButton() {return startFromScratchButton;}
    public By getAddTrackButtonInNewPlayList() {return addTrackButtonInNewPlayList;}
    public By getAddTrackButton() {return addTrackButton;}
    public By getSimilarTracksTemplate() {return similarTracksTemplate;}
    public By getSearchTrackField() {return searchTrackField;}
    public By getFirstResultSearch() {return firstResultSearch;}
    public By getUserNameFromPage() {return userNameFromPage;}
    public By getSongsFromPlayList() {return songsFromPlayList;}
    public By getMoreButtonFromFirstPlayList() {return moreButtonFromFirstPlayList;}
    public By getPlayLists() {return playLists;}
    public By getDeleteFirstPlayList() {return deleteFirstPlayList;}
    public By getMoreButtonFromThisPlayListPage() {return moreButtonFromThisPlayListPage;}

    @Step("Get user name from user page")
    public String getUserName(){
        return driver.findElement(userNameFromPage)
                .getText();
    }

    @Step("Add track in new play list from scratch")
    public void addTrackInNewPlayList(List<String> expectedList) throws InterruptedException {

        for (String s : expectedList) {
            if (!driver.findElement(addTrackButtonInNewPlayList).isDisplayed()) {
                click(addTrackButton);
                sendKey(getSearchTrackField(), s);
                sendKey(getSearchTrackField(), Keys.ENTER);
                click(getFirstResultSearch());
                Thread.sleep(2000);
            } else {
                click(addTrackButtonInNewPlayList);
                sendKey(getSearchTrackField(), s);
                sendKey(getSearchTrackField(), Keys.ENTER);
                click(getFirstResultSearch());
            }
        }
    }

    @Step("Delete playlist by name")
    public void deletePlayListByName(String name){
        WebElement playList = driver.findElement(By.cssSelector("a[title=\"" + name + "\"]"));
        waiter.waitUntilElementToBeClickable((
                playList)).click();

        waiter.waitUntilElementToBeClickable(
                driver.findElement((moreButtonFromThisPlayListPage))).click();

        waiter.waitUntilElementToBeClickable(
                driver.findElement((deleteButtonFromThisPlayListPage))).click();

        waiter.waitUntilElementToBeClickable(driver.findElement((deleteButtonFromDataModalAction))).click();



    }
}
