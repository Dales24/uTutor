package com.dan.ututor.MainPackage;
import com.stripe.android.view.CardInputWidget;
import com.stripe.android.Stripe;
import com.stripe.android.model.Token;
public class Payments {



    CardInputWidget mCardInputWidget = (CardInputWidget) findViewById(R.id.card_input_widget);

    Card cardToSave = mCardInputWidget.getCard();
if (cardToSave == null) {
        mErrorDialogHandler.showError("Invalid Card Data");
    }
    public void onClickSomething(String cardNumber, String cardExpMonth, String cardExpYear, String cardCVC) {
        Card card = new Card(
                cardNumber,
                cardExpMonth,
                cardExpYear,
                cardCVC
        );

        card.validateNumber();
        card.validateCVC();
    }
    //needs to go into xml
 <com.stripe.android.view.CardInputWidget
    android:id="@+id/card_input_widget"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
            />
}
