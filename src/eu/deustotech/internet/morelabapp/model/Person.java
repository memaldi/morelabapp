package eu.deustotech.internet.morelabapp.model;

import eu.deustotech.internet.morelabapp.R;
import eu.deustotech.internet.linkedtagworld.layout.Layout;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mikel on 22/05/13.
 */
public class Person implements Layout {
    @Override
    public int getLayout() {
        return R.layout.activity_data;
    }

    @Override
    public Map<String, Integer> getWidgets() {
        Map<String, Integer> widgetMap = new HashMap<String, Integer>();
        widgetMap.put("depiction", R.id.depiction);
        widgetMap.put("name", R.id.name);
        widgetMap.put("email", R.id.email);
        widgetMap.put("workmates", R.id.workmates);
        return widgetMap;
    }
}
