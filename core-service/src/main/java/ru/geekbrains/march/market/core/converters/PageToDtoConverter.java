package ru.geekbrains.march.market.core.converters;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.api.PageDto;
import ru.geekbrains.march.market.api.ProductDto;

@Component
public class PageToDtoConverter {

    public PageDto pageConvertToDto(Page<ProductDto> page) {
        PageDto convertedPage = new PageDto();
        convertedPage.setContent(page.getContent());
        convertedPage.setNumber(page.getNumber());
        convertedPage.setTotalPages(page.getTotalPages());
        return convertedPage;
    }
}
