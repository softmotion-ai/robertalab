#include "SenseBoxMCU.h"
    
unsigned long _time = millis();

BMP280 _bmp280_T;
char* _bmp280_id_T = "MYiDfpM7QUnqQSTd";
VEML6070 _veml_V;
TSL45315 _tsl_V;
char* _veml_tsl_id_V = "LZQo7cUun6qB47Lf";
Bee* _bee_W = new Bee();
OpenSenseMap _osem("L8M8EN2872oFCdzC", _bee_W);

HDC1080 _hdc1080_H;
char* _hdc1080_id_H = "rut9fA5f3a8ZDZAj";

void setup()
{
    Serial.begin(9600); 
    _bmp280_T.begin();
    _veml_V.begin();
    _tsl_V.begin();
    _bee_W->connectToWifi("test-ssid","passw0rd");
    delay(1000);
    _hdc1080_H.begin();
}

void loop()
{
    Serial.println("humidity:");
    Serial.println(_hdc1080_H.getHumidity());
    Serial.println("temperature");
    Serial.println(_hdc1080_H.getTemperature());
    Serial.println("temperature");
    Serial.println(_bmp280_T.getTemperature());
    Serial.println("pressure");
    Serial.println(_bmp280_T.getPressure());
    Serial.println("light");
    Serial.println(_tsl_V.getIlluminance());
    Serial.println("uvlight");
    Serial.println(_veml_V.getUvIntensity());
    _osem.uploadMeasurement(_hdc1080_H.getHumidity(),_hdc1080_id_H);
    _osem.uploadMeasurement(_hdc1080_H.getTemperature(),_hdc1080_id_H);
    _osem.uploadMeasurement(_bmp280_T.getTemperature(),_bmp280_id_T);
    _osem.uploadMeasurement(_bmp280_T.getPressure(),_bmp280_id_T);
    _osem.uploadMeasurement(_tsl_V.getIlluminance(),_veml_tsl_id_V);
    _osem.uploadMeasurement(_veml_V.getUvIntensity(),_veml_tsl_id_V);
    
    delay(5000);
}