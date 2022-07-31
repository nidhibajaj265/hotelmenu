package com.tw.hotelmenu.Model;

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
    private long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private double price;
    @Enumerated(EnumType.STRING)
    @Column(name = "itemType")
    private TypeOfMenuItem type;

    public enum TypeOfMenuItem{
        BREAKFAST,
        LUNCH,
        DINNER
    }
}
