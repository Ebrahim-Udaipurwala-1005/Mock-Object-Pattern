package de.tum.in.ase.ise;

public interface Comment {

    boolean save();

    String getText();

    void setText(String text);

    Person getAuthor();

    void setAuthor(Person author);

}

