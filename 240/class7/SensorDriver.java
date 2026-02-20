public class SensorDriver {
    public static void main(String[] args) {
        Sensor sensor = new Celsius();
        double tempCel = sensor.getTempCelsuis();

        Fahrenheit adapter = new FahrenheitAdapter(sensor);
        double tempFah = adapter.getTempFahrenheit();

        System.out.println("Temperature in Celsius: " + tempCel);
        System.out.println("Temperature in Fahrenheit: " + tempFah);

        
    }
}

interface Sensor 
{
    double getTempCelsuis();
}

class Celsius implements Sensor
{
    @Override
    public double getTempCelsuis() {
        return 25.0;
    }
}

interface Fahrenheit
{
    double getTempFahrenheit();
}

class FahrenheitAdapter implements Fahrenheit
{   
    Sensor sensor;
    public FahrenheitAdapter(Sensor sensor) 
    {
        this.sensor = sensor;
    }
    @Override
    public double getTempFahrenheit() {
        double temp = sensor.getTempCelsuis();
        return (temp * 9/5) + 32;
    }
}