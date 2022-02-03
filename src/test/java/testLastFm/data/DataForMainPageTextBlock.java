package testLastFm.data;

import by.itAcademy.ui.blocks.FooterBlock;
import by.itAcademy.ui.blocks.HeaderBlock;
import by.itAcademy.ui.pages.MainPage;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;


import java.util.Arrays;

import java.util.stream.Stream;

public class DataForMainPageTextBlock implements ArgumentsProvider {

    private HeaderBlock headerBlock = new HeaderBlock();
    private FooterBlock footerBlock = new FooterBlock();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(headerBlock.getPrimaryNavigationMenuElement(),
                        Arrays.asList("Live", "Music", "Charts", "Events", "Features"), "checkElementPrimaryNavigationMenu"),
                Arguments.of(headerBlock.getSiteAuthItemMenuElement(),
                        Arrays.asList("Log In", "SIGN UP"), "checkElementSiteAuthItemMenu"),
                Arguments.of(footerBlock.getCompanyMenuElement(),
                        Arrays.asList("About Last.fm", "Contact Us", "Jobs"), "checkElementCompanyMenu"),
                  Arguments.of(footerBlock.getHelpMenuElement(),
                        Arrays.asList("Track My Music", "Community Support", "Community Guidelines", "Help"), "checkElementHelpMenu"),
                Arguments.of(footerBlock.getGoodiesMenuElement(),
                        Arrays.asList("Download Scrobbler", "Developer API", "Free Music Downloads", "Merchandise"), "checkElementGoodiesMenu"),
                Arguments.of(footerBlock.getAccountMenuElement(),
                        Arrays.asList("Sign Up", "Log In", "Subscribe"), "checkElementAccountMenu"),
                Arguments.of(footerBlock.getFollowUsMenuElement(),
                        Arrays.asList("Facebook", "Twitter", "Instagram", "YouTube"), "checkElementFollowUsMenu"));

//    public static List<String> primaryNavigationMenu =
//            new ArrayList<>(Arrays.asList("Live", "Music", "Charts", "Events", "Features"));
//
//    public static List<String> followUsMenu =
//            new ArrayList<>(Arrays.asList("Facebook", "Twitter", "Instagram", "YouTube"));
    }

}
