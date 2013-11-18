package eu.deustotech.internet.morelabapp.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import eu.deustotech.internet.morelabapp.R;

public class BarcodeActivity extends Activity {

	// Barcode Scanner's package name
	private static final String BS_PACKAGE = "com.google.zxing.client.android";
	// A random code to identify the request to the Barcode Scanner
	private static final int QR_CODE_REQUEST_CODE = 5678;
	// A random code to identifu the requesto Google Play
	private static final int MARKET_REQUEST_CODE = 4932;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getBarcodeScanner();
	}

	private void getBarcodeScanner() {
		try {
			// We try to search the Barcode Scanner. If it is not installed the
			// call fails and continues through the catch.
			PackageInfo pi = searchPackageByURI(BarcodeActivity.BS_PACKAGE,
					this);
			// Get the Barcode Scanner intent
			Intent bsIntent = new Intent(BarcodeActivity.BS_PACKAGE + ".SCAN");
			// Determine the SCAN_MODE parameter
			bsIntent.putExtra("SCAN_MODE", "QR_CODE_MODE");
			// Launch the Barcode Scanner
			startActivityForResult(bsIntent,
					BarcodeActivity.QR_CODE_REQUEST_CODE);
		} catch (PackageManager.NameNotFoundException e) {
			// If the Barcode Scanner is not installed we request the user for permission to install it.
			final AlertDialog bsAlertDialog = new AlertDialog.Builder(this)
					.create();
			bsAlertDialog.setTitle(R.string.bs_popup_title);
			bsAlertDialog.setMessage(getString(R.string.bs_popup_message));
			bsAlertDialog.setButton(AlertDialog.BUTTON_POSITIVE,
					getString(R.string.bs_OK_button),
					new DialogInterface.OnClickListener() {
						// If user allows, we show Barcode Scanner in Google Play.
						public void onClick(DialogInterface dialog, int which) {
							Uri bsMarket = Uri.parse("market://details?id="
									+ BS_PACKAGE);
							Intent marketIntent = new Intent(
									Intent.ACTION_VIEW, bsMarket);
							bsAlertDialog.cancel();
							startActivityForResult(marketIntent,
									MARKET_REQUEST_CODE);
						}

					});
			bsAlertDialog.setButton(AlertDialog.BUTTON_NEGATIVE,
					getString(R.string.bs_CANCEL_button),
					new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int which) {
							startActivity(new Intent(getApplicationContext(),
									HomeActivity.class));
						}
					});
			bsAlertDialog.setIcon(R.drawable.ic_launcher);
			bsAlertDialog.show();
		}
	}

	public PackageInfo searchPackageByURI(String packageURI, Context context)
			throws PackageManager.NameNotFoundException {
		PackageManager pm = context.getPackageManager();
		try {
			PackageInfo pi = pm.getPackageInfo(packageURI,
					PackageManager.GET_ACTIVITIES);
			return pi;
		} catch (PackageManager.NameNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new PackageManager.NameNotFoundException();
		}

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == MARKET_REQUEST_CODE) {
			// Once Barcode Scanner is installed, we launch it.
			getBarcodeScanner();
		} else if (requestCode == QR_CODE_REQUEST_CODE) {
			// If Barcode Scanner returns a result, we launch LinkedTagWorld
			if (resultCode == RESULT_OK) {

				// URI of QR Code
				String QRURI = data.getStringExtra("SCAN_RESULT");

				try {

					// applyTemplate(QRURI);

					// We launch LinkedTagWorld in another class because design issues.
					Intent intent = new Intent(this, DataActivity.class);
					intent.putExtra("URI", QRURI);
					startActivity(intent);

				} catch (Exception e) {
					e.printStackTrace();

					Context context = getApplicationContext();
					int duration = Toast.LENGTH_LONG;
					Toast toast = Toast.makeText(context, R.string.qr_error,
							duration);
					toast.show();
					// TODO: cambiar
					// UIUtils.goHome(this);
				}
			} else {
				// TODO: cambiar
				// UIUtils.goHome(this);
			}
		}
	}

}
