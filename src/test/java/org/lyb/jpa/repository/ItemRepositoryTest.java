package org.lyb.jpa.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.lyb.jpa.domain.Item;
import org.lyb.jpa.domain.ItemSellStatus;
import org.lyb.jpa.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
@Log4j2
public class ItemRepositoryTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private ItemRepository itemRepository;
    @Test
    public void insertItem(){
        Item item3 = Item.builder()
                .itemNm("샤프")
                .itemDetail("샤프")
                .itemSellStatus(ItemSellStatus.판매중)
                .price(1000)
                .stockNumber(10)
                .build();
        itemRepository.save(item3);
    }
    @Test
    public void findAll(){
        List<Item> items = itemRepository.findAll();
        for (Item item : items) {
            log.info(items.toString());
        }
    }
    @Test
    public void findById(){
        Item itm = itemRepository.findById(1L).get();
        log.info(itm);
    }
    @Test
    public void updateMember(){
        Item item = itemRepository.findById(1L).get();
        item.setItemNm("지우개");
        itemRepository.save(item);
    }
//    @Test
//    public void deleteMember(){
//        itemRepository.deleteById(1L);
//    }
}
