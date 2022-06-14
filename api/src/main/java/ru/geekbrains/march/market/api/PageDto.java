package ru.geekbrains.march.market.api;

import java.util.ArrayList;
import java.util.List;

public class PageDto {

    private List<ProductDto> content;
    private int number;
    private int totalPages;

    public PageDto() {
        this.content = new ArrayList<>();
    }

    public List<ProductDto> getContent() {
        return content;
    }

    public void setContent(List<ProductDto> content) {
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
