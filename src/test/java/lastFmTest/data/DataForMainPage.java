package lastFmTest.data;

import by.itAcademy.ui.pages.MainPage;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;


import java.util.Arrays;

import java.util.stream.Stream;

public class DataForMainPage implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(MainPage.primaryNavigationMenu,
                        Arrays.asList("Live", "Music", "Charts", "Events", "Features"), "checkElementPrimaryNavigationMenu"),
                Arguments.of(MainPage.followUsMenu,
                        Arrays.asList("Facebook", "Twitter", "Instagram", "YouTube"), "checkElementFollowUsMenu"));

//    public static List<String> primaryNavigationMenu =
//            new ArrayList<>(Arrays.asList("Live", "Music", "Charts", "Events", "Features"));
//
//    public static List<String> followUsMenu =
//            new ArrayList<>(Arrays.asList("Facebook", "Twitter", "Instagram", "YouTube"));
    }

}
