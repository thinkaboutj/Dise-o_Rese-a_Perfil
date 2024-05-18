/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author jesus
 */
public class ConexionBD {
    
    private static MongoClient mongoClient;
    private static final String direccion = "mongodb://localhost:27017/";
    private static final String nombreBD = "tienda_virtual";
    
    

    private ConexionBD() {
    }


    public static MongoDatabase getDatabase() {

        //Configuracion del codec para manejar POJOs
        if (mongoClient == null) {
            CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
            );

            //Configuracion los ajustes del cliente MongoBD,incluyendo cadena de conexion (URL) y el registro de codecs anteriores
            MongoClientSettings clientSettings = MongoClientSettings.builder()
                    .applyConnectionString(new com.mongodb.ConnectionString(direccion))
                    .codecRegistry(pojoCodecRegistry)
                    .build();

            //Se asignan los ajustes del MongoClient static class
            mongoClient = MongoClients.create(clientSettings);
            //Se regresan los datos a la base de datos con la configuracion de codecs
            return mongoClient.getDatabase(nombreBD).withCodecRegistry(pojoCodecRegistry);

        }

        //Si ya existe (no null) se reghresa nuevamente
        return mongoClient.getDatabase(nombreBD);

    }

    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }
    
}
