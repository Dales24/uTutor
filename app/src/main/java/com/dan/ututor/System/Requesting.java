package com.dan.ututor.System;

import android.os.Bundle;
import com.stripe.android.model.Card;
import com.stripe.android.view.CardInputWidget;
import com.stripe.android.Stripe;
import com.stripe.android.model.Token;
public class Requesting {
}


// need to figure out which librarys are avalaible
/*
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);






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



        try {
            // Use Stripe's library to make requests...
        } catch (CardException e) {
            // Since it's a decline, CardException will be caught
            System.out.println("Status is: " + e.getCode());
            System.out.println("Message is: " + e.getMessage());
        } catch (RateLimitException e) {
            // Too many requests made to the API too quickly
        } catch (InvalidRequestException e) {
            // Invalid parameters were supplied to Stripe's API
        } catch (AuthenticationException e) {
            // Authentication with Stripe's API failed
            // (maybe you changed API keys recently)
        } catch (APIConnectionException e) {
            // Network communication with Stripe failed
        } catch (StripeException e) {
            // Display a very generic error to the user, and maybe send
            // yourself an email
        } catch (Exception e) {
            // Something else happened, completely unrelated to Stripe
        }
        //needs to go into xml
// <com.stripe.android.view.CardInputWidget
//    android:id="@+id/card_input_widget"
        //   android:layout_width="match_parent"
        //   android:layout_height="wrap_content"
        //         />
    }
}
    /*
     send message "person name would like to be tutored for this amount of time"
     //button click action event;

     if(tutor accepts)
    create message "request accepted"
  }
   */