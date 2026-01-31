package com.mth.spring.mvc.ordermanagement.mapper;

import com.mth.spring.mvc.ordermanagement.dto.request.CreateItemRequest;
import com.mth.spring.mvc.ordermanagement.dto.response.ItemDto;
import com.mth.spring.mvc.ordermanagement.dto.response.ItemListDto;
import com.mth.spring.mvc.ordermanagement.model.Item;
import java.util.List;

/** Mapper class for converting Item entities to DTOs */
public class ItemMapper {

  /**
   * Converts an Item entity to an ItemDto.
   *
   * @param item the Item entity to convert
   * @return the corresponding ItemDto
   */
  public static ItemDto toItemDto(Item item) {
    if (item == null) {
      return null;
    }
    return new ItemDto(item.getId(), item.getName(), item.getDescription(), item.getPrice());
  }

  /**
   * Converts an Item entity to an ItemListDto.
   *
   * @param item the Item entity to convert
   * @return the corresponding ItemListDto
   */
  public static ItemListDto toItemListDto(Item item) {
    if (item == null) {
      return null;
    }
    return new ItemListDto(item.getId(), item.getName(), item.getPrice());
  }

  /**
   * Converts a list of Item entities to a list of ItemDto.
   *
   * @param items the list of Item entities to convert
   * @return the corresponding list of ItemDtos
   */
  public static List<ItemDto> toItemDtoList(List<Item> items) {
    return items.stream().map(ItemMapper::toItemDto).toList();
  }

  /**
   * Converts a list of Item entities to a list of ItemListDto.
   *
   * @param items the list of Item entities to convert
   * @return the corresponding list of ItemListDtos
   */
  public static List<ItemListDto> toItemListDtoList(List<Item> items) {
    return items.stream().map(ItemMapper::toItemListDto).toList();
  }

  /**
   * Converts a CreateItemRequest to an Item entity.
   * @param request the CreateItemRequest to convert
   * @return the corresponding Item entity
   */
  public static Item toEntity(CreateItemRequest request) {
    return new Item(request.name(), request.description(), request.price());
  }

  /**
   * Converts an ItemListDto to an Item entity.
   * @param itemListDto the ItemListDto to convert
   * @return the corresponding Item entity
   */
  public static Item toEntity(ItemListDto itemListDto) {
    return new Item(itemListDto.name(), null, itemListDto.price());
  }

  /**
   * Converts a list of ItemDto to a list of Item entities.
   *
   * @param items the list of ItemDto to convert
   * @return the corresponding list of Item entities
   */
  public static List<Item> toEntityList(List<ItemListDto> items) {
    return items.stream().map(ItemMapper::toEntity).toList();
  }
}
