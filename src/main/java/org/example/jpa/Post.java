package org.example.jpa;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = IDENTITY) // AUTO_INCREMENT
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    @Column(length = 100)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private boolean blind;
}