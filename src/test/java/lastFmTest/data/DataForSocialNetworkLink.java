package lastFmTest.data;

import by.itAcademy.ui.pages.MainPage;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class DataForSocialNetworkLink implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(MainPage.followUsFacebook,
                        "https://www.facebook.com/lastfm", "checkLinkFacebook"),
                Arguments.of(MainPage.followUsTwitter,
                        "https://twitter.com/lastfm", "checkLinkTwitter"),
                Arguments.of(MainPage.followUsInstagram,
                        "https://www.instagram.com/last_fm/", "checkLinkInstagram"),
                Arguments.of(MainPage.followUsYouTube,
                        "https://www.youtube.com/user/lastfm", "checkLinkYoutube"));
    }
}
