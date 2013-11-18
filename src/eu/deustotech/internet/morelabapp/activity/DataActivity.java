package eu.deustotech.internet.morelabapp.activity;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

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
        // Create LinkedTagWorld instance with appropriate parameters. 
        LinkedTagWorld ltw = new LinkedTagWorld(getApplicationContext(), this, getResources().openRawResource(R.raw.lqr));
        try {
        	String lang = "";
        	// We render the data from given RDF URI.
			ltw.renderData(getIntent().getStringExtra("URI"), lang);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}