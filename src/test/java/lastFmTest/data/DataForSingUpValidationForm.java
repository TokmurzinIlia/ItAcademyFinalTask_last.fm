package lastFmTest.data;

import by.itAcademy.ui.pages.SingUpPage;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class DataForSingUpValidationForm implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(Arrays.asList(SingUpPage.userNameSingUpFormInputField, SingUpPage.emailSingUpFormInputField,
                        SingUpPage.passwordSingUpFormInputField, SingUpPage.confirmPasswordSingUpFormInputField),
                        Arrays.asList("Username", "Email", "Password", "Confirm Password"), "checkElementPrimaryNavigationMenu"));
    }
}
