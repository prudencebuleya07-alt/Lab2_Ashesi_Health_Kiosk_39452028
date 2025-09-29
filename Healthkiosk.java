//ASHESI HEALTH KIOSK

//Task 0-Project setup
import java.util.Scanner;

public class HealthKiosk {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Ashesi Health Kiosk");
        

        //Task 1-Service Router(focus:switch)
        System.out.println("Enter service code(P,L/T/C): ");
        String serviceCode = input.next();
        serviceCode = serviceCode.toUpperCase();

        switch(serviceCode){
            case "P":
                System.out.println("Go to:Pharmacy Desk");
                break;
            case "L":
                System.out.println("Go to:Lab Desk");
                break;
            case "T":
                System.out.println("Go to:Triage Desk");
                break;                      
            case "C":
                System.out.println("Go to:Counselling Desk");
                break;
            default:
                System.out.println("Invalid service code");
                break; 
        }

        // Task 2-Mini HeaLth Metric(focus:Math functions)
        System.out.println("Enter Health Metric:1 for BMI,2 for Dosage Round Up,3 for single Trig helper ");
        int healthMetric = input.nextInt();
        double bmi = 0.0; // Declare bmi before the switch
        double metricValue = 0.0;
        


        switch(healthMetric){

            case 1://this refers to option A:BMI Quick Calculator
                 System.out.println("Enter weight in kilograms: ");
                 double weight = input.nextDouble();

                 System.out.println("Enter height in meters: ");
                 double height = input.nextDouble();

            // to find actual bmi
                 bmi = weight / (height * height);
                 bmi=Math.round(bmi*10)/10.0;
                 System.out.printf("Your BMI is: %.1f\n",bmi);
                 if 
                    (bmi<18.5){
                        System.out.println(bmi + "--> Underweight" );
                    }
                    else if (bmi>=18.5 && bmi<24.9){
                        System.out.println(bmi + "--> normal");
                    }
                    else if (bmi>=25 && bmi<29.9){
                        System.out.println(bmi+"--> overweight");
                    }
                    else{
                        System.out.println(bmi+"--> obese");
                    }
                    break;  

                case 2://this refers to option B:Dosage Round Up
                    System.out.println("Enter dosage in mg: ");
                    double dosage = input.nextDouble();
                    int dose = (int)Math.ceil(dosage/250);
                    System.out.print("The actual dose: " + (dose * 250) + "mg");
                    break;

                case 3://this refers to option C:Single Trig Helper
                    System.out.println("Enter angle in degrees: ");
                    double angle = input.nextDouble();
                    double radians = Math.toRadians(angle);
                    double sineAngle = Math.round(Math.sin(radians) * 1000) / 1000.0;
                    double cosineAngle = Math.round(Math.cos(radians) * 1000) / 1000.0;
                    System.out.println("Sine of angle provided:" + sineAngle);
                    System.out.println("Cosine of angle provided:" + cosineAngle);
                    break;

                default:
                    System.out.println("Invalid health metric option");
                    break;
                }

                //Task 3-ID Sanity Check(focus:characters & strings)

                char randomchar = (char)'A';//this chunk of code will generate a random ID
                int randomNumber = (int)(Math.random() * 26);
                randomchar += randomNumber;
                String id = "" + randomchar;
                // Validate ID
                   if (id.length() != 5) {
                      System.out.println("Invalid length");
                     } else if (!Character.isLetter(id.charAt(0))) {
                     System.out.println("Invalid: first char must be a letter");
                    } else if (!(Character.isDigit(id.charAt(1)) && Character.isDigit(id.charAt(2))
                    && Character.isDigit(id.charAt(3)) && Character.isDigit(id.charAt(4)))) {
                    System.out.println("Invalid: last 4 must be digits");
                    } else {
                    System.out.println("ID OK");
                    System.out.println("Generated ID: " + id);
                    }
                //Task 4-“Secure” Display Code (focus: char arithmetic & strings)

                System.out.println("Enter your first name: ");
                String firstName = input.next();
                char base = Character.toUpperCase(firstName.charAt(0));
                char shiftedChar = (char)('A' + (base - 'A' + 2) % 26);
                String last2Chars = "";
                     if (id.length() >= 2) {
                   last2Chars = id.substring(id.length() - 2);
                   } else {
                     last2Chars = id; // if it's shorter than 2, just use what you have
                     }


                int bmiInt=(int)Math.round(bmi);
                String displayCode = "" + shiftedChar + last2Chars +"-" + bmiInt; 
                System.out.println("Display code: " + displayCode);
                System.out.println("Display code: " + displayCode);
                System.out.println("Display code: " + displayCode);

                //Task 5-Service Summary(light switch + strings)
                String serviceName = "";
                switch(serviceCode){
                    case "P":
                        serviceName="PHARMACY";
                        break;
                    case "L":
                        serviceName="LAB";
                        break;
                    case "T":
                        serviceName="TRIAGE";
                        break;                      
                    case "C":
                        serviceName="COUNSELLING";
                        break;
                    default:
                        serviceName="UNKNOWN";
                        break;
                }
                if (serviceName.equals("TRIAGE")) {
                    if (healthMetric == 1) {
System.out.println("Summary: " + serviceName + " | ID=" + id + " | BMI=" + bmi + " | Code=" + displayCode);
                      } else if (healthMetric == 2) {
                      System.out.println("Summary: " + serviceName + " | ID=" + id + " | Tablets=" + dose + " | Code=" + displayCode);
                     } else if (healthMetric == 3) {
                    System.out.println("Summary: " + serviceName + " | ID=" + id + " | sin=" + sineAngle + " | Code=" + displayCode);
                    } else {
                    System.out.println("Summary: " + serviceName + " | ID=" + id + " | Code=" + displayCode);
                       }
                   } else {
                    System.out.println("Summary: " + serviceName + " | ID=" + id + " | Code=" + displayCode);
              }
                input.close();
            }
        }
