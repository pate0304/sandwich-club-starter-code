package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    /**
     * Takes JSON as string and sets objects to Model
     */

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Sandwich sandwich = new Sandwich();

        if (jsonObject != null) {
            // "name" is object in json Object
            JSONObject name = jsonObject.getJSONObject("name");

            sandwich.setMainName(name.getString("mainName"));
            sandwich.setAlsoKnownAs(JSONArraytoListArray(name.getJSONArray("alsoKnownAs")));
            sandwich.setImage(jsonObject.getString("image"));
            sandwich.setPlaceOfOrigin(jsonObject.getString("placeOfOrigin"));
            sandwich.setDescription(jsonObject.getString("description"));
            sandwich.setIngredients(JSONArraytoListArray(jsonObject.getJSONArray("ingredients")));
        }

        return sandwich;
    }

    /**
     * Method to convert JSONArray to Java String ArrayList
     *
     * @param jsonArray
     * @return
     */
    public static List<String> JSONArraytoListArray(JSONArray jsonArray) {
        List<String> tempList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                tempList.add(jsonArray.getString(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return tempList;
    }
}
