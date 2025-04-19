package com.example.coconotes;

import android.widget.Button;

public class NoteCardModel {

    private String title;
    private String subheading;

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

    public String getSubheading() {
        return subheading;
    }

    public String getTitle() {
        return title;
    }
}
