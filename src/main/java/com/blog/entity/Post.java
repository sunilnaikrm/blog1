package com.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="newpost")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="title", nullable = false, unique = true)
    private String title;

    @Column(name="description", nullable = false, unique = true)
    private String description;

    @Column(name="column", nullable = false, unique = true)
    private String content;
}
