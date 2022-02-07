package testLastFm.data;

import by.itAcademy.ui.pages.SingUpPage;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.stream.Stream;

public class DataForSingUpValidationForm implements ArgumentsProvider {

    SingUpPage singUpPage = new SingUpPage();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(Arrays.asList(singUpPage.getUserNameSingUpFormInputField(), singUpPage.getEmailSingUpFormInputField(),
                                singUpPage.getPasswordSingUpFormInputField(), singUpPage.getConfirmPasswordSingUpFormInputField()),
                        Arrays.asList("Username", "Email", "Password", "Confirm Password"), "checkElementPrimaryNavigationMenu"));
    }
}
