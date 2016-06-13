package com.carinfo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;

import com.carinfo.R;


/**
 * Created by karunamoorthy on 08/06/16.
 */
public class CarInfoTextView extends TextView {
    public CarInfoTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (isInEditMode()) {
            return;
        }
        // Get the list of attributes
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.CarInfoTextView);
        String fontName = attributes.getString(R.styleable.CarInfoTextView_typeface);
        String htmlText = attributes.getString(R.styleable.CarInfoTextView_htmlText);
        attributes.recycle();

        //Set default type face
        if (fontName == null) {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(),
                    "fonts/" + Font.HELVETICA_SMALL.getFontName() + ".otf");
            this.setTypeface(typeface);
        }

        // Read the font from the assets and assign it to the text view.
        // If the font file is not specified in the XML attributes, set DEFAULT typeface.
        if (fontName != null) {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + fontName + ".otf");
            this.setTypeface(typeface);
        }

        if (htmlText != null) {
            this.setText(Html.fromHtml(htmlText));
        }
    }

    public enum Font {
        HELVETICA_SMALL("helvetica_small"),
        HELVETICA_NORMAL("helvetica_normal"),
        HELVETICA_LARGE("helvetica_large"),
        HELVETICA_EX_LARGE("helvetica_ex_large");


        public String mFontName;

        Font(String fontName) {
            mFontName = fontName;
        }

        public String getFontName() {
            return mFontName;
        }
    }
}
