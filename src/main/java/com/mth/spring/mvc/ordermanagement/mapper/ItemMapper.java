package com.mth.spring.mvc.ordermanagement.mapper;

import com.mth.spring.mvc.ordermanagement.dto.ItemDto;
import com.mth.spring.mvc.ordermanagement.dto.ItemListDto;
import com.mth.spring.mvc.ordermanagement.model.Item;
import java.util.List;

public class ItemMapper {

  public static ItemDto toItemDto(Item item) {
    if (item == null) {
      return null;
    }
    return new ItemDto(item.getId(), item.getName(), item.getDescription(), item.getPrice());
  }

  public static ItemListDto toItemListDto(Item item) {
    if (item == null) {
      return null;
    }
    return new ItemListDto(item.getId(), item.getName(), item.getPrice());
  }

  public static List<ItemDto> toItemDtoList(List<Item> items) {
    return items.stream().map(ItemMapper::toItemDto).toList();
  }

  public static List<ItemListDto> toItemListDtoList(List<Item> items) {
    return items.stream().map(ItemMapper::toItemListDto).toList();
  }
}
