package eu.deustotech.internet.morelabapp.model;

import java.util.HashMap;
import java.util.Map;

import eu.deustotech.internet.morelabapp.R;
import eu.deustotech.internet.linkedtagworld.layout.Layout;

public class Project implements Layout{

	@Override
	public int getLayout() {
		// TODO Auto-generated method stub
		return R.layout.project;
	}

	@Override
	public Map<String, Integer> getWidgets() {
		// TODO Auto-generated method stub
		Map<String, Integer> widgetMap = new HashMap<String, Integer>();
		widgetMap.put("description", R.id.description);
		widgetMap.put("title", R.id.title);
		widgetMap.put("logo", R.id.logo);
		widgetMap.put("funding", R.id.funding_layout);
		widgetMap.put("members", R.id.consortium_layout);

		return widgetMap;
	}

}
