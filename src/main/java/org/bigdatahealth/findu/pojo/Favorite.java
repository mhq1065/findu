package org.bigdatahealth.findu.pojo;

import lombok.Data;

@Data
public class Favorite {
    private Long favoriteId;

    private Long userId;

    private Long otherId;

    private Integer type;


}