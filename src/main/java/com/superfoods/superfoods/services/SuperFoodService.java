package com.superfoods.superfoods.services;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SuperFoodService {

    private static List<SuperFood> superFoodList = new ArrayList<>();

    private static int idCounter = 0;

    static {
        superFoodList.add(new SuperFood(++idCounter, "costas", "Superfoods Omegadvance", new Date(), false));
        superFoodList.add(new SuperFood(++idCounter, "costas", "Superfoods cod Pure oil", new Date(), false));
        superFoodList.add(new SuperFood(++idCounter, "costas", "Hippophae Superfoods", new Date(), false));
        superFoodList.add(new SuperFood(++idCounter, "costas", "Superfoods Hippophaes & Papaya", new Date(), false));
        superFoodList.add(new SuperFood(++idCounter, "costas", "Superfoods Proviomax", new Date(), false));
    }

    public List<SuperFood> findAll() {


        return superFoodList;
    }


    public SuperFood deleteById(long id) {

        SuperFood superFood = findById(id);

        if (superFood == null) {
            return null;
        }

        if (superFoodList.remove(superFood)) {
            return superFood;
        }

        return null;
    }

    public SuperFood findById(long id) {

        for (SuperFood superFood : superFoodList) {
            if (superFood.getId() == id) {
                return superFood;
            }
        }
        return null;
    }


    public SuperFood save(SuperFood superFood) {

        if (superFood.getId() == -1) {

            superFood.setId(++idCounter);
            superFoodList.add(superFood);
        } else {
            deleteById(superFood.getId());
            superFoodList.add(superFood);
        }
        return superFood;
    }


    public static List<SuperFood> getSuperFoodList() {
        return superFoodList;
    }

    public static void setSuperFoodList(List<SuperFood> superFoodList) {
        SuperFoodService.superFoodList = superFoodList;
    }
}
