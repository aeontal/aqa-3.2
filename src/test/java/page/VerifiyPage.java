package page;

import com.codeborne.selenide.SelenideElement;
import data.DataGenerator;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerifiyPage {
    private SelenideElement codeField = $("[data-test-id=code] input");
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");

    public VerifiyPage() {
        codeField.shouldBe(visible);
    }


    public AccountPage validVerify(String code) {
        codeField.setValue(code);
        verifyButton.click();
        return new AccountPage();
    }

    public AccountPage invalidVerify() {
        codeField.setValue(DataGenerator.getInvalidCodeVerify());
        verifyButton.click();
        return new AccountPage();
    }


}
