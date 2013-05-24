package eu.deustotech.internet.morelabapp.model;

import java.util.HashMap;
import java.util.Map;

import eu.deustotech.internet.morelabapp.R;
import eu.deustotech.internet.linkedtagworld.layout.Layout;

public class Funding implements Layout {

	@Override
	public int getLayout() {
		// TODO Auto-generated method stub
		return R.layout.funding_activity;
	}

	@Override
	public Map<String, Integer> getWidgets() {
		// TODO Auto-generated method stub
		Map<String, Integer> widgetMap = new HashMap<String, Integer>();
		widgetMap.put("year", R.id.textView_funding);
		widgetMap.put("amount", R.id.amount);
		widgetMap.put("label", R.id.label);
		return widgetMap;
	}

}
