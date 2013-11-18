package eu.deustotech.internet.morelabapp.model;

import java.util.HashMap;
import java.util.Map;

import eu.deustotech.internet.morelabapp.R;
import eu.deustotech.internet.linkedtagworld.layout.Layout;

public class Funding implements Layout {

	@Override
	public int getLayout() {
		// We return the layout which renders entities of type Layout
		return R.layout.funding_activity;
	}

	@Override
	public Map<String, Integer> getWidgets() {
		// We create a widgetMap pairing the id of properties and their widgets in layout.
		Map<String, Integer> widgetMap = new HashMap<String, Integer>();
		widgetMap.put("year", R.id.textView_funding);
		widgetMap.put("amount", R.id.amount);
		widgetMap.put("label", R.id.label);
		return widgetMap;
	}

}
