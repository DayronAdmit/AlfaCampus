import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage {
    public HeaderBlock headerBlock;

    public AuthorizationPage() {
        headerBlock = new HeaderBlock();
    }

    public ProductsPage authorizationWithValidDate(String login, String password) {
        $("#user-name").setValue(login);
        $("#password").setValue(password);
        $("#login-button").click();
        return new ProductsPage(headerBlock);
    }

    public AuthorizationPage authorizationWithInvalidDate(String login, String password) {
        $("#user-name").setValue(login);
        $("#password").setValue(password);
        $("#login-button").click();
        return this;
    }

    public SelenideElement getLoginErrorField() {
        return $(".error-message-container");
    }

    public SelenideElement getUserNameFiled() {
        return $("#user-name");
    }
}


