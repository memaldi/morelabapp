package eu.deustotech.internet.morelabapp.activity;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openrdf.rio.RDFHandlerException;
import org.openrdf.rio.RDFParseException;
import org.xml.sax.SAXException;

import android.app.Activity;
import android.os.Bundle;

import eu.deustotech.internet.morelabapp.R;

import eu.deustotech.internet.linkedtagworld.lib.LinkedTagWorld;

/**
 * Created by mikel on 21/05/13.
 */
public class DataActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinkedTagWorld ltw = new LinkedTagWorld(getApplicationContext(), this, getResources().openRawResource(R.raw.template));
        try {
			ltw.renderData(getIntent().getStringExtra("URI"));
		} catch (RDFParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RDFHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}