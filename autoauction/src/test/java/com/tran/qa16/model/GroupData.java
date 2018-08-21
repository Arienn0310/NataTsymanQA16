package com.tran.qa16.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(name, groupData.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    @Override
    public String toString() {
        return
              name;
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
