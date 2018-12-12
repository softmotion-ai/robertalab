#include <math.h> 
#include <BOB3.h> 
#include <NEPODefs.h>
Bob3 myBob;

    
unsigned long __time = millis();

void setup()
{
    
}

void loop()
{
    while (true) {
        if ( ( myBob.getArm(2) == 1 ) == true ) {
            break;
        }
        delay(1);
    }
    while (true) {
        if ( ( myBob.getArm(2) == 2 ) == true ) {
            break;
        }
        delay(1);
    }
    while (true) {
        if ( ( myBob.getArm(2) == 3 ) == true ) {
            break;
        }
        delay(1);
    }
    while (true) {
        if ( ( myBob.getArm(2) > 0 ) == true ) {
            break;
        }
        delay(1);
    }
    while (true) {
        if ( ( myBob.getArm(1) == 1 ) == true ) {
            break;
        }
        delay(1);
    }
    while (true) {
        if ( ( myBob.getArm(1) == 2 ) == true ) {
            break;
        }
        delay(1);
    }
    while (true) {
        if ( ( myBob.getArm(1) == 3 ) == true ) {
            break;
        }
        delay(1);
    }
    while (true) {
        if ( ( myBob.getArm(1) > 0 ) == true ) {
            break;
        }
        delay(1);
    }
    while (true) {
        if ( myBob.getIRLight() < 30 ) {
            break;
        }
        delay(1);
    }
    while (true) {
        if ( myBob.getIRSensor() < 30 ) {
            break;
        }
        delay(1);
    }
    while (true) {
        if ( myBob.getTemperature() < 20 ) {
            break;
        }
        delay(1);
    }
    while (true) {
        if ( (int) (millis() - __time) > 500 ) {
            break;
        }
        delay(1);
    }
    delay(500);
    while (true) {
        if ( ( 0 == 0 ) && true ) {
            break;
        }
        delay(1);
    }
}