import static com.codeborne.selenide.Selenide.$;

public class CheckoutOverviewPage {
    public HeaderBlock headerBlock;

    public CheckoutOverviewPage(HeaderBlock headerBlock) {
        this.headerBlock = headerBlock;
    }

    public CheckoutCompletePage clickToFinishBtn() {
        $("[data-test ='finish']").click();
        return new CheckoutCompletePage(headerBlock);
    }
}
