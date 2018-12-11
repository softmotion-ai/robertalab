#include <math.h> 
#include <BOB3.h> 
#include <NEPODefs.h>
Bob3 myBob;

    
double item;
unsigned int item2;

void setup()
{
    item = 0;
    item2 = RGB(0xFF, 0xFF, 0xFF);
    
}

void loop()
{
    myBob.setLed(EYE_2, RGB(0xFF, 0x00, 0x00));
    myBob.setLed(EYE_1, RGB(0xFF, 0x00, 0x00));
    myBob.setLed(EYE_1, item2);
    myBob.setLed(EYE_2, item2);
    myBob.setLed(EYE_2, OFF);
    myBob.setLed(EYE_1, OFF);
    myBob.setLed(LED_4, ON);
    myBob.setLed(LED_3, ON);
    myBob.setLed(LED_4, OFF);
    myBob.setLed(LED_3, OFF);
    remember((int)(item));
    item = recall();
    myBob.transmitIRCode(item);
    item = myBob.receiveIRCode(500);
}