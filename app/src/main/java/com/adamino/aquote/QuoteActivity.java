package com.adamino.aquote;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class QuoteActivity extends AppCompatActivity {

    private QuoteBook mQuoteBook = new QuoteBook();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        // Declare View variables
        final TextView textQuote = (TextView) findViewById(R.id.textQuote);
        final TextView textAuthor = (TextView) findViewById(R.id.textAuthor);
        final ImageView imageAuthor = (ImageView) findViewById(R.id.imageAuthor);
        Button quoteButton = (Button) findViewById(R.id.quoteButton);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Randomly select a fact
                Random randomGenerator = new Random();
                int randomNumber = randomGenerator.nextInt(mQuoteBook.mQuotes.length);

                String Quote = mQuoteBook.mQuotes[randomNumber][0];
                String Author = mQuoteBook.mQuotes[randomNumber][1];
                int Image = Integer.parseInt(mQuoteBook.mQuotes[randomNumber][2]);
                // Update the Quote
                textQuote.setText(Quote);
                textAuthor.setText(Author);
                imageAuthor.setImageResource(Image);

            }
        };

        quoteButton.setOnClickListener(listener);
    }
}
