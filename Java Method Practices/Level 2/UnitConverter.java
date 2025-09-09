public class UnitConverter {

    public static double convertKmToMiles(double km) {
        return km * 0.621371;
    }

    public static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }

    public static double convertMetersToFeet(double meters) {
        return meters * 3.28084;
    }

    public static double convertFeetToMeters(double feet) {
        return feet * 0.3048;
    }

    public static double convertYardsToFeet(double yards) {
        return yards * 3;
    }

    public static double convertFeetToYards(double feet) {
        return feet / 3;
    }

    public static double convertMetersToInches(double meters) {
        return meters * 39.3701;
    }

    public static double convertInchesToMeters(double inches) {
        return inches * 0.0254;
    }
    
    public static double convertInchesToCentimeters(double inches) {
        return inches * 2.54;
    }

    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }
    
    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }
    
    public static double convertKilogramsToPounds(double kg) {
        return kg * 2.20462;
    }
    
    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }
    
    public static double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }

    public static void main(String[] args) {
        System.out.println("10 km is " + convertKmToMiles(10) + " miles.");
        System.out.println("75 degrees F is " + convertFahrenheitToCelsius(75) + " degrees C.");
        System.out.println("10 gallons is " + convertGallonsToLiters(10) + " liters.");
    }
}