package com.mth.spring.mvc.ordermanagement.service;

import com.mth.spring.mvc.ordermanagement.dto.request.CreateItemRequest;
import com.mth.spring.mvc.ordermanagement.dto.response.ItemDto;
import com.mth.spring.mvc.ordermanagement.dto.response.ItemListDto;
import com.mth.spring.mvc.ordermanagement.mapper.ItemMapper;
import com.mth.spring.mvc.ordermanagement.model.Item;
import com.mth.spring.mvc.ordermanagement.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;

/** Service class for managing items in the order management system. */
public class ItemService {

  private final ItemRepository itemRepository;

  /**
   * Constructor for ItemService.
   *
   * @param itemRepository the repository for item data access
   */
  public ItemService(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  /**
   * Retrieves an item by its ID and converts it to an ItemDto.
   *
   * @param id the ID of the item to retrieve
   * @return the ItemDto representing the item
   * @throws EntityNotFoundException if the item with the given ID does not exist
   */
  public ItemDto getItemById(Long id) {
    return itemRepository
        .findById(id)
        .map(ItemMapper::toItemDto)
        .orElseThrow(() -> new EntityNotFoundException("Item not found with id: " + id));
  }

  /**
   * Retrieves an item by its ID and converts it to an ItemListDto.
   *
   * @param id the ID of the item to retrieve
   * @return the ItemListDto representing the item
   * @throws EntityNotFoundException if the item with the given ID does not exist
   */
  public ItemListDto getItemListById(Long id) {
    return itemRepository
        .findById(id)
        .map(ItemMapper::toItemListDto)
        .orElseThrow(() -> new EntityNotFoundException("Item not found with id: " + id));
  }

  /**
   * Retrieves all items and converts them to a list of ItemDto.
   *
   * @return list of ItemDto representing all items
   */
  public List<ItemDto> getAllItems() {
    return ItemMapper.toItemDtoList(itemRepository.findAll());
  }

  /**
   * Retrieves all items and converts them to a list of ItemListDto.
   *
   * @return list of ItemListDto representing all items
   */
  public List<ItemListDto> getAllItemLists() {
    return ItemMapper.toItemListDtoList(itemRepository.findAll());
  }

  /**
   * Creates a new item from the given ItemDto.
   *
   * @param itemDto the ItemDto containing item details
   * @return the created ItemDto
   */
  public ItemDto createItem(CreateItemRequest request) {
    Item item = ItemMapper.toEntity(request);
    return ItemMapper.toItemDto(itemRepository.save(item));
  }

  /**
   * Deletes an item by its ID.
   *
   * @param id the ID of the item to delete
   * @throws EntityNotFoundException if the item with the given ID does not exist
   */
  public void deleteItem(Long id) {
    if (!itemRepository.existsById(id)) {
      throw new EntityNotFoundException("Item not found with id: " + id);
    }
    itemRepository.deleteById(id);
  }
}
