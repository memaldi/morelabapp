package eu.deustotech.internet.morelabapp.model;

import java.util.HashMap;
import java.util.Map;

import eu.deustotech.internet.morelabapp.R;
import eu.deustotech.internet.linkedtagworld.layout.Layout;

public class Organization implements Layout {

	@Override
	public int getLayout() {
		// TODO Auto-generated method stub
		return R.layout.organization;
	}

	@Override
	public Map<String, Integer> getWidgets() {
		// TODO Auto-generated method stub
		Map<String, Integer> widgetMap = new HashMap<String, Integer>();
		widgetMap.put("name", R.id.org_name);
		return widgetMap;
	}

}
