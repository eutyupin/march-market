package ru.geekbrains.march.market.api;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

@Schema(description = "Модель страницы вывода продуктов")
public class PageDto {
    @Schema(description = "Список продуктов", required = true)
    private List<ProductDto> content;
    @Schema(description = "Номер страницы", required = true, example = "1")
    private int number;
    @Schema(description = "Общее количество страниц", required = true, example = "10")
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
