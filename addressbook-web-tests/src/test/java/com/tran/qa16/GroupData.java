package com.tran.qa16;

public class GroupData {

    private String name;
    private String header;
    private String footer;

    public GroupData withName(String name) {   //setter
        this.name = name;
        return this;
    }

    public GroupData withHeader(String header) {  //setter
        this.header = header;
        return this;
    }

    public GroupData withFooter(String footer) {  //setter
        this.footer = footer;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }
}
