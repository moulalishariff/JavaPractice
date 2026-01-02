package com.example.entity;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Book {
	
	private long id;
	private String title;
	private String description;
	private double price;
	private String author;
	private String publisher;
	private int quantity;
	
	@Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", quantity=" + quantity +
                '}';
    }
	
	
}
