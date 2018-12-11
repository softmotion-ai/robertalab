#include <math.h> 
#include <BOB3.h> 
#include <NEPODefs.h>
Bob3 myBob;

    
double item;
bool item2;
unsigned long __time = millis();

void setup()
{
    item = 0;
    item2 = true;
    
}

void loop()
{
    item = myBob.getIRLight();
    item = myBob.getIRSensor();
    item = myBob.getTemperature();
    item = myBob.getID();
    item = (int) (millis() - __time);
    item2 = ( myBob.getArm(2) == 1 );
    __time = millis();
}