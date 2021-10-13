/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arep.parcial2.spark;

/**
 *
 * @author jgarc
 */
import static spark.Spark.*;
import co.edu.escuelaing.arep.parcial2.Calculadora;
import org.json.simple.JSONObject;


public class SparkServer 
{
    public static void main( String[] args )
    {
        JSONObject json = new JSONObject(); 
        port(getPort());
        get("/log", (req, res) -> {
            Double value = Double.parseDouble(req.queryParams("value"));
            Calculadora calculator = new Calculadora();
            json.put("operation", "log" ); 
            json.put("input", value ); 
            json.put("output" , calculator.log(value) ); 
            return json;
        });
        
        get("/asin", (req,res) -> {
            Double value = Double.parseDouble(req.queryParams("value"));
            Calculadora calculator = new Calculadora();
            json.put("operation", "log" ); 
            json.put("input", value ); 
            json.put("output" , calculator.asin(value) ); 
            return json;
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
