package com.javarush.redis;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
public class Language {

    private String language;

    private Boolean isOfficial;

    private BigDecimal percentage;

}
