#include <WiiRemote.h>
#include <Usb.h>


WiiRemote wiiremote;
double x,y,z;

uint8_t wiiremote_bdaddr[6] = {0x00, 0x15, 0x83, 0x0c, 0xbf, 0xeb};

void setup() {
    Serial.begin(9600);
    wiiremote.init();

    // This is the bluetooth address of your Wii remote. You need to find it and change here
    
    wiiremote.setBDAddress(wiiremote_bdaddr, 6);
    wiiremote.setBDAddressMode(BD_ADDR_INQUIRY);
    Serial.print("Press 1 and 2 \n");
}

void loop() {
    wiiremote.task(&app);
    if (!(wiiremote.getStatus() & WIIREMOTE_STATE_RUNNING)) {

    }else
    {
      
    }
}

// Call back which is executed by wiiremote.task() method
void app(void) {
    x += wiiremote.Report.Accel.X;
    y += wiiremote.Report.Accel.Y;
    z += wiiremote.Report.Accel.Z;

    Serial.print(x);
    Serial.print(", ");
    Serial.print(y);
    Serial.print(", ");
    Serial.print(z);
    Serial.print("\n");
}



