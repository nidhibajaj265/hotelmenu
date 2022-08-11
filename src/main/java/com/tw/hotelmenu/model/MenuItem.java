package com.tw.hotelmenu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Table (name = "menu_items")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "item_type", nullable = false)
    private String type;

}
