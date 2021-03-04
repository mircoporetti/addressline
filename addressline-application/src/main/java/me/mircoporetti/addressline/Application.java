package me.mircoporetti.addressline;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.mircoporetti.addressline.address.AddressMessageRequest;
import me.mircoporetti.addressline.address.AddressPresenter;
import me.mircoporetti.addressline.address.parser.InlineAddressParserFactory;
import me.mircoporetti.addressline.address.usecase.Addressline;
import me.mircoporetti.addressline.address.usecase.AddresslineUseCase;
import me.mircoporetti.addressline.address.usecase.port.ParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    I organized the project following a Clean Architecture style.
    I left the Application class as last things to think about.
    In my opinion it wouldn't be very interesting to start from this class because there is only the standard input reading
    and the standard output of received data. If necessary, it would be easy to remove the loop and read only once the input or else.
    For this reason it made sense to start writing tests from the domain to explore the business logic and then to go outside implementing
    the presentation. This way to me it has been irrelevant if the application was a Rest Api, a console api etc...
*/
public class Application {

    public static void main(String[] args) {
        AddressPresenter addressPresenter = initializeApplicationComponents();

        do {
            System.out.println("Write an address or type \"quit\" to exit");
            String address = readFromStandardInput();
            if(address.equalsIgnoreCase("quit")){
                System.out.println("Bye Bye :)");
                break;
            }else{
                System.out.println("\nParsing the address...");
                try {
                    String addressResult = addressPresenter.parseAddress(new AddressMessageRequest(address));
                    System.out.println(addressResult + "\n");
                }catch(Exception e){
                    System.out.println(e.getMessage() + "\n");
                }
            }
        }while(true);
    }

    private static AddressPresenter initializeApplicationComponents() {

        ObjectMapper objectMapper = new ObjectMapper();
        ParserFactory parserFactory = new InlineAddressParserFactory();
        AddresslineUseCase addresslineUseCase = new Addressline(parserFactory);
        return new AddressPresenter(addresslineUseCase, objectMapper);
    }

    public static String readFromStandardInput() {
        String line = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
