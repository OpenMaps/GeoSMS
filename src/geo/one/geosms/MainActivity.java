package geo.one.geosms;


/*
 * Author : Vijith Venkatesh
 * Andrew ID: vvankate
 * This is a single button application
 * which gets the current location from the network provider
 * and sends an SMS to another number
 * if the LocationManager is changed to GPS_PROVIDER
 * the location data from GPS can also be retrieved.
 * SmsManager is used to send the SMS.
 * I have used my mobile number in the sendTextMessage method,
 * please change the number to the required number for testing
 * 
 */
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button b1;
	private String Text="Default";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1=(Button)findViewById(R.id.button1);
		LocationManager locationManager = (LocationManager) getApplicationContext()
	            .getSystemService(Context.LOCATION_SERVICE);
		
		Location loc = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER) ;
		if(loc!=null){
			Text = "My current location is: " + "Latitude = " + loc.getLatitude() + "Longitude = " + loc.getLongitude();
		}	
		
		b1.setOnClickListener(new OnClickListener() {
			@Override
			 public void onClick(View view) {
				SmsManager sms = SmsManager.getDefault();
				sms.sendTextMessage("+14126410691", null, Text, null, null);
				Toast.makeText(getBaseContext(),"SMS has been Sent",Toast.LENGTH_SHORT).show();
			}
		});	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
		
}
