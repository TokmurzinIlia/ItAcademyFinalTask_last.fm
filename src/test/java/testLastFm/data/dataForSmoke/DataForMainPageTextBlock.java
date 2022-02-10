package testLastFm.data.dataForSmoke;

import by.itAcademy.ui.blocks.FooterBlock;
import by.itAcademy.ui.blocks.HeaderBlock;
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
                        Arrays.asList("Live", "Music", "Charts", "Events", "Features"), "Test that checks the main navigation menu items"),
                Arguments.of(headerBlock.getSiteAuthItemMenuElement(),
                        Arrays.asList("Log In", "SIGN UP"), "Test that tests the site auth-item menu items."),
                Arguments.of(footerBlock.getCompanyMenuElement(),
                        Arrays.asList("About Last.fm", "Contact Us", "Jobs"), "Test that tests the company menu items"),
                  Arguments.of(footerBlock.getHelpMenuElement(),
                        Arrays.asList("Track My Music", "Community Support", "Community Guidelines", "Help"), "Test that tests the help menu items"),
                Arguments.of(footerBlock.getGoodiesMenuElement(),
                        Arrays.asList("Download Scrobbler", "Developer API", "Free Music Downloads", "Merchandise"), "Test that tests the goodies menu items"),
                Arguments.of(footerBlock.getAccountMenuElement(),
                        Arrays.asList("Sign Up", "Log In", "Subscribe"), "Test that tests the account menu items"),
                Arguments.of(footerBlock.getFollowUsMenuElement(),
                        Arrays.asList("Facebook", "Twitter", "Instagram", "YouTube"), "Test that tests the follow us menu items"));

    }

}
