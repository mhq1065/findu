package org.bigdatahealth.findu.service;

import org.bigdatahealth.findu.pojo.Favorite;

import java.util.List;
import java.util.Map;

public interface FavoriteService {

    void insertFavorite(Favorite favorite);

    Map<String, List> getAllFavorites(Long userId,Integer type);

    void delete(Long id);

    void deleteFavorite(Favorite favorite);
}
