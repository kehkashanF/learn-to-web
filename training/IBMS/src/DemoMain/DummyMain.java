package DemoMain;

import java.io.IOException;

import com.util.location.AddressConverter;

public class DummyMain {
public static void main(String[] args) {
	AddressConverter addressConverter = new AddressConverter();
	try {
		addressConverter.calculateDistance("ramdaspeth nagpur", "sita buldi nagpur");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Exception");
		e.printStackTrace();
	}
	
}
}
