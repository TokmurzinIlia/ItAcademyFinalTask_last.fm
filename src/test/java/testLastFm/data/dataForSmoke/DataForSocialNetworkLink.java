package testLastFm.data.dataForSmoke;

import by.itAcademy.ui.blocks.FooterBlock;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class DataForSocialNetworkLink implements ArgumentsProvider {

    private FooterBlock footerBlock = new FooterBlock();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(footerBlock.getFollowUsFacebook(),
                        "https://www.facebook.com/lastfm", "checkLinkFacebook"),
                Arguments.of(footerBlock.getFollowUsTwitter(),
                        "https://twitter.com/lastfm", "checkLinkTwitter"),
                Arguments.of(footerBlock.getFollowUsInstagram(),
                        "https://www.instagram.com/last_fm/", "checkLinkInstagram"),
                Arguments.of(footerBlock.getFollowUsYouTube(),
                        "https://www.youtube.com/user/lastfm", "checkLinkYoutube"));
    }
}
