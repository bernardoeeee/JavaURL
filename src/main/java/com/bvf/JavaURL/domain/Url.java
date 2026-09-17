package com.bvf.JavaURL.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "url")
public class Url {
    @Id
    @GeneratedValue
    private UUID id;

    private String urlDefault;

    private String urlShort;
}
