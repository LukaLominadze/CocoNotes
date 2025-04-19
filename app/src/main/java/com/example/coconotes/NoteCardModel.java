package com.example.coconotes;

import android.widget.Button;

public class NoteCardModel {

    private String title;
    private String subheading;
    private Button button;

    public NoteCardModel(String title, String subheading) {
        this.title = title;
        this.subheading = subheading;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubheading(String subheading) {
        this.subheading = subheading;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public String getSubheading() {
        return subheading;
    }

    public String getTitle() {
        return title;
    }

    public Button getButton() {
        return button;
    }
}
