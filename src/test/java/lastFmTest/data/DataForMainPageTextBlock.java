package lastFmTest.data;

import by.itAcademy.ui.pages.MainPage;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;


import java.util.Arrays;

import java.util.stream.Stream;

public class DataForMainPageTextBlock implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(MainPage.primaryNavigationMenuElement,
                        Arrays.asList("Live", "Music", "Charts", "Events", "Features"), "checkElementPrimaryNavigationMenu"),
                Arguments.of(MainPage.siteAuthItemMenuElement,
                        Arrays.asList("Log In", "SIGN UP"), "checkElementSiteAuthItemMenu"),
                Arguments.of(MainPage.companyMenuElement,
                        Arrays.asList("About Last.fm", "Contact Us", "Jobs"), "checkElementCompanyMenu"),
                  Arguments.of(MainPage.helpMenuElement,
                        Arrays.asList("Track My Music", "Community Support", "Community Guidelines", "Help"), "checkElementHelpMenu"),
                Arguments.of(MainPage.goodiesMenuElement,
                        Arrays.asList("Download Scrobbler", "Developer API", "Free Music Downloads", "Merchandise"), "checkElementGoodiesMenu"),
                Arguments.of(MainPage.accountMenuElement,
                        Arrays.asList("Sign Up", "Log In", "Subscribe"), "checkElementAccountMenu"),
                Arguments.of(MainPage.followUsMenuElement,
                        Arrays.asList("Facebook", "Twitter", "Instagram", "YouTube"), "checkElementFollowUsMenu"));

//    public static List<String> primaryNavigationMenu =
//            new ArrayList<>(Arrays.asList("Live", "Music", "Charts", "Events", "Features"));
//
//    public static List<String> followUsMenu =
//            new ArrayList<>(Arrays.asList("Facebook", "Twitter", "Instagram", "YouTube"));
    }

}
